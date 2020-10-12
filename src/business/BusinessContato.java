package business;

import java.util.ArrayList;

import dao.DaoContato;
import exception.ExceptionGeral;
import model.Contato;

public class BusinessContato implements IBusinessContato {
   
	private DaoContato daoContato;

    public BusinessContato() {
        this.daoContato = new DaoContato();
    }

    @Override
    public Contato salvarContato(Contato contato) throws ExceptionGeral {
		
    	if (contato.getTelefone().matches("^[a-Z]")) {
			throw new ExceptionGeral("Deve conter apenas números!");
		}
    	try {
            contato = daoContato.salvarContato(contato);
        } catch (ExceptionGeral e) {
            e.printStackTrace();
        }
        return contato;
    }

	@Override
	public Contato buscarID(int id) throws ExceptionGeral {
		return daoContato.buscarID(id);
	}

	@Override
	public ArrayList<Contato> getAll() throws ExceptionGeral {
		return daoContato.getAll();
	}
	
}
