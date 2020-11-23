package com.example.veiculos_api_restful.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.veiculos_api_restful.dto.VeiculoDTO;
import com.example.veiculos_api_restful.model.Reserva;
import com.example.veiculos_api_restful.model.Veiculo;
import com.example.veiculos_api_restful.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    public VeiculoService veiculoService;

    // CREATE

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VeiculoDTO newVeiculo, HttpServletRequest request,
            UriComponentsBuilder builder) {

        Veiculo veiculo = veiculoService.save(veiculoService.fromDTO(newVeiculo));
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + veiculo.getIdVeiculo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    // READ

    @GetMapping
    public List<Veiculo> getVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable int id) {
        Veiculo veiculo = veiculoService.getVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable int id, @RequestBody VeiculoDTO veiculoDTO) {

        Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
        veiculo.setIdVeiculo(id);
        veiculo = veiculoService.update(veiculo);
        return ResponseEntity.ok(veiculo);

    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        veiculoService.remove(id);
        return ResponseEntity.noContent().build();
    }

    // RESERVAS

    @GetMapping("/{id}/reservas")
    public List<Reserva> getReservasVeiculo(@PathVariable int id) {
        return veiculoService.getReservasVeiculo(veiculoService.getVeiculoById(id));
    }

}
