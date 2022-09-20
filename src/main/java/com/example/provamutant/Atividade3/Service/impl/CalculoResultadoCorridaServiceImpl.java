package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CalculoResultadoCorridaServiceImpl {

    @Inject
    CalculoFormatoTempoServiceImpl calculoFormatoTempo;

    public String resultadosCorrida(List<SuperHeroiModel> winnersOrdered) {
        StringBuilder result = new StringBuilder();
        result.append("Corrida dos super Heróis: \n");
        AtomicInteger position = new AtomicInteger();
        winnersOrdered.forEach(superHero -> {
            position.getAndIncrement();
            result.append("Posição: ")
                    .append(position.get())
                    .append(" ");

            result.append(" Codigo do super herói: ")
                    .append(superHero.getCodigo());

            result.append(" Nome: ")
                    .append(superHero.getNome())
                    .append(" ");

            result.append(" Voltas: ")
                    .append(superHero.getVoltas().get(superHero.getVoltas().size() - 1).getNumeroVolta())
                    .append(" ");

            result.append(" TempoTotal: ")
                    .append(calculoFormatoTempo.transformarDuracao(superHero.getTempoTotal()))
                    .append("\n");
        });
        return String.valueOf(result);
    }
}
