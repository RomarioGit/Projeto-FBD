package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.ConectionBD;
import exception.ExceptionGeral;
import model.Mesa;

public class DaoMesa implements IDaoMesa{
    
	private Connection conexao;
    private PreparedStatement statement;
	private ResultSet result;

    public DaoMesa() {
        this.conexao = ConectionBD.getInstance();
    }

	@Override
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("" + "INSERT INTO mesa" + "(numero, cliente, hora_entrada, status, pedido, valor_conta,"
            		+ "hora_saida)" + "VALUES(?,?,?,?,?,?,?) returning id");
            this.statement.setInt(1, mesa.getNumero());
            this.statement.setString(2, mesa.getCliente());
            this.statement.setString(3, mesa.getHora_entrada());
            this.statement.setString(4, mesa.getStatus());
            this.statement.setString(5, mesa.getPedido());
            this.statement.setDouble(6, mesa.getValor_conta());
            this.statement.setString(7, mesa.getHora_saida());


            this.result = this.statement.executeQuery();
            this.result.next();
            mesa.setId(this.result.getInt(1));

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesa;
    }

    @Override
    public Mesa atualizaMesa(Mesa mesa) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("UPDATE mesa set numero =?, cliente =?, hora_entrada =?, status =?, pedido =?, valor_conta =?,"
            + " hora_saida =? where id= " + mesa.getId());

            this.statement.setInt(1, mesa.getNumero());
            this.statement.setString(2, mesa.getCliente());
            this.statement.setString(3, mesa.getHora_entrada());
            this.statement.setString(4, mesa.getStatus());
            this.statement.setString(5, mesa.getPedido());
            this.statement.setDouble(6, mesa.getValor_conta());
            this.statement.setString(7, mesa.getHora_saida());

            this.statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesa;

    }

	@Override
	public Mesa buscarID(int id) throws ExceptionGeral {
        try {
            this.statement = conexao.prepareStatement("SELECT mesa.numero, mesa.cliente, mesa.hora_entrada, mesa.status, mesa.pedido,"
            		+ "mesa.valor_conta, mesa.hora_saida FROM "+"mesa"+" mesa WHERE ID = ?");
            this.statement.setInt(1, id);
            result = this.statement.executeQuery();
            Mesa mesa;
            if (result.next()) {
                Integer numero = result.getInt(1);
                String cliente = result.getString(2);
                String hora_entrada = result.getString(3);
                String status = result.getString(4);
                String pedido = result.getString(5);
                Double valor_conta = result.getDouble(6);
                String hora_saida = result.getString(7);
                mesa = new Mesa(id);
                mesa.setNumero(numero);
                mesa.setCliente(cliente);
                mesa.setHora_entrada(hora_entrada);
                mesa.setStatus(status);
                mesa.setPedido(pedido);
                mesa.setValor_conta(valor_conta);
                mesa.setHora_saida(hora_saida);
                return mesa;
            }
            throw new ExceptionGeral("ID INEXISTENTE");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Mesa n�o encontrada.");
        }
	}

	@Override
	public ArrayList<Mesa> getAll() throws ExceptionGeral {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        try {
            this.statement = conexao.prepareStatement("SELECT a.numero, a.cliente, a.hora_entrada, a.status, a.pedido,"
            		+ "a.valor_conta, a.hora_saida FROM "+"mesa"+" as a");
            result = this.statement.executeQuery();
            Mesa mesa;
            while (result.next()) {


                    Integer numero = result.getInt(1);
	                String cliente = result.getString(2);
	                String hora_entrada = result.getString(3);
	                String status = result.getString(4);
	                String pedido = result.getString(5);
	                Double valor_conta = result.getDouble(6);
	                String hora_saida = result.getString(7);


	                mesa = new Mesa(numero, cliente, hora_entrada, status, pedido, valor_conta, hora_saida);

	                mesas.add(mesa);
            }
            return mesas;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionGeral("Erro: Mesa não encontrada.");
        }
	}

}
