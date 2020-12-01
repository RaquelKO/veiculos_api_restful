package com.example.veiculos_api_restful.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

    @NotBlank(message = "Nome é obrigatorio!")
    @Length(min = 4, max = 100, message = "Nome deve ter mínimo de 4 e o máximo de 100 caracteres!")
    private String nome;

    @NotBlank(message = "Endereço é obrigatorio!")
    @Length(min = 4, max = 200, message = "Endereço deve ter mínimo de 4 e o máximo de 200 caracteres!")
    private String endereco;

    @Positive(message = "O CPF é obrigatório!")
    private long cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

}
