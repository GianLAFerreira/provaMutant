package com.example.provamutant.Atividade3.Model;

import java.util.ArrayList;

public class SuperHeroiModel {
    private String codigo;
    private String nome;
    private ArrayList<VoltaModel> voltas;

    private int tempoTotal = 0;

    public SuperHeroiModel(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.voltas = new ArrayList<>();
    }

    public SuperHeroiModel() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<VoltaModel> getVoltas() {
        return voltas;
    }

    public void setVoltas(ArrayList<VoltaModel> voltas) {
        this.voltas = voltas;
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
}
