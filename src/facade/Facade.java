package facade;

import business.BusinessPessoa;
import exception.BusinessException;
import model.Pessoa;

public class Facade implements IFacade {
    private BusinessPessoa businessPessoa =  new BusinessPessoa();;

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException {

        return this.businessPessoa.salvarPessoa(pessoa);
    }
}
