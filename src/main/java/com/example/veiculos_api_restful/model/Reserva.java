package com.example.veiculos_api_restful.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Reserva {

    private int idReserva;
    private Cliente cliente;
    private Veiculo veiculo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    // A TESTAR:

    public long daysBetween(Reserva reserva) {
        long daysBetween = ChronoUnit.DAYS.between(reserva.getDataInicio(), reserva.getDataFim());
        return daysBetween;
    }

    @JsonGetter
    public double totalReserva(Reserva reserva) {
        double total = 0;
        total += daysBetween(reserva) * reserva.getVeiculo().getValorDiaria();
        return total;
    }

}
