package dao;

import controller.ConectionBD;
import exception.DaoException;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUsuario implements IDaoUsuario {
    private Connection conexao;
    private PreparedStatement statement;

    public DaoUsuario() {
        this.conexao = ConectionBD.getInstance();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) throws DaoException {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO usuario " + "(login, senha)" + "VALUES (?,?)");
            this.statement.setString(1, usuario.getLogin());
            this.statement.setString(2, usuario.getSenha());
            this.statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
