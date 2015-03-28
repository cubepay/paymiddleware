package com.cubepayment.pmw.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cybersource_configuration")
public class CybersourceConfigurationEntity extends BaseEntity {
    private static final long serialVersionUID = 3532971239015419081L;

    private String endpointURL;

    private String profileId;

    private String accessKey;

    private String secretKey;

    public String getEndpointURL() {
        return endpointURL;
    }

    public void setEndpointURL(String endpointURL) {
        this.endpointURL = endpointURL;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

