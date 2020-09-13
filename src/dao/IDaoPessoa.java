package dao;

import exception.DaoException;
import model.Pessoa;

public interface IDaoPessoa {
    public Pessoa salvarPessoa(Pessoa pessoa) throws DaoException;
}
