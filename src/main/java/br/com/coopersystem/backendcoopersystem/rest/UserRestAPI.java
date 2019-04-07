package br.com.coopersystem.backendcoopersystem.rest;

import br.com.coopersystem.backendcoopersystem.model.security.User;
import br.com.coopersystem.backendcoopersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API de usuários
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestAPI {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios() {

        List<User> users = this.userService.listar();

        if (users.size() > 0) {
            return ResponseEntity.ok(users);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> buscarUsuario(@PathVariable("idUser") Long idUser) {

        User user = this.userService.buscarPorId(idUser);

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User user) {

        User usuarioSalvo = this.userService.cadastrar(user);

        if (usuarioSalvo != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> deletarUsuario(@PathVariable("idUser") Long idUser) {

        User user = this.userService.buscarPorId(idUser);
        User deletedUser = this.userService.deletar(user);

        if (deletedUser != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
