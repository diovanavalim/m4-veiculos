package com.veiculos.veiculos.exception;

import java.time.LocalDateTime;

public class NotFoundExceptionDetails {
    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;

    public NotFoundExceptionDetails(String titulo, int status, String mensagem, LocalDateTime timestamp) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
