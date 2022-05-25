package indi.likai.mrm.domain;

import java.math.BigDecimal;

/**
 * 服务器信息返回类
 */
public class ResultInfo {
    /** BigDecimal除法保留位数 */
    private static final Integer DIVIDE_SCALE=4;
    /** 服务器IP */
    private String serverIp;
    /** 服务器备注 */
    private String serverRemark;
    /** 总内存(MB) */
    private BigDecimal totalMemSize;
    /** 已使用内存(MB) */
    private BigDecimal usedMemSize;
    /** 已使用内存率(%) */
    private BigDecimal usedMemRate;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
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

    /**
     * 计算已使用内存率
     */
    public void calcUsedMemRate() {
        this.usedMemRate = (BigDecimal.valueOf(100).multiply(
                this.usedMemSize.divide(this.totalMemSize,DIVIDE_SCALE,BigDecimal.ROUND_HALF_DOWN)
            )
        ).setScale(2);
    }
}
