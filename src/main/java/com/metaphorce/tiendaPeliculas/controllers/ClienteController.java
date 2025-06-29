package com.metaphorce.tiendaPeliculas.controllers;

import com.metaphorce.tiendaPeliculas.entidades.Cliente;
import com.metaphorce.tiendaPeliculas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendaPeliculaAPI")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/Cliente")
    public List<Cliente> obtenerClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/Cliente/{id}")
    public Cliente obtenerClientePorId(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping("/Cliente")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/Cliente/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteActualizado) {
        return clienteService.updateCliente(id, clienteActualizado);
    }

    @DeleteMapping("/Cliente/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
    }
}

