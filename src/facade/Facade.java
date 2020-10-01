package facade;

import java.util.ArrayList;
import business.BusinessContato;
import business.BusinessEndereco;
import business.BusinessGarcon;
import business.BusinessGerente;
import business.BusinessMesa;
import business.BusinessPessoa;
import business.BusinessUsuario;
import business.IBusinessContato;
import business.IBusinessEndereco;
import business.IBusinessGarcon;
import business.IBusinessGerente;
import business.IBusinessMesa;
import business.IBusinessPessoa;
import business.IBusinessUsuario;
import exception.ExceptionGeral;
import model.Contato;
import model.Endereco;
import model.Garcon;
import model.Gerente;
import model.Mesa;
import model.Pessoa;
import model.Usuario;

public class Facade implements IFacade {
	
    private IBusinessPessoa businessPessoa;
    private IBusinessUsuario businessUsuario;
    private IBusinessContato businessContato;
    private IBusinessEndereco businessEndereco;
    private IBusinessMesa businessMesa;
    private IBusinessGarcon businessGarcon;
    private IBusinessGerente businessGerente;
    
	private static Facade instance;
		
	public Facade() {
		businessPessoa = new BusinessPessoa();
		businessUsuario = new BusinessUsuario();
		businessContato = new BusinessContato();
		businessEndereco = new BusinessEndereco();
		businessMesa = new BusinessMesa();
		businessGarcon = new BusinessGarcon();
		businessGerente = new BusinessGerente();
	}

	public static Facade getInstance() {
		if(instance == null) {
			instance = new Facade();
		}
		return instance;
	}
    
    @Override
	public Pessoa salvarPessoa(Pessoa pessoa) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessPessoa.salvarPessoa(pessoa);
	}
	@Override
	public Pessoa buscarIDPessoa(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessPessoa.buscarID(id);
	}
	@Override
	public ArrayList<Pessoa> getAllPessoa() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessPessoa.getAll();
	}
	@Override
	public Usuario salvarUsuario(Usuario usuario) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessUsuario.salvarUsuario(usuario);
	}
	@Override
	public Usuario buscarIDUsuario(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessUsuario.buscarID(id);
	}
	@Override
	public ArrayList<Usuario> getAllUsuario() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessUsuario.getAll();
	}
	@Override
	public Contato salvarContato(Contato contato) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessContato.salvarContato(contato);
	}
	@Override
	public Contato buscarIDContato(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessContato.buscarID(id);
	}
	@Override
	public ArrayList<Contato> getAllContato() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessContato.getAll();
	}
	@Override
	public Endereco salvarEndereco(Endereco endereco) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessEndereco.salvarEndereco(endereco);
	}
	@Override
	public Endereco buscarIDEndereco(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessEndereco.buscarID(id);
	}
	@Override
	public ArrayList<Endereco> getAllEndereco() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessEndereco.getAll();
	}
	@Override
	public Mesa salvarMesa(Mesa mesa) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessMesa.salvarMesa(mesa);
	}
	@Override
	public Mesa buscarIDMesa(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessMesa.buscarID(id);
	}
	@Override
	public ArrayList<Mesa> getAllMesa() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessMesa.getAll();
	}
	@Override
	public Gerente salvarGerente(Gerente gerente) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGerente.salvarGerente(gerente);
	}
	@Override
	public Gerente buscarIDGerente(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGerente.buscarID(id);
	}
	@Override
	public ArrayList<Gerente> getAllGerente() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGerente.getAll();
	}
	@Override
	public Garcon salvarGarcon(Garcon garcon) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGarcon.salvarGacon(garcon);
	}
	@Override
	public Garcon buscarIDGarcon(int id) throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGarcon.buscarID(id);
	}
	@Override
	public ArrayList<Garcon> getAllGarcon() throws ExceptionGeral {
		// TODO Auto-generated method stub
		return businessGarcon.getAll();
	}

}
