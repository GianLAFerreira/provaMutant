package com.example.provamutant.Atividade2.Service.impl;
import com.example.provamutant.Atividade2.Validators.ValidationsImagemBitmap;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImagemBitmapServiceImpl {
    @Inject
    ValidationsImagemBitmap validationsImagemBitmap;


    public List<String> buscaAsOcorrencias(String[] elements) {
        validationsImagemBitmap.validador(elements);

        return escreverOcorrencias(elements, buscaNumeroDeOcorrencias(elements,  inicializaImagemBitmap()));
    }

    private int[] buscaNumeroDeOcorrencias(String[] vetor, String[][] imagemBitmap) {
        int[] ocorrencia = new int[vetor.length];
        for (int rowIndex = 0; rowIndex < vetor.length; rowIndex++) {
            int index = rowIndex;
            Arrays.stream(imagemBitmap).forEach(mapRow -> {
                Arrays.stream(mapRow).forEach(mapElement -> {
                    if (mapElement.equals(vetor[index])) {
                        ocorrencia[index]++;
                    }
                });
            });
        }
        return ocorrencia;
    }

    private List<String> escreverOcorrencias(String[] elements, int[] elementOccurrences) {
        List<String> valores = new ArrayList<>();
        for (int index = 0; index < elements.length; index++) {
            String ocorrencia =  "O numero " + elements[index] + (" foi encontrado ") + elementOccurrences[index] + " vezes";
            valores.add(ocorrencia);
        }
        return valores;
    }

    public String[][] inicializaImagemBitmap() {
        String[][] imageBitmap = new String[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                imageBitmap[row][column] = String.valueOf((int) (Math.random() * 16));
            }
        }
        return imageBitmap;
    }
}
