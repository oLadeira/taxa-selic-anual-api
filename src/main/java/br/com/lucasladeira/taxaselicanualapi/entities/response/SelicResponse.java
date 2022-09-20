package br.com.lucasladeira.taxaselicanualapi.entities.response;

public class SelicResponse {

    private String data;
    private Double valor;

    public SelicResponse(){}

    public SelicResponse(String data, Double valor) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelicResponse selicResponse = (SelicResponse) o;

        if (data != null ? !data.equals(selicResponse.data) : selicResponse.data != null) return false;
        return valor != null ? valor.equals(selicResponse.valor) : selicResponse.valor == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }
}
