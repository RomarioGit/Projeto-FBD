package dao;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Garcon;

public interface IDaoGarcon {
	
	public Garcon salvarGarcon(Garcon garcon) throws ExceptionGeral;
	public Garcon buscarID(int id) throws ExceptionGeral;
    public ArrayList<Garcon> getAll() throws ExceptionGeral;
	
}
