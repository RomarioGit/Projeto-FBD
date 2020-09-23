package dao;

import exception.DaoException;
import model.Usuario;

public interface IDaoUsuario {
    public Usuario salvarUsuario(Usuario usuario) throws DaoException;
}
