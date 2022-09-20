package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CalculoBonusServiceImpl {

    @Inject
    CalculoMelhorVoltaCorridaServiceImpl calculoMelhorVoltaCorrida;
    @Inject
    CalculoMelhorVoltaSuperHeroiServiceImpl calcularMelhorVolta;
    @Inject
    CalculoVelocidadeMediaServiceImpl calculoVelocidadeMedia;

    public String calcularBonus(List<SuperHeroiModel> winnersOrdered) {
        StringBuilder result = new StringBuilder();
        result.append("\nTarefas Bônus :\n");
        result.append(calcularMelhorVolta.melhorVoltaFormatada(winnersOrdered));
        result.append("\n");
        result.append(calculoVelocidadeMedia.velocidadeMediaFormatada(winnersOrdered));
        result.append("\n")
              .append(calculoMelhorVoltaCorrida.melhorVoltaFormatadaDaCorrida(winnersOrdered));

        return String.valueOf(result);

    }
}
