package com.example.veiculos_api_restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.model.Cliente;
import com.example.veiculos_api_restful.model.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<Cliente>();
    private static int nextId = 1;

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteById(int id) {
        for (Cliente aux : clientes) {
            if (aux.getIdCliente() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Cliente save(Cliente cliente) {
        cliente.setIdCliente(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public void remove(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente update(Cliente cliente) {

        Cliente aux = getClienteById(cliente.getIdCliente()).get();
        if (aux != null) {
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
        }
        return aux;
    }

    public List<Reserva> getReservas(Cliente cliente) {
        return cliente.getReservas();
    }
}
