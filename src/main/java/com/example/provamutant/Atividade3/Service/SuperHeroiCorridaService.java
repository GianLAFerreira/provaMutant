package com.example.provamutant.Atividade3.Service;

import com.example.provamutant.Atividade3.Model.CorridaModel;
import com.example.provamutant.Atividade3.Service.impl.CalculosVoltaServiceImpl;
import com.example.provamutant.Atividade3.Service.impl.CriarCorridaServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SuperHeroiCorridaService {

    @Inject
    CalculosVoltaServiceImpl calculosVoltaService;
    @Inject
    CriarCorridaServiceImpl criarCorrida;

    public String verificarLog(String logCorrida) {
        CorridaModel corrida = criarCorrida.criarCorrida(logCorrida);
        
        return calculosVoltaService.listarInformacoesCorrida(corrida);
    }

    public String verificarLogMelhorVolta(String logCorrida) {
        CorridaModel corrida = criarCorrida.criarCorrida(logCorrida);

        return calculosVoltaService.listarMelhorVolta(corrida);
    }

    public String verificarLogVelocidademedia(String logCorrida) {
        CorridaModel corrida = criarCorrida.criarCorrida(logCorrida);

        return calculosVoltaService.listarVelocidadeMedia(corrida);
    }

    public String verificarLogMelhorVoltaSuperHeroi(String logCorrida) {
        CorridaModel corrida = criarCorrida.criarCorrida(logCorrida);

        return calculosVoltaService.listarMelhorVoltaSuperHeroi(corrida);
    }
}
