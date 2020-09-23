package dao;

import exception.DaoException;
import model.Contato;

public interface IDaoContato {
    public Contato salvarContato(Contato contato) throws DaoException;
}
