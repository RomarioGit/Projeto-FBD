package business;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Mesa;

public interface IBusinessMesa {
	
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral;
	public Mesa buscarID(int id) throws ExceptionGeral;
    public ArrayList<Mesa> getAll() throws ExceptionGeral;
	public void atualizaMesa(Mesa mesa) throws ExceptionGeral;
}
