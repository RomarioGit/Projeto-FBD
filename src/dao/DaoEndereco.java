package dao;

import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEndereco implements IDaoEndereco {
    private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoEndereco() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO endereco" + "(rua, bairro, cidade, cep, estado, complemento)" +
                    "VALUES(?,?,?,?,?,?,?) returning id");
            this.statement.setString(1, endereco.getRua());
            this.statement.setString(2, endereco.getBairro());
            this.statement.setString(3, endereco.getCidade());
            this.statement.setString(4, endereco.getCep());
            this.statement.setString(5, endereco.getEstado());
            this.statement.setString(6, endereco.getComplemento());
            
            this.result = this.statement.executeQuery();
            this.result.next();
            endereco.setId(this.result.getInt(1));  
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

	@Override
	public Endereco buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT endereco.rua, endereco.bairro, endereco.cidade, endereco.cep, endereco.estado,"
            		+ "endereco.complemento FROM "+"endereco"+" endereco WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Endereco endereco;
            if (result.next()) {
                String rua = result.getString(1);
                String bairro = result.getString(2);
                String cidade = result.getString(3);
                String cep = result.getString(4);
                String estado = result.getString(5);
                String complemento = result.getString(6);
                endereco = new Endereco(id);
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setCep(cep);
                endereco.setEstado(estado);
                endereco.setComplemento(complemento);
                return endereco;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Endereco não encontrado.");
        }
	}

	@Override
	public ArrayList<Endereco> getAll() throws ExceptionGeral {
		ArrayList<Endereco> contatos = new ArrayList<Endereco>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.rua, a.bairro, a.cidade, a.cep, a.estado, a.complemento FROM "+"endereco"+" as a");
            result = this.statement.executeQuery();
            Endereco endereco;
            while (result.next()) {
            	    String rua = result.getString(1);
	                String bairro = result.getString(2);
	                String cidade = result.getString(3);
	                String cep = result.getString(4);
	                String estado = result.getString(5);
	                String complemento = result.getString(6);
	                endereco = new Endereco(rua, bairro, cidade, cep, estado, complemento);
	                contatos.add(endereco);
            }
            return contatos;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Endereco não encontrado.");
        }
	}
}
