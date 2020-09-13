package model;

public class Caixa {
    private Integer id;
    private double receita;
    private double despesa;

    public Caixa(double receita, double despesa, Integer id) {
        this.receita = receita;
        this.despesa = despesa;
        this.id = id;
    }

    public double getReceita() {
        return receita;
    }

    public void setReceita(double receita) {
        this.receita = receita;
    }

    public double getDespesa() {
        return despesa;
    }

    public void setDespesa(double despesa) {
        this.despesa = despesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
