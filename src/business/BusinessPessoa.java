package business;

import dao.DaoPessoa;
import exception.BusinessException;
import exception.DaoException;
import model.Pessoa;

public class BusinessPessoa implements IBusinessPessoa {
    private DaoPessoa daoPessoa;

    public BusinessPessoa() {
        this.daoPessoa = new DaoPessoa();
    }

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) throws BusinessException {
        pessoa = daoPessoa.salvarPessoa(pessoa);
        return pessoa;
    }
}
