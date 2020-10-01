package dao;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Endereco;

public interface IDaoEndereco {
	
    public Endereco salvarEndereco(Endereco endereco) throws ExceptionGeral;
	public Endereco buscarID(int id) throws ExceptionGeral;
    public ArrayList<Endereco> getAll() throws ExceptionGeral;
    
}
