package cadastrocliente.dao;

import cadastrocliente.domain.Cliente;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rafael.oliveira
 **/
public class ClienteMapDAO implements IClienteDAO {
    private final Map<Long, Cliente> clientes;

    public ClienteMapDAO() {
        this.clientes = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.clientes.containsKey(cliente.getCpf())) {
            return false;
        }

        this.clientes.put(cliente.getCpf(), cliente);

        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente cliente = this.clientes.get(cpf);

        if (cliente != null) {
            this.clientes.remove(cliente.getCpf(), cliente);
        }
    }

    @Override
    public Boolean alterar(Cliente cliente) {
        System.out.println("Método alterar chamado para o CPF: " + cliente.getCpf());
        Cliente clienteCadastrado = this.clientes.get(cliente.getCpf());
        System.out.println("Chaves CPF no mapa: " + this.clientes.keySet());
        System.out.println("Cliente a ser atualizado: " + cliente);

        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTelefone(cliente.getTelefone());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setBairro(cliente.getBairro());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            
            System.out.println("Cliente atualizado: " + clienteCadastrado);
            
            return true;
        }
        
        return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.clientes.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.clientes.values();
    }
}
