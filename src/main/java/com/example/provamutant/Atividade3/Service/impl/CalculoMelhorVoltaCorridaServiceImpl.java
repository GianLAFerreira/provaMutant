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
import java.util.stream.Collectors;

@Service
public class CalculoMelhorVoltaCorridaServiceImpl {

    @Inject
    CalculoMelhorVoltaSuperHeroiServiceImpl calculoMelhorVoltaSuperHeroi;
    @Inject
    CalculoFormatoTempoServiceImpl calculoFormatoTempo;

    public String melhorVoltaFormatadaDaCorrida(List<SuperHeroiModel> superHeroes) {
        StringBuilder bestLapResult = new StringBuilder();
        List<SuperHeroiModel> orderedFromBestRace = calculoMelhorVoltaSuperHeroi.melhorVoltaSuperHeroiOrdenada(superHeroes);

        VoltaModel bastRaceLap = calculoMelhorVoltaSuperHeroi.melhorVolta(orderedFromBestRace.get(0));

        bestLapResult.append("{\"Melhor volta da corrida\":  \"" )
                .append(orderedFromBestRace.get(0).getNome())
                .append(" numero da volta: ")
                .append(bastRaceLap.getNumeroVolta())
                .append(" duração: ")
                .append(bastRaceLap.getDuracaoVolta()+"\"}");
        return String.valueOf(bestLapResult);
    }

    public List<SuperHeroiModel> tempoTotalSuperHeroisOrdenado(List<SuperHeroiModel> superHeroes) {
        List<SuperHeroiModel> winnersOrdered = new ArrayList<>();
        HashMap<SuperHeroiModel, AtomicInteger> totalTimeSuperheroMap = new HashMap<>();
        superHeroes.forEach(superHero -> {
            AtomicInteger total = new AtomicInteger();
            superHero.getVoltas().forEach(lap -> {
                total.addAndGet(calculoFormatoTempo.transformarDuracao(lap.getDuracaoVolta()));
            });
            totalTimeSuperheroMap.put(superHero, total);
        });
        LinkedHashMap<SuperHeroiModel, AtomicInteger> collect = totalTimeSuperheroMap.entrySet()
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
