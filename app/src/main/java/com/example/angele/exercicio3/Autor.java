package com.example.angele.exercicio3;

import java.io.Serializable;

/**
 * Created by angele on 06/04/18.
 */

public class Autor implements Serializable{
    String nome;
    String telefone;
    String email;

    public Autor(String nome, String telefone, String email){
        this.nome=nome;
        this.telefone=telefone;
        this.email=email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
