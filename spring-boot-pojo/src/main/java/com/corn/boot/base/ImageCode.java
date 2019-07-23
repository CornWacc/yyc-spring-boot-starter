package com.corn.boot.base;

/**
 * @author yyc
 * @apiNote 验证码实体
 * */
public class ImageCode extends Base {
    private static final long serialVersionUID = -2834511249115152896L;

    public static final String IMAGE_CODE_REDIS = "USER_LOGIN:IMAGE_CODE:";

    /**
     * 图片地址
     * */
    private String base64Image;

    /**
     * 验证码
     * */
    private String code;

    public ImageCode(String base64Image, String code) {
        this.base64Image = base64Image;
        this.code = code;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
