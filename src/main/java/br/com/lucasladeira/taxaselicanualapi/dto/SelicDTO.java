package br.com.lucasladeira.taxaselicanualapi.dto;

public class SelicDTO {

    private String data;
    private Double valor;

    public SelicDTO(){}

    public SelicDTO(String data, Double valor) {
        this.data = data;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
