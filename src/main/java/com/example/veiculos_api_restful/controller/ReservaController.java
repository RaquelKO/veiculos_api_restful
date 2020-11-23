package com.example.veiculos_api_restful.controller;

import java.util.List;

import com.example.veiculos_api_restful.model.Reserva;
import com.example.veiculos_api_restful.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    public ReservaService reservaService;

    @GetMapping
    public List<Reserva> getReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) {
        Reserva reserva = reservaService.getReservaById(id);
        return ResponseEntity.ok(reserva);
    }

}
