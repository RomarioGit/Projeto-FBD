package business;

import exception.BusinessException;
import model.Endereco;

public interface IBusinessEndereco {
    public Endereco salvarEndereco(Endereco endereco) throws BusinessException;
}
