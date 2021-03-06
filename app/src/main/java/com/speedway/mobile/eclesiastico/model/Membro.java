package com.speedway.mobile.eclesiastico.model;

/**
 * @author ferrari
 */
public class Membro {

    private Long id;

    private String fotoBase64;

    private String senha;

    private String nome;

    private String email;

    private Long dataNascimento;

    private String telefone;


    private boolean lideranca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Long dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public boolean isLideranca() {
        return lideranca;
    }

    public void setLideranca(boolean lideranca) {
        this.lideranca = lideranca;
    }
}
