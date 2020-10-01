package business;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Contato;

public interface IBusinessContato {
	
    public Contato salvarContato(Contato contato) throws ExceptionGeral;
	public Contato buscarID(int id) throws ExceptionGeral;
    public ArrayList<Contato> getAll() throws ExceptionGeral;
    
}
