package br.com.lucasladeira.taxaselicanualapi.entities;

import java.time.LocalDate;

public class Selic {

    private LocalDate data;
    private Double valor;

    public Selic(){}

    public Selic(LocalDate data, Double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selic selic = (Selic) o;

        if (data != null ? !data.equals(selic.data) : selic.data != null) return false;
        return valor != null ? valor.equals(selic.valor) : selic.valor == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }
}
