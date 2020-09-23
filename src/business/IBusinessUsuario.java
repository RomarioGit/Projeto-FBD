package business;

import exception.BusinessException;
import model.Usuario;

public interface IBusinessUsuario {
    public Usuario salvarUsuario(Usuario usuario) throws BusinessException;
}
