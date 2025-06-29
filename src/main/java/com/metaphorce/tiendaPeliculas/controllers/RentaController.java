package com.metaphorce.tiendaPeliculas.controllers;

import com.metaphorce.tiendaPeliculas.entidades.Renta;
import com.metaphorce.tiendaPeliculas.services.RentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendaPeliculaAPI")
public class RentaController {

    @Autowired
    RentaService rentaService;

    @GetMapping("/Renta")
    public List<Renta> obtenerRentas() {
        return rentaService.getRenta();
    }

    @GetMapping("/Renta/{id}")
    public Renta obtenerRentaPorId(@PathVariable Integer id) {
        return rentaService.getRentaById(id);
    }

    @PostMapping("/Renta")
    public Renta agregarRenta(@RequestBody Renta renta) {
        return rentaService.saveRenta(renta);
    }

    @PutMapping("/Renta/{id}")
    public Renta actualizarRenta(@PathVariable Integer id, @RequestBody Renta rentaActualizada) {
        return rentaService.updateRenta(id, rentaActualizada);
    }

    @DeleteMapping("/Renta/{id}")
    public void eliminarRenta(@PathVariable Integer id) {
        rentaService.deleteRenta(id);
    }
}

