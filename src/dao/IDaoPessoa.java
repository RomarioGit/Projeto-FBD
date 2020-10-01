package dao;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Pessoa;

public interface IDaoPessoa {
    
	public Pessoa salvarPessoa(Pessoa pessoa) throws ExceptionGeral;
	public Pessoa buscarID(int id) throws ExceptionGeral;
    public ArrayList<Pessoa> getAll() throws ExceptionGeral;
    
}
