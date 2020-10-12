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
    	
    	if (endereco.getCep().matches("^[a-Z]")) {
			throw new ExceptionGeral("O CEP deve conter apenas números!");
		}
    	if (!endereco.getBairro().contains("^[a-Z]")) {
			throw new ExceptionGeral("O Bairro deve conter apenas letras!");
		}
    	if (!endereco.getCidade().contains("^[a-Z]")) {
			throw new ExceptionGeral("A cidade deve conter apenas letras!");
		}
    	if (!endereco.getEstado().contains("^[a-Z]")) {
			throw new ExceptionGeral("O Estado deve conter apenas letras!");
		}
    	if (!endereco.getRua().contains("^[a-Z]")) {
			throw new ExceptionGeral("A Rua deve conter apenas letras!");
		}
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
