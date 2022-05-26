package com.salesianostriana.dam.rosario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.rosario.model.Eventos;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long>{

}
