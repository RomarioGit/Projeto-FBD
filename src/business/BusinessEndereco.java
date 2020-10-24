package business;

import java.util.ArrayList;

import dao.DaoEndereco;
import exception.ExceptionGeral;
import model.Endereco;

public class BusinessEndereco implements IBusinessEndereco {
 
	private DaoEndereco daoEndereco;

    public BusinessEndereco() {
        this.daoEndereco = new DaoEndereco();
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) throws ExceptionGeral {

    	try {
            endereco = daoEndereco.salvarEndereco(endereco);
        } catch (ExceptionGeral e) {
            e.printStackTrace();
        }
        return endereco;
    }

	@Override
	public Endereco buscarID(int id) throws ExceptionGeral {
		return daoEndereco.buscarID(id);
	}


	@Override
	public ArrayList<Endereco> getAll() throws ExceptionGeral {
		return daoEndereco.getAll();
	}
}
