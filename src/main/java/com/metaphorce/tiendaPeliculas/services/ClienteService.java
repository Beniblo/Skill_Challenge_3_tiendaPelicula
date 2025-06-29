package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> getClientes();

    Cliente getClienteById(Integer id); // usa Integer

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Integer id, Cliente clienteActualizado);

    void deleteCliente(Integer id);

}
