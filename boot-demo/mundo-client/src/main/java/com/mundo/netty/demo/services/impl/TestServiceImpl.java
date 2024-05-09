package com.mundo.netty.demo.services.impl;

import com.mundo.netty.demo.constants.Constants;
import com.mundo.netty.demo.services.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String testIdempotence() {
        return Constants.SUCCESS;
    }
}
