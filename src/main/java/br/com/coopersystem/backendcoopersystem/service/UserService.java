package br.com.coopersystem.backendcoopersystem.service;

import br.com.coopersystem.backendcoopersystem.model.security.User;

import java.util.List;

public interface UserService {

    User cadastrar(User user);

    User alterar(User user);

    User buscarPorId(Long userId);

    User deletar(User user);

    List<User> listar();

    User buscarPorUsername(String username);

    User buscarPorUserNameEPassword(String username, String password);
}
