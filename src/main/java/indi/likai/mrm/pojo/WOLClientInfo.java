package indi.likai.mrm.pojo;

import javax.persistence.*;

/**
 * 用于wol的pojo
 */
@Entity
@Table(name="mrm_wol_clientinfo")
public class WOLClientInfo {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "macaddress")
    private String macaddress;
    @Column(name = "ipaddress")
    private String ipaddress;
    @Column(name = "remark")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
