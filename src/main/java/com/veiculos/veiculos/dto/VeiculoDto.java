package com.veiculos.veiculos.dto;

import com.veiculos.veiculos.model.VeiculoModel;

public class VeiculoDto {
    private String placa;
    private String modelo;
    private double valor;

    public VeiculoDto(VeiculoModel veiculo) {
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.valor = veiculo.getValor();
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
