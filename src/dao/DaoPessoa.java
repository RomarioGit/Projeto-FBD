package dao;

import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoPessoa implements IDaoPessoa {
  
	private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoPessoa() {
        this.conexao = ConectionBD.getInstance();
    }

    public Pessoa salvarPessoa(Pessoa pessoa) throws ExceptionGeral{
        try {
            this.statement = conexao.prepareStatement("" + " INSERT INTO pessoa " + "(cpf)" + "VALUES(?)" );
            this.statement.setString(2, pessoa.getCpf());
            this.statement.execute();
        } catch (SQLException e) {
            System.out.println("Deu pau na insercao");
            e.printStackTrace();
        }
        return pessoa;
    }

	@Override
	public Pessoa buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT pessoa.cpf FROM "+"pessoa"+" pessoa WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Pessoa pessoa;
            if (result.next()) {
                String cpf = result.getString(1);
                pessoa = new Pessoa(id);
                pessoa.setCpf(cpf);
                return pessoa;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Pessoa não encontrada.");
        }
	}

	@Override
	public ArrayList<Pessoa> getAll() throws ExceptionGeral {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.cpf FROM "+"pessoa"+" as a");
            result = this.statement.executeQuery();
            Pessoa pessoa;
            while (result.next()) {
            	    String cpf = result.getString(1);
            	    pessoa = new Pessoa(cpf);
	                pessoas.add(pessoa);
            }
            return pessoas;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Pessoa não encontrada.");
        }
	}
}
