package dao;

import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoUsuario implements IDaoUsuario {
	
    private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoUsuario() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO usuario " + "(login, senha)" + "VALUES (?,?) returning id");
            this.statement.setString(1, usuario.getLogin());
            this.statement.setString(2, usuario.getSenha());
           
            this.result = this.statement.executeQuery();
            this.result.next();
            usuario.setId(this.result.getInt(1));   
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

	@Override
	public Usuario buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT usuario.login, usuario.senha FROM "+"usuario"+" usuario WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Usuario usuario;
            if (result.next()) {
                String login = result.getString(1);
                String senha = result.getString(2);
                usuario = new Usuario(id);
                usuario.setLogin(login);
                usuario.setSenha(senha);
                return usuario;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Usuario não encontrada.");
        }
	}

	@Override
	public ArrayList<Usuario> getAll() throws ExceptionGeral {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.login, a.senha FROM "+"usuario"+" as a");
            result = this.statement.executeQuery();
            Usuario usuario;
            while (result.next()) {
            	    String login = result.getString(1);
	                String senha = result.getString(2);
	                usuario = new Usuario(login, senha);
	                usuarios.add(usuario);
            }
            return usuarios;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Usuarios não encontrado.");
        }
	}
}
