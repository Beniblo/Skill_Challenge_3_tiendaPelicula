package com.metaphorce.tiendaPeliculas.controllers;

import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import com.metaphorce.tiendaPeliculas.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendaPeliculaAPI")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/Pelicula")
    public List<Pelicula> obtenerPeliculas() {
        return peliculaService.getPelicula();
    }

    @GetMapping("/Pelicula/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Integer id) {
        return peliculaService.getPeliculaById(id);
    }

    @PostMapping("/Pelicula")
    public Pelicula agregarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.savePelicula(pelicula);
    }

    @PutMapping("/Pelicula/{id}")
    public Pelicula actualizarPelicula(@PathVariable Integer id, @RequestBody Pelicula peliculaActualizada) {
        return peliculaService.updatePelicula(id, peliculaActualizada);
    }

    @DeleteMapping("/Pelicula/{id}")
    public void eliminarPelicula(@PathVariable Integer id) {
        peliculaService.deletePelicula(id);
    }
}

