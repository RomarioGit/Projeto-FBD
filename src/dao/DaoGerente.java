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
import model.Gerente;
import model.Pessoa;
import model.Usuario;

public class DaoGerente implements IDaoGerente{
	
    private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;
 
    public DaoGerente() {
        this.conexao = ConectionBD.getInstance();
    }

	@Override
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO gerente" + "(nome, data_nasc, sexo)" + "VALUES(?,?,?) returning id");
            this.statement.setString(1, gerente.getNome());
            this.statement.setString(2, gerente.getData_nasc());
            this.statement.setString(3, gerente.getSexo());
            
            this.result = this.statement.executeQuery();
            this.result.next();
            gerente.setId(this.result.getInt(1));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerente;
    }

	@Override
	public Gerente buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT gerente.nome, gerente.data_nasc, gerente.sexo FROM "+"gerente"+" gerente WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Gerente gerente;
            if (result.next()) {
                String nome = result.getString(1);
                String data_nasc = result.getString(2);
                String sexo = result.getString(3);
                gerente = new Gerente(id);
                gerente.setNome(nome);
                gerente.setData_nasc(data_nasc);
                gerente.setSexo(sexo);
                return gerente;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Gerente não encontrado.");
        }
	}
	
	@Override
	public ArrayList<Gerente> getAll() throws ExceptionGeral {
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.nome, a.data_nasc, a.sexo FROM "+"gerente"+" as a");
            result = this.statement.executeQuery();
            Gerente gerente;
            while (result.next()) {
            	    String nome = result.getString(1);
	                String data_nasc = result.getString(2);
	                String sexo = result.getString(3);
	                gerente = new Gerente(nome, data_nasc, sexo);
	                gerentes.add(gerente);
            }
            return gerentes;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Gerente não encontrado.");
        }
	}
	
	public Gerente salvar(Gerente gerente, Endereco endereco, Contato contato, Usuario user, Pessoa pessoa) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO gerente" + "(nome, cpf, sexo, email, telefone, data_nasc, cidade,"
            		+ "estado, rua, bairro, cep, complemento, senha )" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) returning id");
            this.statement.setString(1, gerente.getNome());
            this.statement.setString(2, pessoa.getCpf());
            this.statement.setString(3, gerente.getSexo());
            this.statement.setString(4, contato.getEmail());
            this.statement.setString(5, contato.getTelefone());
            this.statement.setString(6, gerente.getData_nasc());
            this.statement.setString(7, endereco.getCidade());
            this.statement.setString(8, endereco.getEstado());
            this.statement.setString(9, endereco.getRua());
            this.statement.setString(10, endereco.getBairro());
            this.statement.setString(11, endereco.getCep());
            this.statement.setString(12, endereco.getComplemento());
            this.statement.setString(13, user.getSenha());
               
            this.result = this.statement.executeQuery();
            this.result.next();
            gerente.setId(this.result.getInt(1));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerente;
    }
}
