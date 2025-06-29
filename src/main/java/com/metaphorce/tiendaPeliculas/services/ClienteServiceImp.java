package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Cliente;
import com.metaphorce.tiendaPeliculas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente clienteActualizado) {
        Cliente existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreCliente(clienteActualizado.getNombreCliente());
            existente.setApellidoCliente(clienteActualizado.getApellidoCliente());
            existente.setCorreo(clienteActualizado.getCorreo());
            existente.setTelefono(clienteActualizado.getTelefono());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteCliente(Integer id) {
        repository.deleteById(id);
    }
}

