package com.example.provamutant.Atividade2.Service;

import com.example.provamutant.Atividade2.Service.impl.ImagemBitmapServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Service
public class ImagemBitmapService {
    @Inject
    ImagemBitmapServiceImpl imagemBitmapService;

    public ResponseEntity<Collection> buscarOcorrencias(String[] elements) {
        try {
            Collection<String> array = imagemBitmapService.buscaAsOcorrencias(elements);
            return ResponseEntity.ok(array);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        }
    }
}
