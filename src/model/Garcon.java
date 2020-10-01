package model;

public class Garcon extends Pessoa {
    private String nome;
    private String data_nasc;
    private String sexo;
    private Integer id;    
    
	public Garcon(Integer id) {
		super();
		this.id = id;
	}

	public Garcon(String cpf, String nome, String data, String sexo) {
        this.nome = nome;
        this.data_nasc = data;
        this.sexo = sexo;
    }
	
    public Garcon(String nome, String data_nasc, String sexo) {
		super();
		this.nome = nome;
		this.data_nasc = data_nasc;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}