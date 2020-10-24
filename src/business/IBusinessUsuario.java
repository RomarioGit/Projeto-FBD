package business;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Usuario;

public interface IBusinessUsuario {
    public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral;
	public Usuario buscarID(int id) throws ExceptionGeral;
	public ArrayList<Usuario> getAll() throws ExceptionGeral;
	public Usuario buscarLogin(String email, String senha) throws ExceptionGeral;
}
