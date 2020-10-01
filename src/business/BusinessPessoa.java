package business;

import java.util.ArrayList;

import dao.DaoPessoa;

import exception.ExceptionGeral;
import model.Pessoa;

public class BusinessPessoa implements IBusinessPessoa {
    private DaoPessoa daoPessoa;

    public BusinessPessoa() {
        this.daoPessoa = new DaoPessoa();
    }

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) throws ExceptionGeral {
    	try {
    		pessoa = daoPessoa.salvarPessoa(pessoa);
		} catch (ExceptionGeral e) {
			e.printStackTrace();
		}
		return pessoa;
    }

	@Override
	public Pessoa buscarID(int id) throws ExceptionGeral {
		return daoPessoa.buscarID(id);
	}
	
	@Override
	public ArrayList<Pessoa> getAll() throws ExceptionGeral {
		return daoPessoa.getAll();
	}
	
}
