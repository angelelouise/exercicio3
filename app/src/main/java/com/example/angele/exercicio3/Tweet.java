package com.example.angele.exercicio3;

import java.util.Date;

/**
 * Created by angele on 17/03/18.
 * texto
 * autor
 * data
 */

public class Tweet {

    private String texto;
    private String autor;
    private Date data = new Date();

    @Override
    public String toString() {
        String content = texto + "\n" + autor +"\n" + data;
        return content;
    }

    /*
         Getters
        */
    public String getAutor() {
        return autor;
    }

    public Date getData() {
        return data;
    }

    public String getTexto() {
        return texto;
    }

    /*
    Setters
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
