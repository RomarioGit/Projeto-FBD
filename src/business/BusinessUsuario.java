package business;

import dao.DaoPessoa;
import dao.DaoUsuario;
import exception.BusinessException;
import exception.DaoException;
import model.Usuario;

public class BusinessUsuario implements IBusinessUsuario {
    private DaoUsuario daoUsuario;

    public BusinessUsuario() {
        this.daoUsuario = new DaoUsuario();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) throws BusinessException {
        try {
            usuario = daoUsuario.salvarUsuario(usuario);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
