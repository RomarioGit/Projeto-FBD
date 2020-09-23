package facade;

import exception.BusinessException;
import model.Contato;
import model.Endereco;
import model.Pessoa;
import model.Usuario;

public interface IFacade {
    // Pessoa
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException;

    //usuario
    public Usuario salvarUsuario(Usuario usuario) throws BusinessException;

    //contato
    public Contato salvarContato(Contato contato) throws BusinessException;

    //endereco
    public Endereco salvarEndereco(Endereco endereco) throws BusinessException;

}
