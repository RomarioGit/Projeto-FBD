package dao;

import controller.ConectionBD;
import exception.DaoException;
import model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoEndereco implements IDaoEndereco {
    private Connection conexao;
    private PreparedStatement statement;

    public DaoEndereco() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) throws DaoException {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO endereco" + "(id, rua, bairro, cidade, cep, estado, complemento)" +
                    "VALUES(?,?,?,?,?,?,?)");
            this.statement.setInt(1, endereco.getId());
            this.statement.setString(2, endereco.getRua());
            this.statement.setString(3, endereco.getBairro());
            this.statement.setString(4, endereco.getCidade());
            this.statement.setString(5, endereco.getCep());
            this.statement.setString(6, endereco.getEstado());
            this.statement.setString(7, endereco.getComplemento());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }
}
