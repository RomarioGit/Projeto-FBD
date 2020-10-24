package model;

public class Contato {
    private String email;
    private String telefone;
    private Integer id;

    public Contato(String email, String fone) {
        this.email = email;
        this.telefone = fone;
    }

    public Contato() {
    }

    public Contato(Integer id) {
		super();
		this.id = id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	public Integer getId() {
		return id;
	}
    
}
