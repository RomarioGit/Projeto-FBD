package business;

import dao.DaoContato;
import exception.BusinessException;
import exception.DaoException;
import model.Contato;

public class BusinessContato implements IBusinessContato {
    private DaoContato daoContato;

    public BusinessContato() {
        this.daoContato = new DaoContato();
    }

    @Override
    public Contato salvarContato(Contato contato) throws BusinessException {
        try {
            contato = daoContato.salvarContato(contato);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return contato;
    }
}
