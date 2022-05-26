package com.nft.web.webwithnft.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
// @TableName("register_address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Register {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
