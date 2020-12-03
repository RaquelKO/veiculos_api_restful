package com.example.veiculos_api_restful.service;

import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.model.Cliente;
import com.example.veiculos_api_restful.model.Reserva;
import com.example.veiculos_api_restful.model.Veiculo;
import com.example.veiculos_api_restful.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    public Reserva getReservaById(int id) {
        Optional<Reserva> op = repository.getReservaById(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva nao encontrada: " + id));
    }

    public Reserva save(int idCliente, int idVeiculo, Reserva reserva) {

        if (reserva.isNotSunday() && reserva.hasValidDate()) {
            Cliente cliente = clienteService.getClienteById(idCliente);
            Veiculo veiculo = veiculoService.getVeiculoById(idVeiculo);

            reserva.setCliente(cliente);
            reserva.setVeiculo(veiculo);
            cliente.addReserva(reserva);
            veiculo.addReserva(reserva);

            return repository.save(reserva);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data inválida!");
        }
    }

    public List<Reserva> getAllReservas() {
        return repository.getAllReservas();
    }
}
