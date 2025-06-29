package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Renta;
import java.util.List;

public interface RentaService {
    List<Renta> getRenta();

    Renta getRentaById(Integer id);

    Renta saveRenta(Renta renta);

    Renta updateRenta(Integer id, Renta rentaActualizada);

    void deleteRenta(Integer id);
}

