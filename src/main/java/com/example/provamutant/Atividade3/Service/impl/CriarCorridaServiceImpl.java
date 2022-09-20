package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.CorridaModel;
import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import com.example.provamutant.Atividade3.Model.VoltaModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriarCorridaServiceImpl {

    @Inject
    UnificarLogSuperHeroisServiceImpl unificarLogSuperHerois;

    public CorridaModel criarCorrida(String data) {
        ArrayList<String> logRow = new ArrayList<>();
        data.lines().forEach(logRow::add);
        logRow.remove(0);

        CorridaModel race = new CorridaModel();

        ArrayList<SuperHeroiModel> superHeroesByLine = new ArrayList<>();
        logRow.forEach(line -> {
            SuperHeroiModel superHero = new SuperHeroiModel();
            String[] element = line.split(";");
            String[] superHeroCodeName = element[1].split("–");
            superHero.setCodigo(superHeroCodeName[0]);
            superHero.setNome(superHeroCodeName[1]);

            ArrayList<VoltaModel> laps = new ArrayList<>();
            VoltaModel lap = new VoltaModel();
            lap.setTempo(element[0]);
            lap.setNumeroVolta(Integer.parseInt(element[2]));
            lap.setDuracaoVolta(element[3]);
            lap.setVelocidadeMediaVolta(element[4]);
            laps.add(lap);
            superHero.setVoltas(laps);
            superHeroesByLine.add(superHero);
        });

        List<SuperHeroiModel> superHeroes = unificarLogSuperHerois.unificarLog(superHeroesByLine);
        race.setSuperHeroes(superHeroes);
        return race;
    }
}
