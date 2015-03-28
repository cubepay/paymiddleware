package com.cubepayment.pmw.data.entity;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class MerchantEntity extends BaseEntity {
    private static final long serialVersionUID = -5154192011073876131L;

    private String merchantName;

    private String merchantResponseURL;

    @OneToOne
    private CybersourceConfigurationEntity cybersourceConfigurationEntity;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public CybersourceConfigurationEntity getCybersourceConfigurationEntity() {
        return cybersourceConfigurationEntity;
    }

    public void setCybersourceConfigurationEntity(CybersourceConfigurationEntity cybersourceConfigurationEntity) {
        this.cybersourceConfigurationEntity = cybersourceConfigurationEntity;
    }

    public String getMerchantResponseURL() {
        return merchantResponseURL;
    }

    public void setMerchantResponseURL(String merchantResponseURL) {
        this.merchantResponseURL = merchantResponseURL;
    }
}
