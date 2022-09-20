package com.example.provamutant.Atividade2.Validators;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.Arrays;

@Component
public class ValidationsImagemBitmap {
    public void validador(String[] elements) {
        validarNulo(elements);
        validarNegativos(elements);
        validarLetras(elements);
        validarInterValo(elements);
        validarQuantidadeMinima(elements);
    }

    private void validarNegativos(String[] elements){
            for (String element : elements) {
                if (element.startsWith("-")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Números negativos como " + element + " não pertence aos {0,1...15}");
                }
                if (elements.length < 16) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Foram informados apenas " + elements.length + " numeros, por favor informe 16 valores");
                }
            }
    }

    private void validarLetras(String[] elements){
            for (String element : elements) {
                if (!element.matches("^[0-9]*$")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Elemento " + element + " não é um número");
                }
            }
    }

    private void validarInterValo(String[] elements){
            for (String element : elements) {
                if (Integer.parseInt(element) > 15) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Número " + element + " fora do intervalo");
                }
            }
    }

    private void validarQuantidadeMinima(String[] elements) {
            for (String element : elements) {
                if (element.startsWith("-")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Números negativos como " + element + " não pertence aos {0,1...15}");
                }
            }
    }
    private void validarNulo(String[] elements) {
        Arrays.stream(elements).forEach(elementos ->{
            if (elementos.isBlank()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não pode conter valores nulos na entrada do vator");
            }
        });
    }
}
