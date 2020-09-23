package business;

import exception.BusinessException;
import model.Contato;

public interface IBusinessContato {
    public Contato salvarContato(Contato contato) throws BusinessException;
}
