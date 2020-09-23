package dao;

import controller.ConectionBD;
import exception.DaoException;
import model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoContato implements IDaoContato {
    private Connection conexao;
    private PreparedStatement statement;

    public DaoContato() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Contato salvarContato(Contato contato) throws DaoException {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO contato" + "(email, telefone)" + "VALUES(?,?)");
            this.statement.setString(1, contato.getEmail());
            this.statement.setString(2, contato.getTelefone());
            this.statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contato;
    }
}
