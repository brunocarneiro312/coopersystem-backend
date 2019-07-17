package br.com.coopersystem.backendcoopersystem.security.controller;

import br.com.coopersystem.backendcoopersystem.model.security.User;
import br.com.coopersystem.backendcoopersystem.security.JwtAuthenticationRequest;
import br.com.coopersystem.backendcoopersystem.security.JwtTokenUtil;
import br.com.coopersystem.backendcoopersystem.security.JwtUser;
import br.com.coopersystem.backendcoopersystem.security.service.JwtAuthenticationResponse;
import br.com.coopersystem.backendcoopersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Objects;

/**
 * API utilizada para fins de autenticação.
 * A autenticação utiliza JWT (JSON Web Token)
 */
@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        User user = this.userService.buscarPorUsername(authenticationRequest.getUsername());

        if (user != null) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            boolean passwordMatches = passwordEncoder.matches(
                    authenticationRequest.getPassword(),
                    user.getPassword());

            if (passwordMatches) {

                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequest.getUsername());

                final String token = jwtTokenUtil.generateToken(userDetails);

                User loggedUser = this.userService.buscarPorUsername(userDetails.getUsername());

                ArrayList<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());

                JwtUser jwtUser = new JwtUser(loggedUser.getId(),
                        loggedUser.getUsername(),
                        loggedUser.getNome(),
                        "<secret>",
                        loggedUser.getEmails(),
                        authorities,
                        loggedUser.getAtivo());

                return ResponseEntity.ok(new JwtAuthenticationResponse(token, jwtUser));
            }

        }



        return new ResponseEntity<>("Bad Credentials", HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken, user));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("Usuário não habilitado", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Erro de autenticação", e);
        }
    }

    private void authenticate(UserDetails userDetails) {
        Objects.requireNonNull(userDetails.getUsername());
        Objects.requireNonNull(userDetails.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDetails.getUsername(),
                            userDetails.getPassword(),
                            userDetails.getAuthorities()));

        } catch (DisabledException e) {
            throw new AuthenticationException("Usuário não habilitado", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Erro de autenticação", e);
        }
    }
}