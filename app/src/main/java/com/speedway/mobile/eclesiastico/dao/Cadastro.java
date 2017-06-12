package com.speedway.mobile.eclesiastico.dao;

/**
 * Created by ferrari on 03/06/2017.
 */

public class Cadastro {

    private String nome;
    private String email;
    private int telefone;
    private String senha;
    private String confirmasenha;
    private long id;

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public long getTelefone () {
        return telefone;
    }

    public void setTelefone (int telefone) {
        this.telefone = telefone;
    }

    public String getSenha () {
        return senha;
    }

    public void setSenha (String senha) {
        this.senha = senha;
    }

    public String getConfirmasenha () {
        return confirmasenha;
    }

    public void setConfirmasenha (String confirmasenha) {
        this.confirmasenha = confirmasenha;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }
}
