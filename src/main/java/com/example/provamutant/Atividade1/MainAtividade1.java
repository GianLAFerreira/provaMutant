package com.example.provamutant.Atividade1;

import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class MainAtividade1 {
     public static void main(String args[]){

         ImageBitmap  imageBitmap = new ImageBitmap();
         Scanner      scanner     = new Scanner(System.in);
         Ocorrencia   ocorrencia  = new Ocorrencia();

         System.out.print("Digite o vetor separado por espaços:");
         String input = scanner.nextLine();

         ocorrencia.setIndex(input.split(" "));

         System.out.println();
         try {
             System.out.println(imageBitmap.buscaAsOcorrencias(ocorrencia));
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
