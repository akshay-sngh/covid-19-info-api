package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Log {
    String ageRange;
    Date timeStamp;
    Date responseTime;
    String country;
    String buildBrand;
    String buildId;
    String applicationID;
    String buildModel;
    Long serviceLatencyInMS;

    @JsonProperty("ageRange")
    public String getAgeRange() {
        return this.ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    @JsonProperty("timeStamp")
    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("buildBrand")
    public String getBuildBrand() {
        return this.buildBrand;
    }

    public void setBuildBrand(String buildBrand) {
        this.buildBrand = buildBrand;
    }

    @JsonProperty("buildId")
    public String getBuildId() {
        return this.buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    @JsonProperty("applicationID")
    public String getApplicationID() {
        return this.applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    @JsonProperty("buildModel")
    public String getBuildModel() {
        return this.buildModel;
    }

    public void setBuildModel(String buildModel) {
        this.buildModel = buildModel;
    }

    public Long getServiceLatencyInMS() {
        return serviceLatencyInMS;
    }

    public void setServiceLatencyInMS(Long serviceLatencyInMS) {
        this.serviceLatencyInMS = serviceLatencyInMS;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }
}

