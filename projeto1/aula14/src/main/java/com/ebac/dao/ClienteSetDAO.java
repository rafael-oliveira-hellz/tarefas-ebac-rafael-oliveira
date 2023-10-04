package com.ebac.dao;

import com.ebac.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

/**
 * @author rafael.oliveira
 **/
public class ClienteSetDAO implements IClienteDAO {
    private final HashSet<Cliente> clientes;

    public ClienteSetDAO() {
        this.clientes = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.clientes.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        this.clientes.removeIf(cliente -> cpf.equals(cliente.getCpf()));
    }

    @Override
    public void alterar(Cliente cliente) {
        this.excluir(cliente.getCpf());
        this.cadastrar(cliente);
    }

    @Override
    public Cliente consultar(Long cpf) {
        Optional<Cliente> clienteOptional = this.clientes.stream().filter(cliente -> cpf.equals(cliente.getCpf())).findFirst();
        return clienteOptional.orElse(null);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.clientes;
    }
}
