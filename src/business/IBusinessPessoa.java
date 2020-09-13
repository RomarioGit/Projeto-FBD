package business;

import exception.BusinessException;
import model.Pessoa;

public interface IBusinessPessoa {
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException;
}
