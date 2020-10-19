package business;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Gerente;

public interface IBusinessGerente {
	
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral;
	public Gerente buscarID(int id) throws ExceptionGeral;
    public ArrayList<Gerente> getAll() throws ExceptionGeral;
    
}
