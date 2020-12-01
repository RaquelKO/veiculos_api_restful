package com.example.veiculos_api_restful.model;

import java.time.DayOfWeek;
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

    // public boolean isSunday() {
    // if (getDataInicio().getDayOfWeek().equals(DayOfWeek.SUNDAY)
    // || getDataFim().getDayOfWeek().equals(DayOfWeek.SUNDAY))
    // return true;
    // else
    // return false;
    // }

    // public boolean areAfter() {
    // LocalDate dataAtual = LocalDate.now();
    // if ((getDataInicio().isAfter(dataAtual)) &&
    // (getDataFim().isAfter(dataInicio)))
    // return true;
    // else
    // return false;
    // }

    public long daysBetween() {
        long daysBetween = ChronoUnit.DAYS.between(getDataInicio(), getDataFim());
        return daysBetween;
    }

    @JsonGetter
    public double totalReserva() {
        double total = 0;
        total += daysBetween() * getVeiculo().getValorDiaria();
        return total;
    }

}
