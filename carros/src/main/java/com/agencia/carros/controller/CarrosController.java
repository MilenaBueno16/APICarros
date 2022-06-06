package com.agencia.carros.controller;

import com.agencia.carros.dto.CarroDTO;
import com.agencia.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping()
    public ResponseEntity get(){
        List<CarroDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo (@PathVariable("tipo") String tipo) {
        List<CarroDTO> carros = service.getCarrosByTipo(tipo);
        return carros.isEmpty() ?
          ResponseEntity.noContent().build() :
          ResponseEntity.ok(carros);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCarrosByID (@PathVariable("id") Long id) {
        CarroDTO carros = service.getCarrosByID(id);
        return carros == null ?
          ResponseEntity.noContent().build() :
          ResponseEntity.ok(carros);
    }

    @GetMapping("/nome/{nome}")
    public  ResponseEntity getCarrosByNome (@PathVariable("nome") String nome) {
        CarroDTO carros = service.getCarrosByNome(nome);
        return carros == null ?
          ResponseEntity.noContent().build() :
          ResponseEntity.ok(carros);
    }

    @GetMapping("/cor/{cor}")
    public ResponseEntity getCarrosByCor (@PathVariable ("cor") String cor) {
        List<CarroDTO> carros = service.getCarrosByCor(cor);
        return carros == null ?
          ResponseEntity.noContent().build() :
          ResponseEntity.ok(carros);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "Carro " + id + " deletado com sucesso.";
    }
}
