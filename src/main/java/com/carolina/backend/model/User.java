package com.carolina.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    public @Email(message = "Insira um email válido!") @NotBlank(message = "O email é obrigatório!") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Insira um email válido!") @NotBlank(message = "O email é obrigatório!") String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório!") @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório!") @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A senha é obrigatória!") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatória!") String senha) {
        this.senha = senha;
    }

    public @NotBlank(message = "O telefone é obrigatório!") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatório!") String telefone) {
        this.telefone = telefone;
    }
}

