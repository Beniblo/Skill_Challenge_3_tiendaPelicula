package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Cliente;
import com.metaphorce.tiendaPeliculas.entidades.Pelicula;
import com.metaphorce.tiendaPeliculas.entidades.Renta;
import com.metaphorce.tiendaPeliculas.excepciones.RentaDatosInvalidosException;
import com.metaphorce.tiendaPeliculas.excepciones.RentaNoEncontradaException;
import com.metaphorce.tiendaPeliculas.excepciones.OperacionNoPermitidaException;
import com.metaphorce.tiendaPeliculas.repositories.ClienteRepository;
import com.metaphorce.tiendaPeliculas.repositories.PeliculaRepository;
import com.metaphorce.tiendaPeliculas.repositories.RentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentaServiceImp implements RentaService {

    @Autowired
    RentaRepository rentaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Renta> getRenta() {
        List<Renta> rentas = rentaRepository.findAll();
        if (rentas.isEmpty()) {
            throw new OperacionNoPermitidaException("No hay rentas registradas en el sistema.");
        }
        return rentas;
    }

    @Override
    public Renta getRentaById(Integer id) {
        return rentaRepository.findById(id)
                .orElseThrow(() -> new RentaNoEncontradaException(id));
    }

    @Override
    public Renta saveRenta(Renta renta) {
        validarRenta(renta);
        return rentaRepository.save(renta);
    }

    @Override
    public Renta updateRenta(Integer id, Renta rentaActualizada) {
        Renta existente = rentaRepository.findById(id)
                .orElseThrow(() -> new RentaNoEncontradaException(id));

        validarRenta(rentaActualizada);

        existente.setCliente(rentaActualizada.getCliente());
        existente.setPelicula(rentaActualizada.getPelicula());
        existente.setFechaRenta(rentaActualizada.getFechaRenta());
        existente.setFechaDevolucion(rentaActualizada.getFechaDevolucion());
        existente.setEstado(rentaActualizada.getEstado());

        return rentaRepository.save(existente);
    }

    @Override
    public void deleteRenta(Integer id) {
        if (!rentaRepository.existsById(id)) {
            throw new RentaNoEncontradaException(id);
        }
        // Aquí podrías agregar reglas para no borrar rentas devueltas, si quieres
        rentaRepository.deleteById(id);
    }

    private void validarRenta(Renta renta) {
        // Validar cliente existe
        Integer clienteId = renta.getCliente() != null ? renta.getCliente().getId_Cliente() : null;
        if (clienteId == null || !clienteRepository.existsById(clienteId)) {
            throw new RentaDatosInvalidosException("Cliente inválido o no existe.");
        }

        // Validar pelicula existe
        Integer peliculaId = renta.getPelicula() != null ? renta.getPelicula().getId_Pelicula() : null;
        if (peliculaId == null || !peliculaRepository.existsById(peliculaId)) {
            throw new RentaDatosInvalidosException("Película inválida o no existe.");
        }

        // Validar fechas
        if (renta.getFechaRenta() == null) {
            throw new RentaDatosInvalidosException("La fecha de renta no puede ser nula.");
        }
        if (renta.getFechaDevolucion() == null) {
            throw new RentaDatosInvalidosException("La fecha de devolución no puede ser nula.");
        }
        if (renta.getFechaDevolucion().isBefore(renta.getFechaRenta())) {
            throw new RentaDatosInvalidosException("La fecha de devolución no puede ser anterior a la fecha de renta.");
        }

        // Validar estado
        if (renta.getEstado() == null) {
            throw new RentaDatosInvalidosException("El estado de la renta debe ser 'rentada' o 'devuelta'.");
        }
    }
}

