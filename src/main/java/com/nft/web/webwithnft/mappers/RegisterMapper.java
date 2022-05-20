package com.nft.web.webwithnft.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nft.web.webwithnft.model.Register;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper extends BaseMapper<Register>{
    int insert(Register register);

    Register getRegister(String address);
}
