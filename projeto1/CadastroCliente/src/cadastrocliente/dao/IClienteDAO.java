package cadastrocliente.dao;

import cadastrocliente.domain.Cliente;
import java.util.Collection;

/**
 * @author rafael.oliveira
 **/
public interface IClienteDAO {
    Boolean cadastrar(Cliente cliente);

    void excluir(Long cpf);

    Boolean alterar(Cliente cliente);

    Cliente consultar(Long cpf);

    Collection<Cliente> buscarTodos();
}
