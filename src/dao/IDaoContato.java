package dao;

import java.util.ArrayList;
import exception.ExceptionGeral;
import model.Contato;

public interface IDaoContato {
	
    public Contato salvarContato(Contato contato) throws ExceptionGeral;
	public Contato buscarID(int id) throws ExceptionGeral;
    public ArrayList<Contato> getAll() throws ExceptionGeral;
    
}
