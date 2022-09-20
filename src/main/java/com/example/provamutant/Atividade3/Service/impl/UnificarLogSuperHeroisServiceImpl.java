package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UnificarLogSuperHeroisServiceImpl {
    public List<SuperHeroiModel> unificarLog(List<SuperHeroiModel> superHeroesByLine) {
        ArrayList<SuperHeroiModel> filteredSuperHeroes = new ArrayList<>();
        Set<String> superHeroNamesAndCodes = new HashSet<>();
        superHeroesByLine.forEach(superHero -> {
            superHeroNamesAndCodes.add(superHero.getNome() + ":" + superHero.getCodigo());

        });
        List<String> superHeroNamesIndexed = new ArrayList<>(superHeroNamesAndCodes);


        for (int index = 0; index < superHeroNamesAndCodes.size(); index++) {
            String[] superHeroPair = superHeroNamesIndexed.get(index).split(":");
            filteredSuperHeroes.add(new SuperHeroiModel(superHeroPair[0], superHeroPair[1]));
            for (SuperHeroiModel superHero : superHeroesByLine) {
                if (filteredSuperHeroes.get(index).getNome().equals(superHero.getNome())) {
                    int finalIndex = index;
                    superHero.getVoltas().forEach(lap -> filteredSuperHeroes.get(finalIndex).getVoltas().add(lap));
                }
            }
        }

        return filteredSuperHeroes;
    }
}
