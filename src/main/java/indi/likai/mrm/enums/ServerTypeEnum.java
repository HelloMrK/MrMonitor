package indi.likai.mrm.enums;

/**
 * 服务器os类型
 */
public enum ServerTypeEnum {
    WIN("windows"),LINUX("linux");
    /** 服务器os类型 */
    private String type;

    ServerTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
