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

    @Override
    public String toString() {
        return "ServerInfo{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", servertype=" + servertype +
                ", remark='" + remark + '\'' +
                '}';
    }
}

