package com.mundo.netty.demo.services;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    public String createToken();

    public boolean checkToken(HttpServletRequest request) throws Exception;

}
