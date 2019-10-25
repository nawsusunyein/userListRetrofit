package com.example.userlistretrofit;

import com.google.gson.annotations.SerializedName;

public class UsersModel {
    @SerializedName("name")
    private String username;
    @SerializedName("address")
    private AddressModel address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("company")
    private CompanyModel companyInfo;

    UsersModel(String username,AddressModel address,String phone,CompanyModel companyInfo){
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.companyInfo = companyInfo;
    }
}
