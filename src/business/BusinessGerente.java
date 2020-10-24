package business;

import java.util.ArrayList;

import dao.DaoGerente;
import dao.IDaoGerente;
import exception.ExceptionGeral;
import model.Gerente;

public class BusinessGerente implements IBusinessGerente{
	
	private IDaoGerente daoGerente;
	
	public BusinessGerente() {
		super();
		this.daoGerente = new DaoGerente();
	}

	@Override
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral {

		try {
        	gerente = daoGerente.salvarGerente(gerente);
        } catch (ExceptionGeral e) {
            e.printStackTrace();
        }
        return gerente;
    }

	@Override
	public Gerente buscarID(int id) throws ExceptionGeral {
		return daoGerente.buscarID(id);
	}

	@Override
	public ArrayList<Gerente> getAll() throws ExceptionGeral {
		return daoGerente.getAll();
	}

}
