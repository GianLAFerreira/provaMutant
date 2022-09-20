package com.example.provamutant.Atividade1;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class ImageBitmap {

    private String[][] map;


    public String buscaAsOcorrencias(Ocorrencia ocorrencia) {
        inicializaImagemBitmap();
        validador(ocorrencia);
        return escreverOccurrencias(ocorrencia, buscaNumeroDeOcorrencias(ocorrencia, this.map));
    }

    private void validador(Ocorrencia ocorrencia) {
        for (String element : ocorrencia.getIndex()) {
            if (element.startsWith("-")) {
                throw new RuntimeException("Números negativos como " + element + " não pertence aos {0,1...15}");
            }
            if (!element.matches("^[0-9]*$")) {
                throw new RuntimeException("Elemento " + element + " não é um número");
            }
            if (Integer.parseInt(element) > 15) {
                throw new RuntimeException("Número " + element + " fora do intervalo");
            }
            if (element.isEmpty()) {
                throw new RuntimeException("Array[n] não pode ser vazio");
            }
            if (ocorrencia.getIndex().length < 16) {
                throw new RuntimeException("Foram apenas informados " + ocorrencia.getIndex().length + " numeros, por favor informe 16 valores");
            }
        }
    }

    private int[] buscaNumeroDeOcorrencias(Ocorrencia ocorrencia, String[][] map) {
        int[] elementOccurrences = new int[ocorrencia.getIndex().length];

        for (int rowIndex = 0; rowIndex < ocorrencia.getIndex().length; rowIndex++) {
            int index = rowIndex;
            Arrays.stream(map).forEach(mapRow -> {
                Arrays.stream(mapRow).forEach(mapElement -> {
                    if (mapElement.equals(ocorrencia.getIndex()[index])) {
                        elementOccurrences[index]++;
                    }
                });
            });
        }
        return elementOccurrences;
    }

    private String escreverOccurrencias(Ocorrencia ocorrencia, int[] elementOccurrences) {
        StringBuilder occurrences = new StringBuilder();
        for (int index = 0; index < ocorrencia.getIndex().length; index++) {
            occurrences.append("Elemento ")
                    .append(ocorrencia.getIndex()[index])
                    .append(" encontrado ")
                    .append(elementOccurrences[index])
                    .append(" vezes")
                    .append("\n");
        }
        return occurrences.toString();
    }

    public String[][] inicializaImagemBitmap() {
        this.map = new String[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                map[row][column] = String.valueOf((int) (Math.random() * 16));
            }
        }
        return map;
    }
}
