package com.cubepayment.pmw.data.entity;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class MerchantEntity extends BaseEntity {
    private static final long serialVersionUID = -5154192011073876131L;

    private String merchantName;

    @OneToOne
    private MerchantConfigurationEntity merchantConfigurationEntity;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public MerchantConfigurationEntity getMerchantConfigurationEntity() {
        return merchantConfigurationEntity;
    }

    public void setMerchantConfigurationEntity(MerchantConfigurationEntity merchantConfigurationEntity) {
        this.merchantConfigurationEntity = merchantConfigurationEntity;
    }
}
