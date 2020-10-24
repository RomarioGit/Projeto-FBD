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
