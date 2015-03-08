package com.cubepayment.pmw.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_configuration")
public class MerchantConfigurationEntity extends BaseEntity{
    private static final long serialVersionUID = 3532971239015419081L;

    @Column(name="mid")
    private String mid;

    @Column(name="cybersource_merchant_id")
    private String cybersourceMerchantId;

    @Column(name="cybersource_username")
    private String cybersourceUserName;

    @Column(name="cybersource_password")
    private String cybersourcePassword;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCybersourceMerchantId() {
        return cybersourceMerchantId;
    }

    public void setCybersourceMerchantId(String cybersourceMerchantId) {
        this.cybersourceMerchantId = cybersourceMerchantId;
    }

    public String getCybersourceUserName() {
        return cybersourceUserName;
    }

    public void setCybersourceUserName(String cybersourceUserName) {
        this.cybersourceUserName = cybersourceUserName;
    }

    public String getCybersourcePassword() {
        return cybersourcePassword;
    }

    public void setCybersourcePassword(String cybersourcePassword) {
        this.cybersourcePassword = cybersourcePassword;
    }
}

