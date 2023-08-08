package com.aquilamazzei.springhunter.utils.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.assign-key}")
    private String assignKey;




}
