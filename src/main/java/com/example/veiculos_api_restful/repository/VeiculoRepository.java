package com.example.veiculos_api_restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.model.Reserva;
import com.example.veiculos_api_restful.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {

    private List<Veiculo> veiculos = new ArrayList<Veiculo>();
    private static int nextId = 1;

    public List<Veiculo> getAllVeiculos() {
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoById(int id) {
        for (Veiculo aux : veiculos) {
            if (aux.getIdVeiculo() == id) {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Veiculo save(Veiculo veiculo) {
        veiculo.setIdVeiculo(nextId++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public void remove(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public Veiculo update(Veiculo veiculo) {

        Veiculo aux = getVeiculoById(veiculo.getIdVeiculo()).get();
        if (aux != null) {
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    public List<Reserva> getReservas(Veiculo veiculo) {
        return veiculo.getReservas();
    }
}
