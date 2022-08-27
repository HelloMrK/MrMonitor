package indi.likai.mrm.dto;

import indi.likai.mrm.enums.ServerTypeEnum;

import java.math.BigDecimal;

/**
 * 服务器信息返回类
 */
public class ServerStatus {
    /** BigDecimal除法保留位数 */
    private static final Integer DIVIDE_SCALE=4;
    /** 服务器IP */
    private String serverIp;
    /** 服务器备注 */
    private String serverRemark;
    private Enum<ServerTypeEnum> serverType;

    /** 总内存(MB) */
    private BigDecimal totalMemSize;
    /** 已使用内存(MB) */
    private BigDecimal usedMemSize;
    /** 已使用内存率(%) */
    private BigDecimal usedMemRate;
    /** 已使用CPU(%) */
    private BigDecimal usedCpuRate;

    /** 硬盘总空间(GB) */
    private BigDecimal totalDiskSize;

    /** 硬盘已用空间(GB) */
    private BigDecimal usedDiskSize;

    /** 硬盘已用空间(%) */
    private BigDecimal usedDiskRate;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Enum<ServerTypeEnum> getServerType() {
        return serverType;
    }

    public void setServerType(Enum<ServerTypeEnum> serverType) {
        this.serverType = serverType;
    }

    public String getServerRemark() {
        return serverRemark;
    }

    public void setServerRemark(String serverRemark) {
        this.serverRemark = serverRemark;
    }

    public BigDecimal getTotalMemSize() {
        return totalMemSize;
    }

    public void setTotalMemSize(BigDecimal totalMemSize) {
        this.totalMemSize = totalMemSize;
    }

    public BigDecimal getUsedMemSize() {
        return usedMemSize;
    }

    public void setUsedMemSize(BigDecimal usedMemSize) {
        this.usedMemSize = usedMemSize;
    }

    public BigDecimal getUsedMemRate() {
        return usedMemRate;
    }

    public void setUsedMemRate(BigDecimal usedMemRate) {
        this.usedMemRate = usedMemRate;
    }

    public BigDecimal getTotalDiskSize() {
        return totalDiskSize;
    }

    public void setTotalDiskSize(BigDecimal totalDiskSize) {
        this.totalDiskSize = totalDiskSize;
    }

    public BigDecimal getUsedDiskSize() {
        return usedDiskSize;
    }

    public void setUsedDiskSize(BigDecimal usedDiskSize) {
        this.usedDiskSize = usedDiskSize;
    }

    public BigDecimal getUsedDiskRate() {
        return usedDiskRate;
    }

    public void setUsedDiskRate(String usedDiskRate) {
        this.usedDiskRate = new BigDecimal(usedDiskRate.replace("%","").trim());
    }
    public void setUsedDiskRate(BigDecimal usedDiskRate) {
        this.usedDiskRate = usedDiskRate;
    }

    public BigDecimal getUsedCpuRate() {
        return usedCpuRate;
    }

    public void setUsedCpuRate(BigDecimal usedCpuRate) {
        this.usedCpuRate = usedCpuRate;
    }

    /**
     * 计算已使用内存率
     */
    public void calcUsedMemRate() {
        this.usedMemRate = (BigDecimal.valueOf(100).multiply(
                this.usedMemSize.divide(this.totalMemSize,DIVIDE_SCALE,BigDecimal.ROUND_HALF_DOWN)
            )
        ).setScale(2);
    }

    @Override
    public String toString() {
        return "ServerStatus{" +
                "serverIp='" + serverIp + '\'' +
                ", serverRemark='" + serverRemark + '\'' +
                ", serverType=" + serverType +
                ", totalMemSize=" + totalMemSize +
                ", usedMemSize=" + usedMemSize +
                ", usedMemRate=" + usedMemRate +
                ", usedCpuRate=" + usedCpuRate +
                ", totalDiskSize=" + totalDiskSize +
                ", usedDiskSize=" + usedDiskSize +
                ", usedDiskRate=" + usedDiskRate +
                '}';
    }
}
