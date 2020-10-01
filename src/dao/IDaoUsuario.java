package dao;

import java.util.ArrayList;
import exception.ExceptionGeral;
import model.Usuario;

public interface IDaoUsuario {
	
    public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral;
	public Usuario buscarID(int id) throws ExceptionGeral;
	public ArrayList<Usuario> getAll() throws ExceptionGeral;

}
