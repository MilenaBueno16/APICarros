package com.agencia.carros.repository;

import com.agencia.carros.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByTipo(String tipo);

    Carro findAllById(Long ID);

    Carro findAllByNome(String nome);

    List<Carro> findByCor(String cor);

    void deleteById(Long id);

}
