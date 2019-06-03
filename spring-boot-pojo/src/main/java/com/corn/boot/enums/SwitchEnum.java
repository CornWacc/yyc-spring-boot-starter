package com.corn.boot.enums;


/**
 * @author yyc
 * @apiNote 开关枚举
 */
public enum SwitchEnum {

    OPEN("OPEN", "开启"),
    CLOSE("CLOSE", "关闭");

    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    SwitchEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static SwitchEnum getByCode(String code) {
        for (SwitchEnum status : values()) {
            if (status.code().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
