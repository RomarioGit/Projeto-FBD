package dao;

import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoContato implements IDaoContato {
    private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoContato() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Contato salvarContato(Contato contato) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO contato" + "(email, telefone)" + "VALUES(?,?) returning id");
            this.statement.setString(1, contato.getEmail());
            this.statement.setString(2, contato.getTelefone());
          
            this.result = this.statement.executeQuery();
            this.result.next();
            contato.setId(this.result.getInt(1));   
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contato;
    }

	@Override
	public Contato buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT usuario.email, usuario.telefone FROM "+"contato"+" contato WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Contato contato;
            if (result.next()) {
                String email = result.getString(1);
                String telefone = result.getString(2);
                contato = new Contato(id);
                contato.setEmail(email);
                contato.setTelefone(telefone);
                return contato;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Contato não encontrado.");
        }
	}
	@Override
	public ArrayList<Contato> getAll() throws ExceptionGeral {
		ArrayList<Contato> contatos = new ArrayList<Contato>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.email, a.telefone FROM "+"atendente"+" as a");
            result = this.statement.executeQuery();
            Contato contato;
            while (result.next()) {
            	    String email = result.getString(1);
	                String telefone = result.getString(2);
	                contato = new Contato(email, telefone);
	                contatos.add(contato);
            }
            return contatos;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Contato não encontrado.");
        }
	}
}
