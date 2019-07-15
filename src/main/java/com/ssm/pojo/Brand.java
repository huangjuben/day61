package com.ssm.pojo;


import java.util.Date;

public class Brand {
    private long  brandId;
    private String brandName;
    private String telephone;
    private String brandWeb;
    private String brandLogo;
    private String brandDesc;
    private int brandStatus;
    private int brandOrder;
    private Date modifiedTime;

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", brandWeb='" + brandWeb + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", brandDesc='" + brandDesc + '\'' +
                ", brandStatus=" + brandStatus +
                ", brandOrder=" + brandOrder +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long  brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBrandWeb() {
        return brandWeb;
    }

    public void setBrandWeb(String brandWeb) {
        this.brandWeb = brandWeb;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public int getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(int brandStatus) {
        this.brandStatus = brandStatus;
    }

    public int getBrandOrder() {
        return brandOrder;
    }

    public void setBrandOrder(int brandOrder) {
        this.brandOrder = brandOrder;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Brand() {
    }
}
