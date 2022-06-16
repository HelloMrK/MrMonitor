package indi.likai.mrm.domain;

import indi.likai.mrm.enums.ServerTypeEnum;

/**
 * 服务器信息
 */
public class ServerInfo {
    /** id */
    private Integer id;
    /** ip */
    private String ip;
    /** 端口 */
    private Integer port;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 服务器os类型 */
    private ServerTypeEnum servertype;
    /** 备注 */
    private String remark;

    /** 盘符(win用)   "C:\\" */
    private String diskpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServerTypeEnum getServertype() {
        return servertype;
    }

    public void setServertype(ServerTypeEnum servertype) {
        this.servertype = servertype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDiskpath() {
        return diskpath;
    }

    public void setDiskpath(String diskpath) {
        this.diskpath = diskpath;
    }


    public ServerInfo(){}

    public ServerInfo(String ip, Integer port, String username, String password, ServerTypeEnum servertype, String remark) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.servertype = servertype;
        this.remark = remark;
    }

    public ServerInfo(String ip, Integer port, ServerTypeEnum servertype, String remark, String diskpath) {
        this.ip = ip;
        this.port = port;
        this.servertype = servertype;
        this.remark = remark;
        this.diskpath = diskpath;
    }
}

