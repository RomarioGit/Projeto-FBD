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

	@Override
	public void atualizaMesa(Mesa mesa) throws ExceptionGeral {
		daoMesa.atualizaMesa(mesa);
	}

}
