package com.ebac.dao;

import com.ebac.domain.Cliente;

import java.util.Collection;

/**
 * @author rafael.oliveira
 **/
public interface IClienteDAO {
    Boolean cadastrar(Cliente cliente);

    void excluir(Long cpf);

    void alterar(Cliente cliente);

    Cliente consultar(Long cpf);

    Collection<Cliente> buscarTodos();
}
