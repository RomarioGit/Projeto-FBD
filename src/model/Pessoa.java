package model;

public class Pessoa {
    private String cpf;
    private Integer id;

    public Pessoa(String cpf, Integer id) {
        super();
        this.cpf = cpf;
        this.id = id;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
