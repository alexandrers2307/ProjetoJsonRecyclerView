package com.example.jsonrecyclerview;


public class Filme_Classe {

    String id;
    String nome;
    String img;

    public Filme_Classe(String id, String nome, String img) {
        this.id = id;
        this.nome = nome;
        this.img = img;
    }

    public Filme_Classe() {
    }

    public static void add(Filme_Classe model) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}