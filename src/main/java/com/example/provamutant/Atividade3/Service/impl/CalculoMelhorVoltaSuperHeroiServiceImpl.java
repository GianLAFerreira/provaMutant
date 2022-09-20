package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import com.example.provamutant.Atividade3.Model.VoltaModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CalculoMelhorVoltaSuperHeroiServiceImpl {
    @Inject
    CalculoFormatoTempoServiceImpl calculoFormatoTempo;


    public VoltaModel melhorVolta(SuperHeroiModel superHero) {
        AtomicReference<VoltaModel> bestLap = new AtomicReference<>(superHero.getVoltas().get(0));

        superHero.getVoltas().forEach(lap -> {
            if (calculoFormatoTempo.transformarDuracao(lap.getDuracaoVolta()) < calculoFormatoTempo.transformarDuracao(bestLap.get().getDuracaoVolta())) {
                bestLap.set(lap);
            }
        });

        return bestLap.get();
    }

    public String getInformacaoMelhorVolta(VoltaModel lap) {
        StringBuilder bestLapResult = new StringBuilder();
        bestLapResult
                .append(lap.getNumeroVolta())
                .append(" com duração: ")
                .append(lap.getDuracaoVolta())
                .append(" e velocidade média: ")
                .append(lap.getVelocidadeMediaVolta());

        return String.valueOf(bestLapResult);
    }

    public String melhorVoltaFormatada(List<SuperHeroiModel> winnersOrdered){
        StringBuilder result = new StringBuilder();
        result.append("{");
        winnersOrdered.forEach(superHero -> {
            result.append("\"Velocidade Media Super heroi\": \"")
                    .append(superHero.getNome())
                    .append(" melhor Volta: ")
                    .append(getInformacaoMelhorVolta(melhorVolta(superHero)))
                    .append("\", \n");

        });
        result.deleteCharAt(result.length()-1);
        result.deleteCharAt(result.length()-1);
        result.deleteCharAt(result.length()-1);
        result.append("}");
        return String.valueOf(result);
    }

    public List<SuperHeroiModel> melhorVoltaSuperHeroiOrdenada(List<SuperHeroiModel> superHeroes) {
        List<SuperHeroiModel> winnersOrdered = new ArrayList<>();
        HashMap<SuperHeroiModel, AtomicInteger> bestLapSuperheroMap = new HashMap<>();
        superHeroes.forEach(superHero -> {
            AtomicInteger bestLapDuration = new AtomicInteger();
            bestLapDuration.set(calculoFormatoTempo.transformarDuracao(melhorVolta(superHero).getDuracaoVolta()));
            bestLapSuperheroMap.put(superHero, bestLapDuration);
        });
        LinkedHashMap<SuperHeroiModel, AtomicInteger> collect = bestLapSuperheroMap.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<SuperHeroiModel, AtomicInteger>>comparingInt(a -> a.getValue().get()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Set<Map.Entry<SuperHeroiModel, AtomicInteger>> ordered = collect.entrySet();
        ordered.forEach(superHeroAtomicIntegerEntry -> {
            SuperHeroiModel superHero = superHeroAtomicIntegerEntry.getKey();
            superHero.setTempoTotal(superHeroAtomicIntegerEntry.getValue().get());
            winnersOrdered.add(superHero);
        });
        return winnersOrdered;
    }
}
