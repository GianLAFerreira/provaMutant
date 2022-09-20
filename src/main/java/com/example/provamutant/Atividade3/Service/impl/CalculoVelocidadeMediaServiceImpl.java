package com.example.provamutant.Atividade3.Service.impl;

import antlr.StringUtils;
import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CalculoVelocidadeMediaServiceImpl {

    @Inject
    CalculoFormatoTempoServiceImpl calculoFormatoTempo;

    public String velocidadeMedia(SuperHeroiModel superHero) {
        int averageRaceVelocity = superHero.getTempoTotal() / superHero.getVoltas().size();
        return calculoFormatoTempo.transformarDuracao(averageRaceVelocity);
    }

    public String velocidadeMediaFormatada(List<SuperHeroiModel> winnersOrdered){
        StringBuilder result = new StringBuilder();
        result.append("{");
        winnersOrdered.forEach(superHero -> {
            result.append("\"Velocidade Media \": \"")
                    .append(superHero.getNome())
                    .append(" tempo médio: ")
                    .append(velocidadeMedia(superHero))
                    .append(" por volta")
                    .append("\", \n");
        });
        result.deleteCharAt(result.length()-1);
        result.deleteCharAt(result.length()-1);
        result.deleteCharAt(result.length()-1);
        result.append("}");

        return String.valueOf(result);
    }
}
