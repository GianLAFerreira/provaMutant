package com.example.provamutant.Atividade2.Controller;

import com.example.provamutant.Atividade2.Service.ImagemBitmapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/atividade1")
public class ImagemBitmapController {

    @Inject
    ImagemBitmapService imagemBitmapService;

    @GetMapping("/{elements}")
    public ResponseEntity<Collection> BuscarOcorrencias(@PathVariable String[] elements) {

       return imagemBitmapService.buscarOcorrencias(elements);
    }
}
