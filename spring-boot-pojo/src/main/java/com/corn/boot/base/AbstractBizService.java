package com.corn.boot.base;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.enums.Status;
import com.corn.boot.error.BizError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ObjectUtils;

/**
 * 事物实现保证类
 */

public abstract class AbstractBizService<O extends BaseOrder, R extends BaseRes> {
    private final Logger logger = LoggerFactory.getLogger(AbstractBizService.class);

    @Autowired
    protected TransactionTemplate transactionTemplate;

    public final R execute(String bieMemo, O order) {
        logger.info("收到业务[{}]处理请求，请求参数：{}", bieMemo, order);
        //1.初始化result
        R result = initResult();
        try {
            //2.设置默认应答
            setDefaultResult(result);
            //3.参数校验
            orderCheck(order);
            //4.执行业务逻辑
            //业务预处理
            if (checkTranscation()) {
                bailBizInTranscation(order,result);
            } else {
                doAppBiz(order, result);
            }


        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
            //参数校验错误(未知)
            logger.error("参数类型异常[订单：{}，msgError：{}]", order, ie.getMessage());
            result.setStatus(Status.FAIL);
            result.setMessage("参数类型异常，请核实");
        } catch (BizError bizError) {
            logger.warn("系统业务错误[订单：{}，msgError：{}，errorCode：{}]", order, bizError.getMessage(), bizError.getCode());
            result.setStatus(Status.FAIL);
            result.setMessage(bizError.getMessage());
            result.setCode(bizError.getCode());
        } catch (Exception e) {
            //系统未知错误，抛出详细异常信息
            logger.error("系统未知错误[订单：{}，msgError：{}]", order, e.getMessage(), e);
            result.setStatus(Status.FAIL);
            result.setMessage("系统繁忙");
        } finally {

            if (result.isSuccess()) {
                logger.info("[{}]处理成功，结果：{}", bieMemo, result);
            } else if (result.isProcessing()) {
                logger.info("[{}]处理中，结果：{}", bieMemo, result.toString());
            } else {
                logger.info("[{}]处理失败，原因：[{}]，结果：{}", bieMemo, result.getMessage(), result.toString());
            }

            //打印摘要日志
            MDC.clear();
        }

        logger.info("业务[{}]处理结束，返回参数：result={}", result.toString());

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
        result.setStatus(Status.SUCCESS);
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

        Biz biz = new Biz(order,result);
        transactionTemplate.equals(biz);
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