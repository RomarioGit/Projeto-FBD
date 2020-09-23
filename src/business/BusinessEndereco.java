package business;

import dao.DaoEndereco;
import exception.BusinessException;
import exception.DaoException;
import model.Endereco;

public class BusinessEndereco implements IBusinessEndereco {
    private DaoEndereco daoEndereco;

    public BusinessEndereco() {
        this.daoEndereco = new DaoEndereco();
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) throws BusinessException {
        try {
            endereco = daoEndereco.salvarEndereco(endereco);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return endereco;
    }
}
