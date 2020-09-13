package dao;

import controller.ConectionBD;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoPessoa implements IDaoPessoa {
    private Connection conexao;
    private PreparedStatement statement;

    public DaoPessoa() {
        this.conexao = ConectionBD.getInstance();
    }

    public Pessoa salvarPessoa(Pessoa pessoa){
        try {
            this.statement = conexao.prepareStatement("" + " INSERT INTO pessoa " + "(id, cpf)" + "VALUES(?,?)" );
            this.statement.setInt(1, pessoa.getId());
            this.statement.setString(2, pessoa.getCpf());
            this.statement.execute();
        } catch (SQLException e) {
            System.out.println("Deu pau na inserção");
            e.printStackTrace();
        }
        return pessoa;
    }
}
