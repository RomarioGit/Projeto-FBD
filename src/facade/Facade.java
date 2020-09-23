package facade;

import business.BusinessContato;
import business.BusinessEndereco;
import business.BusinessPessoa;
import business.BusinessUsuario;
import exception.BusinessException;
import model.Contato;
import model.Endereco;
import model.Pessoa;
import model.Usuario;

public class Facade implements IFacade {
    private BusinessPessoa businessPessoa =  new BusinessPessoa();
    private BusinessUsuario businessUsuario = new BusinessUsuario();
    private BusinessContato businessContato = new BusinessContato();
    private BusinessEndereco businessEndereco = new BusinessEndereco();

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException {

        return this.businessPessoa.salvarPessoa(pessoa);
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) throws BusinessException {
        return this.businessUsuario.salvarUsuario(usuario);
    }

    @Override
    public Contato salvarContato(Contato contato) throws BusinessException {
        return this.businessContato.salvarContato(contato);
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) throws BusinessException {
        return this.businessEndereco.salvarEndereco(endereco);
    }
}
