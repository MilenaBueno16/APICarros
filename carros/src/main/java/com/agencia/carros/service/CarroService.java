package com.agencia.carros.service;

import com.agencia.carros.domain.Carro;
import com.agencia.carros.dto.CarroDTO;
import com.agencia.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        List<CarroDTO> list = rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    /*public void delete(Long id){
        rep.deleteById(id);
    }*/

    public CarroDTO getCarrosByID(Long idCarro) {
        return CarroDTO.create(rep.findAllById(idCarro));
    }

    public  CarroDTO getCarrosByNome(String nome) {
        return CarroDTO.create(rep.findAllByNome(nome));
    }

    public List<CarroDTO> getCarrosByCor(String cor) {
        return rep.findByCor(cor).stream().map(CarroDTO::create).collect(Collectors.toList());
    }


    public void deleteById(Long id) {
        rep.deleteById(id);
    }
}
