package business;

import java.util.ArrayList;

import dao.DaoUsuario;
import dao.IDaoUsuario;
import exception.ExceptionGeral;
import model.Usuario;

public class BusinessUsuario implements IBusinessUsuario {

	private IDaoUsuario daoUsuario;

	public BusinessUsuario() {
		super();
		this.daoUsuario = new DaoUsuario();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral {
		try {
			usuario = daoUsuario.salvarUsuario(usuario);
		} catch (ExceptionGeral e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario buscarID(int id) throws ExceptionGeral {
		return daoUsuario.buscarID(id);
	}

	@Override
	public ArrayList<Usuario> getAll() throws ExceptionGeral {
		return daoUsuario.getAll();

	}

	@Override
	public Usuario buscarLogin(String email, String senha) throws ExceptionGeral {
		return daoUsuario.buscarLogin(email,senha);
	}
}
