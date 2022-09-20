package com.example.provamutant.Atividade1;

public class Ocorrencia {
    private String[] index;

    public Ocorrencia() {
        initializarOccurrencias();
    }

    private void initializarOccurrencias() {
        this.index = new String[5];
        for (int row = 0; row < 5; row++) {
            this.index[row] = String.valueOf((int) (Math.random() * 16));
        }
    }
    public String[] getIndex() {
        return index;
    }

    public void setIndex(String[] in) {
        this.index = in;
    }
}
