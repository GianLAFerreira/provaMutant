package com.example.provamutant.Atividade3.Service.impl;

import com.example.provamutant.Atividade3.Model.CorridaModel;
import com.example.provamutant.Atividade3.Model.SuperHeroiModel;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;


@Service
public class CalculosVoltaServiceImpl {

    @Inject
    CalculoResultadoCorridaServiceImpl calculoResultadoCorrida;
    @Inject
    CalculoBonusServiceImpl calculoBonusService;
    @Inject
    CalculoMelhorVoltaCorridaServiceImpl calculoMelhorVoltaCorrida;
    @Inject
    CalculoVelocidadeMediaServiceImpl calculoVelocidadeMedia;
    @Inject
    CalculoMelhorVoltaSuperHeroiServiceImpl calculoMelhorVoltaSuperHeroi;

    public String listarInformacoesCorrida(CorridaModel race) {
        StringBuilder raceInfo = new StringBuilder();
        List<SuperHeroiModel> winnersOrdered;
        winnersOrdered = calculoMelhorVoltaCorrida.tempoTotalSuperHeroisOrdenado(race.getSuperHeroes());
        raceInfo.append(calculoResultadoCorrida.resultadosCorrida(winnersOrdered))
                .append(calculoBonusService.calcularBonus(winnersOrdered));

        return String.valueOf(raceInfo);
    }

    public String listarMelhorVolta(CorridaModel race) {
        StringBuilder raceInfo = new StringBuilder();
        List<SuperHeroiModel> winnersOrdered;

        winnersOrdered = calculoMelhorVoltaCorrida.tempoTotalSuperHeroisOrdenado(race.getSuperHeroes());
        raceInfo.append(calculoMelhorVoltaCorrida.melhorVoltaFormatadaDaCorrida(winnersOrdered));

        return String.valueOf(raceInfo);
    }

    public String listarVelocidadeMedia(CorridaModel race) {
        StringBuilder raceInfo = new StringBuilder();
        List<SuperHeroiModel> winnersOrdered;

        winnersOrdered = calculoMelhorVoltaCorrida.tempoTotalSuperHeroisOrdenado(race.getSuperHeroes());
        raceInfo.append(calculoVelocidadeMedia.velocidadeMediaFormatada(winnersOrdered));

        return String.valueOf(raceInfo);
    }

    public String listarMelhorVoltaSuperHeroi(CorridaModel race) {
        StringBuilder raceInfo = new StringBuilder();
        List<SuperHeroiModel> winnersOrdered;

        winnersOrdered = calculoMelhorVoltaCorrida.tempoTotalSuperHeroisOrdenado(race.getSuperHeroes());
        raceInfo.append(calculoMelhorVoltaSuperHeroi.melhorVoltaFormatada(winnersOrdered));

        return String.valueOf(raceInfo);
    }

  }
