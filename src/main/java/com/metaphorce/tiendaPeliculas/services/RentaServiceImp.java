package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Renta;
import com.metaphorce.tiendaPeliculas.repositories.RentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentaServiceImp implements RentaService {
    @Autowired
    RentaRepository repository;

    @Override
    public List<Renta> getRenta() {
        return repository.findAll();
    }

    @Override
    public Renta getRentaById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Renta saveRenta(Renta renta) {
        return repository.save(renta);
    }

    @Override
    public Renta updateRenta(Integer id, Renta rentaActualizada) {
        Renta existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setCliente(rentaActualizada.getCliente());
            existente.setPelicula(rentaActualizada.getPelicula());
            existente.setFechaRenta(rentaActualizada.getFechaRenta());
            existente.setFechaDevolucion(rentaActualizada.getFechaDevolucion());
            existente.setEstado(rentaActualizada.getEstado());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteRenta(Integer id) {
        repository.deleteById(id);
    }
}

