package model;

public class Usuario {
    private String login;
    private String senha;
    private Integer id;

    public Usuario(String login, String senha ) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
