package com.corn.boot.base;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.pojobase.BaseOrder;
import com.corn.boot.base.pojobase.BaseRes;
import com.corn.boot.enums.StatusEnum;
import com.corn.boot.error.BizError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ObjectUtils;

/**
 * 事物实现保证类
 */

public abstract class AbstractBizService<O extends BaseOrder, R extends BaseRes> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected TransactionTemplate transactionTemplate;

    @Value("${debug.log}")
    private String debugLog;

    public final R execute(String bieMemo, O order) {

        boolean isShowDebugLog = debugLog.equals("Y") ? true : false;
        logger.info("收到业务[{}]处理请求，请求参数：{}", bieMemo, order);
        //1.初始化result
        R result = initResult();
        try {

            //2.设置默认应答
            setDefaultResult(result);

            //3.参数校验
            orderCheck(order);

            //4.执行业务逻辑
            if (checkTranscation()) {
                bailBizInTranscation(order,result);
            } else {
                doAppBiz(order, result);
            }


        } catch (IllegalArgumentException ie) {

            //参数校验错误(未知)
            logger.error("参数类型异常[入参：{}，msgError：{}]", order, ie.getMessage());
            result.setStatus(StatusEnum.FAIL);
            result.setMessage("参数类型异常，请核实");
            result.setCode(HttpBase.HTTP_RESPONSE_FAIL_CODE);
            if(isShowDebugLog){
                ie.printStackTrace();;
            }
        } catch (BizError bizError) {

            logger.warn("系统业务错误[入参：{}，msgError：{}，errorCode：{}]", order, bizError.getMessage(), HttpBase.HTTP_RESPONSE_FAIL_CODE);
            result.setStatus(StatusEnum.FAIL);
            result.setMessage(bizError.getMessage());
            result.setCode(HttpBase.HTTP_RESPONSE_FAIL_CODE);
            if(isShowDebugLog){
                bizError.printStackTrace();;
            }

        } catch (Exception e) {

            //系统未知错误，抛出详细异常信息
            logger.error("系统未知错误[入参：{}，msgError：{}]", order, e.getMessage());
            result.setStatus(StatusEnum.FAIL);
            result.setMessage("系统繁忙");
            result.setCode(HttpBase.HTTP_RESPONSE_FAIL_CODE);
            if(isShowDebugLog){
                e.printStackTrace();;
            }

        } finally {

            if (result.isSuccess()) {
                logger.info("[{}]处理成功，结果：{}", bieMemo, result);
            } else if (result.isProcessing()) {
                logger.info("[{}]处理中，结果：{}", bieMemo, result.toString());
            } else {
                logger.info("[{}]处理失败，原因：[{}]，结果：{}", bieMemo, result.getMessage(), result);
            }

            //打印摘要日志
            MDC.clear();
        }
        return result;
    }


    /**
     * 实例化result对象
     *
     * @return
     */
    protected abstract R initResult();

    /**
     * 参数校验
     */
    protected abstract void orderCheck(O order);

    /**
     * 设置默认应答
     */
    private void setDefaultResult(R result) {
        result.setStatus(StatusEnum.SUCCESS);
        result.setCode(HttpBase.HTTP_RESPONSE_SUCCESS_CODE);
        result.setMessage("执行成功");
    }


    private void doAppBiz(O order, R result) {
        appBiz(order, result);
    }

    /**
     * 业务执行方法
     *
     * @param order
     * @return
     */
    protected abstract void appBiz(O order, R result);

    /**
     * 带事务的方法执行
     * */
    private void bailBizInTranscation(O order,R result){
        logger.info("------ 开始执行事务方法 -------");
        Biz biz = new Biz(order,result);
        transactionTemplate.execute(biz);
    }

    /**
     * 事务校验
     */
    private boolean checkTranscation() {
        DoTranscation doTranscation = this.getClass().getAnnotation(DoTranscation.class);
        if (!ObjectUtils.isEmpty(doTranscation)) {
            logger.info("事务校验[已开启事务]");
            return true;
        } else {
            logger.info("事务校验[已关闭事务]");
            return false;
        }
    }

    private class Biz implements TransactionCallback<Void> {

        private O order;

        private R result;

        public Biz(O order, R result) {
            this.order = order;
            this.result = result;
        }

        @Override
        public Void doInTransaction(TransactionStatus transactionStatus) {
            try{
                appBiz(order,result);
            }catch (Exception e){
                transactionStatus.setRollbackOnly();
                throw e;
            }
            return null;
        }
    }

}