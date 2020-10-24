package model;

public class Gerente extends Pessoa {
    private String nome;
    private String data_nasc;
    private String sexo;
    private Integer id;
    private Usuario usuario;
    private Endereco endereco;
    private Contato contato;
    private Pessoa pessoa;

    
	public Gerente(Integer id) {
		super();
		this.id = id;
	}

	public Gerente(String cpf, String nome, String data, String sexo,  Integer id) {
        super(cpf, id);
        this.nome = nome;
        this.data_nasc = data;
        this.sexo = sexo;
    }

 	public Gerente(String nome, String data_nasc, String sexo) {
		super();
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
	}

	public Gerente(){

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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
