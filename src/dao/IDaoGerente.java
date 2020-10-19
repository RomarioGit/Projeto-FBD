package dao;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Gerente;

public interface IDaoGerente {
	
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral;
	public Gerente buscarID(int id) throws ExceptionGeral;
    public ArrayList<Gerente> getAll() throws ExceptionGeral;
	
}
