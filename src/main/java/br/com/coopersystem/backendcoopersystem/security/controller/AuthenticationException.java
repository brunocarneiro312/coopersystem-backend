package br.com.coopersystem.backendcoopersystem.security.controller;

/**
 * Exception de autenticação
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}