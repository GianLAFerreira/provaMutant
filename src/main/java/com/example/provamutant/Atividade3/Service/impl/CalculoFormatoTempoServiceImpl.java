package com.example.provamutant.Atividade3.Service.impl;

import org.springframework.stereotype.Service;

@Service
public class CalculoFormatoTempoServiceImpl {

    public String transformarDuracao(int timeInteger) {
        StringBuilder timeString = new StringBuilder();
        int minutes = timeInteger / 60000;
        int seconds = (timeInteger - minutes * 60000) / 1000;
        int milliseconds = (timeInteger - (minutes * 60000) - (seconds * 1000));
        timeString.append(minutes)
                .append(":");
        timeString.append(seconds)
                .append(".")
                .append(milliseconds);
        return String.valueOf(timeString);
    }

    public int transformarDuracao(String lapDuration) {
        String[] msTokens = lapDuration.split("\\.");
        String[] secondsTokens = msTokens[0].split(":");
        int minutes = Integer.parseInt(secondsTokens[0]);
        int seconds = Integer.parseInt(secondsTokens[1]);
        int milliseconds = Integer.parseInt(msTokens[1]);
        return 60000 * minutes + 1000 * seconds + milliseconds;
    }
}
