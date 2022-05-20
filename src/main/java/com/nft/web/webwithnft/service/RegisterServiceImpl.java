package com.nft.web.webwithnft.service;

import com.nft.web.webwithnft.mappers.RegisterMapper;
import com.nft.web.webwithnft.model.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper mapper;

    @Override
    public int insert(Register register) {
        // TODO Auto-generated method stub
        int result = mapper.insert(register);
        
        return result;
    }

}
