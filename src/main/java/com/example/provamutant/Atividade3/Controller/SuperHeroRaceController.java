package com.example.provamutant.Atividade3.Controller;

import com.example.provamutant.Atividade3.Service.SuperHeroiCorridaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.catalina.User;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/superherorace")
public class SuperHeroRaceController {

    @Inject
    SuperHeroiCorridaService superHeroRaceService;

    @PostMapping("/verificarLogCorrida")
    public ResponseEntity<JSONObject> verificarLogCorrida(@RequestBody String logCorrida){

        String str = superHeroRaceService.verificarLog(logCorrida);
        System.out.println(str);

        JSONObject jsonObject = new JSONObject(str);

        return ResponseEntity.ok().body(jsonObject);
    }

    @PostMapping("/melhorVolta")
    public ResponseEntity<JsonNode> verificarLogMelhorVolta(@RequestBody String logCorrida) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(superHeroRaceService.verificarLogMelhorVolta(logCorrida));

        return ResponseEntity.ok().body(node);
    }
    @PostMapping("/velocidademedia")
    public ResponseEntity<String> verificarLogvelocidademedia(@RequestBody String logCorrida) throws JsonProcessingException {

        return ResponseEntity.ok().body(superHeroRaceService.verificarLogVelocidademedia(logCorrida));
    }

    @PostMapping("/melhorVoltaSuperHeroi")
    public ResponseEntity<String> verificarLogMelhorVoltaSuperHeroi(@RequestBody String logCorrida){

        return ResponseEntity.ok().body(superHeroRaceService.verificarLogMelhorVoltaSuperHeroi(logCorrida));
    }
}
