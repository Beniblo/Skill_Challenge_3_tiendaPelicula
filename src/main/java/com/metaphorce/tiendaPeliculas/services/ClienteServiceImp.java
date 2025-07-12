package com.metaphorce.tiendaPeliculas.services;

import com.metaphorce.tiendaPeliculas.entidades.Cliente;
import com.metaphorce.tiendaPeliculas.excepciones.ClienteDatosInvalidosException;
import com.metaphorce.tiendaPeliculas.excepciones.ClienteNoEncontradoException;
import com.metaphorce.tiendaPeliculas.excepciones.OperacionNoPermitidaException;
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
        List<Cliente> clientes = repository.findAll();
        if (clientes.isEmpty()) {
            throw new OperacionNoPermitidaException("No hay clientes registrados en el sistema.");
        }
        return clientes;
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        if (cliente.getNombreCliente() == null || cliente.getNombreCliente().isBlank()) {
            throw new ClienteDatosInvalidosException("El nombre del cliente no puede estar vacío.");
        }
        if (cliente.getCorreo() == null || !cliente.getCorreo().contains("@")) {
            throw new ClienteDatosInvalidosException("El correo del cliente no es válido.");
        }

        return repository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente clienteActualizado) {
        Cliente existente = repository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));

        if (clienteActualizado.getNombreCliente() == null || clienteActualizado.getNombreCliente().isBlank()) {
            throw new ClienteDatosInvalidosException("El nombre del cliente no puede estar vacío.");
        }

        existente.setNombreCliente(clienteActualizado.getNombreCliente());
        existente.setApellidoCliente(clienteActualizado.getApellidoCliente());
        existente.setCorreo(clienteActualizado.getCorreo());
        existente.setTelefono(clienteActualizado.getTelefono());

        return repository.save(existente);
    }

    @Override
    public void deleteCliente(Integer id) {
        if (!repository.existsById(id)) {
            throw new ClienteNoEncontradoException(id);
        }

        // Aquí podrías agregar validación de si el cliente tiene rentas activas
        // throw new OperacionNoPermitidaException("El cliente tiene rentas activas y no puede ser eliminado.");

        repository.deleteById(id);
    }
}


