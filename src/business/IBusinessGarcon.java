package business;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Garcon;

public interface IBusinessGarcon {

	public Garcon salvarGacon(Garcon garcon) throws ExceptionGeral;
	public Garcon buscarID(int id) throws ExceptionGeral;
    public ArrayList<Garcon> getAll() throws ExceptionGeral;
    
}
