package facade;

import java.util.ArrayList;

import exception.ExceptionGeral;
import model.Contato;
import model.Endereco;
import model.Garcon;
import model.Gerente;
import model.Mesa;
import model.Pessoa;
import model.Usuario;

public interface IFacade {
    // Pessoa
	public Pessoa salvarPessoa(Pessoa pessoa) throws ExceptionGeral;
	public Pessoa buscarIDPessoa(int id) throws ExceptionGeral;
    public ArrayList<Pessoa> getAllPessoa() throws ExceptionGeral;
    
    //usuario
    public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral;
	public Usuario buscarIDUsuario(int id) throws ExceptionGeral;
	public ArrayList<Usuario> getAllUsuario() throws ExceptionGeral;
	
    //contato
    public Contato salvarContato(Contato contato) throws ExceptionGeral;
	public Contato buscarIDContato(int id) throws ExceptionGeral;
    public ArrayList<Contato> getAllContato() throws ExceptionGeral;

    //endereco
    public Endereco salvarEndereco(Endereco endereco) throws ExceptionGeral;
	public Endereco buscarIDEndereco(int id) throws ExceptionGeral;
    public ArrayList<Endereco> getAllEndereco() throws ExceptionGeral;
    
    //Mesa
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral;
	public Mesa buscarIDMesa(int id) throws ExceptionGeral;
    public ArrayList<Mesa> getAllMesa() throws ExceptionGeral;
    
    //Gerente
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral;
	public Gerente buscarIDGerente(int id) throws ExceptionGeral;
    public ArrayList<Gerente> getAllGerente() throws ExceptionGeral;
    
    //Garcon
	public Garcon salvarGarcon(Garcon garcon) throws ExceptionGeral;
	public Garcon buscarIDGarcon(int id) throws ExceptionGeral;
    public ArrayList<Garcon> getAllGarcon() throws ExceptionGeral;

}
