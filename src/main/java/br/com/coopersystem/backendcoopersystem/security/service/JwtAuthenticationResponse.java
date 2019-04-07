package br.com.coopersystem.backendcoopersystem.security.service;

import br.com.coopersystem.backendcoopersystem.security.JwtUser;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final JwtUser jwtUser;

    public JwtAuthenticationResponse(String token, JwtUser jwtUser) {
        this.token = token;
        this.jwtUser = jwtUser;
    }

    public String getToken() {
        return this.token;
    }

    public JwtUser getJwtUser() {
        return jwtUser;
    }
}