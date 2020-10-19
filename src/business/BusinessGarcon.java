package business;

import java.util.ArrayList;

import dao.DaoGarcon;
import dao.IDaoGarcon;
import exception.ExceptionGeral;
import model.Garcon;

public class BusinessGarcon implements IBusinessGarcon{

	private IDaoGarcon daoGarcon;
	
	public BusinessGarcon() {
		super();
		this.daoGarcon = new DaoGarcon();
	}

	@Override
	public Garcon salvarGacon(Garcon garcon) throws ExceptionGeral {
        
    	if (garcon.getCpf().matches("^[a-Z]")) {
			throw new ExceptionGeral("O CPF deve conter apenas números!");
		}
    	if (garcon.getData_nasc().matches("^[a-Z]")) {
			throw new ExceptionGeral("A Data de Nascimento deve conter apenas números!");
		}
    	if (!garcon.getNome().matches("^[a-Z]")) {
			throw new ExceptionGeral("A Nome deve conter apenas letras!");
		}
		try {
        	garcon = daoGarcon.salvarGarcon(garcon);
        } catch (ExceptionGeral e) {
            e.printStackTrace();
        }
        return garcon;
    }

	@Override
	public Garcon buscarID(int id) throws ExceptionGeral {
		return daoGarcon.buscarID(id);
	}
	
	@Override
	public ArrayList<Garcon> getAll() throws ExceptionGeral {
		return daoGarcon.getAll();
	}

}
