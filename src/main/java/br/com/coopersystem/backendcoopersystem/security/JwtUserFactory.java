package br.com.coopersystem.backendcoopersystem.security;

import java.util.List;
import java.util.stream.Collectors;

import br.com.coopersystem.backendcoopersystem.model.security.Authority;
import br.com.coopersystem.backendcoopersystem.model.security.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getNome(),
                user.getPassword(),
                user.getEmails(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getAtivo()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
