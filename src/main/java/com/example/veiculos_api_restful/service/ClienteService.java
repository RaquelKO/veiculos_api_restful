package com.example.veiculos_api_restful.service;

import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.dto.ClienteDTO;
import com.example.veiculos_api_restful.model.Cliente;
import com.example.veiculos_api_restful.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente getClienteById(int id) {
        Optional<Cliente> op = repository.getClienteById(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado: " + id));
    }

    public Cliente fromDTO(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        getClienteById(cliente.getIdCliente());
        return repository.update(cliente);
    }

    public List<Cliente> getAllClientes() {
        return repository.getAllClientes();
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void remove(int id) {
        repository.remove(getClienteById(id));
    }
}
