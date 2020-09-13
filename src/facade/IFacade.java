package facade;

import exception.BusinessException;
import model.Pessoa;

public interface IFacade {
    // Pessoa
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException;

}
