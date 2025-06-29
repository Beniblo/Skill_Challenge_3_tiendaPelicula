package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import java.util.List;

public interface PeliculaService {

    List<Pelicula> getPelicula();

    Pelicula getPeliculaById(Integer id);

    Pelicula savePelicula(Pelicula pelicula);

    Pelicula updatePelicula(Integer id, Pelicula peliculaActualizada);

    void deletePelicula(Integer id);
}

