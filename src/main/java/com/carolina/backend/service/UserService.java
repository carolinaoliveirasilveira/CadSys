package com.carolina.backend.service;

import com.carolina.backend.model.User;
import com.carolina.backend.repository.UserRepository;
import com.carolina.backend.dto.UserDto;
import com.carolina.backend.security.Token;
import com.carolina.backend.security.TokenUtil;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> listUsers() {
        logger.info("User: " + getLogged() + " Listando Usuarios");
        return userRepository.findAll();
    }

    public User createUser(User user) {
        String encoder = this.passwordEncoder.encode(user.getSenha());
        user.setSenha(encoder);
        logger.info("User: " + getLogged() + " Criando User");
        return userRepository.save(user);
    }


    public User editUser(User user) {
        String encoder = this.passwordEncoder.encode(user.getSenha());
        user.setSenha(encoder);
        logger.info("User: " + getLogged() + " Editando User: " + user.getNome());
        return userRepository.save(user);
    }


    public Boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        logger.info("User: " + getLogged() + " Excluindo User");

        return true;
    }

    public Boolean validatePassword(User user) {
        String senha = userRepository.getById(user.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(user.getSenha(), senha);
        return valid;
    }


    public Token generateToken(@Valid UserDto usuario) {
        User user = UserRepository.findByNomeOrEmail(usuario.getName(), usuario.getEmail());
        if (user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getPassword(), user.getSenha());
            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

    private String getLogged() {
        Authentication userLogged = SecurityContextHolder.getContext().getAuthentication();
        if (!(userLogged instanceof AnonymousAuthenticationToken)) {
            return userLogged.getName();
        }
        return "Null";
    }

}
