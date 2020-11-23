package com.example.veiculos_api_restful.service;

import java.util.List;
import java.util.Optional;

import com.example.veiculos_api_restful.dto.VeiculoDTO;
import com.example.veiculos_api_restful.model.Reserva;
import com.example.veiculos_api_restful.model.Veiculo;
import com.example.veiculos_api_restful.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService {

    @Autowired
    public VeiculoRepository repository;

    public Veiculo getVeiculoById(int id) {
        Optional<Veiculo> op = repository.getVeiculoById(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo nao cadastrado: " + id));
    }

    public Veiculo fromDTO(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValorDiaria(dto.getValorDiaria());
        return veiculo;
    }

    public Veiculo update(Veiculo veiculo) {
        getVeiculoById(veiculo.getIdVeiculo());
        return repository.update(veiculo);
    }

    public List<Veiculo> getAllVeiculos() {
        return repository.getAllVeiculos();
    }

    public Veiculo save(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void remove(int id) {
        repository.remove(getVeiculoById(id));
    }

    public List<Reserva> getReservasVeiculo(Veiculo veiculo) {
        return repository.getReservas(veiculo);
    }
}
