package model;

public class Garçon extends Pessoa {
    private String nome;
    private String data_nasc;
    private String sexo;

    public Garçon(String cpf) {
        super(cpf);
    }

    public Garçon(String cpf, String nome, String data, String sexo) {
        super(cpf);
        this.nome = nome;
        this.data_nasc = data;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
