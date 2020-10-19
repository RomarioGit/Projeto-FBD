package business;

import java.util.ArrayList;

import dao.DaoMesa;
import dao.IDaoMesa;
import exception.ExceptionGeral;
import model.Mesa;

public class BusinessMesa implements IBusinessMesa{
	
	private IDaoMesa daoMesa;

	public BusinessMesa() {
		this.daoMesa = new DaoMesa();
	}

	@Override
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral {
		
		if (mesa.getHora_entrada().matches("^[a-Z]")) {
			throw new ExceptionGeral("A hora de entrada deve conter apenas numeros!");
		}
		if (mesa.getHora_saida().matches("^[a-Z]")) {
			throw new ExceptionGeral("A hora de saída deve conter apenas numeros!");
		}
		if (mesa.getNumero().matches("^[a-Z]")) {
			throw new ExceptionGeral("O número de entrada deve conter apenas numeros!");
		}
		if (mesa.getValor_conta().matches("^[a-Z]")) {
			throw new ExceptionGeral("O valor da deve conter apenas numeros!");
		}
		if (!mesa.getCliente().matches("^[a-Z]")) {
			throw new ExceptionGeral("O cliente deve conter apenas letras!");
		}
		try {
        	mesa = daoMesa.salvarMesa(mesa);
        } catch (ExceptionGeral e) {
            e.printStackTrace();
        }
        return mesa;
    }

	@Override
	public Mesa buscarID(int id) throws ExceptionGeral {
		return daoMesa.buscarID(id);
	}

	@Override
	public ArrayList<Mesa> getAll() throws ExceptionGeral {
		return daoMesa.getAll();
	}

}
