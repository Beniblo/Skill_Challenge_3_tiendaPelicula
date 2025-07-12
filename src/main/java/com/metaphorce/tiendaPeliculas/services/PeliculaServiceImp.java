package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import com.metaphorce.tiendaPeliculas.excepciones.PeliculaDatosInvalidosException;
import com.metaphorce.tiendaPeliculas.excepciones.PeliculaNoEncontradaException;
import com.metaphorce.tiendaPeliculas.excepciones.OperacionNoPermitidaException;
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
        List<Pelicula> peliculas = repository.findAll();
        if (peliculas.isEmpty()) {
            throw new OperacionNoPermitidaException("No hay películas registradas en el sistema.");
        }
        return peliculas;
    }

    @Override
    public Pelicula getPeliculaById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new PeliculaNoEncontradaException(id));
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        validarPelicula(pelicula);
        return repository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Integer id, Pelicula peliculaActualizada) {
        Pelicula existente = repository.findById(id)
                .orElseThrow(() -> new PeliculaNoEncontradaException(id));

        validarPelicula(peliculaActualizada);

        existente.setTituloPelicula(peliculaActualizada.getTituloPelicula());
        existente.setGeneroPelicula(peliculaActualizada.getGeneroPelicula());
        existente.setAnioEstreno(peliculaActualizada.getAnioEstreno());
        existente.setDuracionPelicula(peliculaActualizada.getDuracionPelicula());
        existente.setClasificacionPelicula(peliculaActualizada.getClasificacionPelicula());

        return repository.save(existente);
    }

    @Override
    public void deletePelicula(Integer id) {
        if (!repository.existsById(id)) {
            throw new PeliculaNoEncontradaException(id);
        }
        // Aquí puedes agregar validación para no borrar si está rentada, por ejemplo
        repository.deleteById(id);
    }

    private void validarPelicula(Pelicula pelicula) {
        if (pelicula.getTituloPelicula() == null || pelicula.getTituloPelicula().isBlank()) {
            throw new PeliculaDatosInvalidosException("El título de la película no puede estar vacío.");
        }
        if (pelicula.getGeneroPelicula() == null || pelicula.getGeneroPelicula().isBlank()) {
            throw new PeliculaDatosInvalidosException("El género de la película no puede estar vacío.");
        }
        if (pelicula.getAnioEstreno() < 1800 || pelicula.getAnioEstreno() > 2100) {
            throw new PeliculaDatosInvalidosException("El año de estreno es inválido.");
        }
        if (pelicula.getDuracionPelicula() <= 0) {
            throw new PeliculaDatosInvalidosException("La duración de la película debe ser mayor a cero.");
        }
    }
}


