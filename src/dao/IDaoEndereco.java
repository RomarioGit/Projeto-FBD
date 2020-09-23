package dao;

import exception.DaoException;
import model.Endereco;

public interface IDaoEndereco {
    public Endereco salvarEndereco(Endereco endereco) throws DaoException;
}
