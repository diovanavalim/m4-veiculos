package com.veiculos.veiculos.model;

public class VeiculoModel {
    private String placa;
    private String modelo;
    private int renavam;
    private double valor;

    public VeiculoModel() {}

    public VeiculoModel(String placa, String modelo, int renavam, double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.renavam = renavam;
        this.valor = valor;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getRenavam() {
        return this.renavam;
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

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
