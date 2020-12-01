package com.example.veiculos_api_restful.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class VeiculoDTO {

    @NotBlank(message = "Modelo é obrigatorio!")
    @Length(min = 2, max = 20, message = "Digite um modelo válido (2 a 20 caracteres)!")
    private String modelo;

    @Positive(message = "Valor da diária é obrigatório!")
    private double valorDiaria;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

}
