package com.example.veiculos_api_restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.model.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ReservaRepository {

    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private static int nextId = 1;

    public List<Reserva> getAllReservas() {
        return reservas;
    }

    public Optional<Reserva> getReservaById(int id) {
        for (Reserva aux : reservas) {
            if (aux.getIdReserva() == id) {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Reserva save(Reserva reserva) {
        reserva.setIdReserva(nextId++);
        reserva.setCliente(reserva.getCliente());
        reserva.setVeiculo(reserva.getVeiculo());
        reserva.setDataInicio(reserva.getDataInicio());
        reserva.setDataFim(reserva.getDataFim());
        reserva.totalReserva();
        reservas.add(reserva);
        return reserva;
    }
}
