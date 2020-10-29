package dao;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Mesa;

public interface IDaoMesa {
	
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral;
	public Mesa buscarID(int id) throws ExceptionGeral;
    public ArrayList<Mesa> getAll() throws ExceptionGeral;
    public Mesa atualizaMesa(Mesa mesa) throws ExceptionGeral;
    
}
