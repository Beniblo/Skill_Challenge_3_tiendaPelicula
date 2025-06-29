package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import com.metaphorce.tiendaPeliculas.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImp implements PeliculaService {
    @Autowired
    PeliculaRepository repository;

    @Override
    public List<Pelicula> getPelicula() {
        return repository.findAll();
    }

    @Override
    public Pelicula getPeliculaById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Integer id, Pelicula peliculaActualizada) {
        Pelicula existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTituloPelicula(peliculaActualizada.getTituloPelicula());
            existente.setGeneroPelicula(peliculaActualizada.getGeneroPelicula());
            existente.setAnioEstreno(peliculaActualizada.getAnioEstreno());
            existente.setDuracionPelicula(peliculaActualizada.getDuracionPelicula());
            existente.setClasificacionPelicula(peliculaActualizada.getClasificacionPelicula());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void deletePelicula(Integer id) {
        repository.deleteById(id);
    }
}

