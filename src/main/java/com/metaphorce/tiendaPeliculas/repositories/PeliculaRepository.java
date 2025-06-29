package com.metaphorce.tiendaPeliculas.repositories;

import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}
