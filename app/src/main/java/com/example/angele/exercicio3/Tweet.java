package com.example.angele.exercicio3;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by angele on 17/03/18.
 * texto
 * autor
 * data
 */

public class Tweet implements Serializable{

    public static final String TWEET_INFO = "TWEET_INFO";
    private String texto;
    //private String autor;
    private Autor autor;
    private Date data;

    //construtor para criar uma instancia
    public Tweet(String texto, Autor autor, Date data){
        this.data=data;
        this.texto=texto;
        this.autor=autor;

    }
    @Override
    public String toString() { //
        String content = texto + "\n" + autor +"\n" + data;
        return content;
    }

    /*
         Getters
        */
    public Autor getAutor() {
        return autor;
    }

    public Date getData() {
        return  data;
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

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
