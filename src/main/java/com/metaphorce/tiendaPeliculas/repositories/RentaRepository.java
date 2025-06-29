package com.metaphorce.tiendaPeliculas.repositories;

import com.metaphorce.tiendaPeliculas.entidades.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer> {

}
