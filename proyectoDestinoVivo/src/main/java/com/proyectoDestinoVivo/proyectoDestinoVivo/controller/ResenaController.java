package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // permite las solicitudes a Vue
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {this.resenaService = resenaService;}

    @PostMapping("/resenas/insertar")
    public Resena insertarresena(@RequestBody Resena resena){
        try{
            return resenaService.insertarResena(resena);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar la reseña" +e);
        }
    }
    @GetMapping("/resenas/consultar")
    public List<Resena> consultarresena(){
        try{
            return resenaService.consultarResena();
        }catch (RuntimeException e){
           throw  new RuntimeException("Error al consultar las reseñas" +e);
        }
    }
}
