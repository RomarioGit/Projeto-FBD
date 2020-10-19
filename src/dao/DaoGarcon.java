package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Contato;
import model.Endereco;
import model.Garcon;
import model.Gerente;
import model.Pessoa;
import model.Usuario;

public class DaoGarcon implements IDaoGarcon{
	
    private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoGarcon() {
        this.conexao = ConectionBD.getInstance();
    }

	@Override
	public Garcon salvarGarcon(Garcon garcon) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO Garcon" + "(nome, data_nasc, sexo)" + "VALUES(?,?,?) returning id");
            this.statement.setString(1, garcon.getNome());
            this.statement.setString(2, garcon.getData_nasc());
            this.statement.setString(3, garcon.getSexo());
           
            this.result = this.statement.executeQuery();
            this.result.next();
            garcon.setId(this.result.getInt(1));    
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garcon;
    }

	@Override
	public Garcon buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT garcon.nome, garcon.data_nasc, garcon.sexo FROM "+"garcon"+" garcon WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Garcon garcon;
            if (result.next()) {
                String nome = result.getString(1);
                String data_nasc = result.getString(2);
                String sexo = result.getString(3);
                garcon = new Garcon(id);
                garcon.setNome(nome);
                garcon.setData_nasc(data_nasc);
                garcon.setSexo(sexo);
                return garcon;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Garcon não encontrada.");
        }
	}
	@Override
	public ArrayList<Garcon> getAll() throws ExceptionGeral {
		ArrayList<Garcon> garcons = new ArrayList<Garcon>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.nome, a.data_nasc, a.sexo FROM "+"garcon"+" as a");
            result = this.statement.executeQuery();
            Garcon garcon;
            while (result.next()) {
            	    String nome = result.getString(1);
	                String data_nasc = result.getString(2);
            	    String sexo = result.getString(3);
	                garcon = new Garcon(nome, data_nasc, sexo);
	                garcons.add(garcon);
            }
            return garcons;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Garcon não encontrado.");
        }
	}
	
	public Garcon salvar(Garcon garcon, Endereco endereco, Contato contato, Usuario user, Pessoa pessoa) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO gerente" + "(nome, cpf, sexo, email, telefone, data_nasc, cidade,"
            		+ "estado, rua, bairro, cep, complemento, senha )" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) returning id");
            this.statement.setString(1, garcon.getNome());
            this.statement.setString(2, pessoa.getCpf());
            this.statement.setString(3, garcon.getSexo());
            this.statement.setString(4, contato.getEmail());
            this.statement.setString(5, contato.getTelefone());
            this.statement.setString(6, garcon.getData_nasc());
            this.statement.setString(7, endereco.getCidade());
            this.statement.setString(8, endereco.getEstado());
            this.statement.setString(9, endereco.getRua());
            this.statement.setString(10, endereco.getBairro());
            this.statement.setString(11, endereco.getCep());
            this.statement.setString(12, endereco.getComplemento());
            this.statement.setString(13, user.getSenha());
               
            this.result = this.statement.executeQuery();
            this.result.next();
            garcon.setId(this.result.getInt(1));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garcon;
    }

}
