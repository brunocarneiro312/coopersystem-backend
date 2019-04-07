package br.com.coopersystem.backendcoopersystem.security;

import br.com.coopersystem.backendcoopersystem.model.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String nome;
    private final String password;
    private final List<Email> emails;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean ativo;

    public JwtUser(Long id,
                   String username,
                   String nome,
                   String password,
                   List<Email> emails,
                   Collection<? extends GrantedAuthority> authorities,
                   boolean ativo) {

        this.id = id;
        this.username = username;
        this.nome = nome;
        this.password = password;
        this.emails = emails;
        this.authorities = authorities;
        this.ativo = ativo;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public boolean isAtivo() {
        return ativo;
    }
}