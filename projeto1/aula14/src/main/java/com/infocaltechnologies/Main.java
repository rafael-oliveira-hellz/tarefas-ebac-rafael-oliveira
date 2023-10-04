package com.infocaltechnologies;

import com.infocaltechnologies.dao.ClienteMapDAO;
import com.infocaltechnologies.dao.IClienteDAO;
import com.infocaltechnologies.domain.Cliente;

import javax.swing.*;
import java.util.Objects;

/**
 * @author rafael.oliveira
 **/
public class Main {
    public static void main(String[] args) {
        IClienteDAO clienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"""
                Digite a opção desejada:
                1 - Cadastrar
                2 - Alterar
                3 - Excluir
                4 - Consultar
                5 - Buscar todos
                6 - Sair""", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if (Objects.equals(opcao, "") || Objects.equals(opcao, "6")) {
                sair();
            }

            opcao = JOptionPane.showInputDialog(null,"""
                    Digite a opção desejada:
                    1 - Cadastrar
                    2 - Alterar
                    3 - Excluir
                    4 - Consultar
                    5 - Buscar todos
                    6 - Sair""", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        }

       while (isOpcaoValida(opcao)) {
           if (isOpcaoSair(opcao)) {
               sair();
           } else if (isOpcaoCadastro(opcao)) {
               String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula (nome, CPF, telefone, endereco, numero, bairro, cidade, estado)", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

               cadastrar(dados);
           } else if (isOpcaoConsultar(opcao)) {
               String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

               consultar(cpf);
           } else if (isOpcaoAlterar(opcao)) {
               String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

               alterar(cpf);
           } else if (isOpcaoExcluir(opcao)) {
               String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

               excluir(cpf);
           } else if (isOpcaoBuscarTodos(opcao)) {
               buscarTodos();
           }

           opcao = JOptionPane.showInputDialog(null,"""
                    Digite a opção desejada:
                    1 - Cadastrar
                    2 - Alterar
                    3 - Excluir
                    4 - Consultar
                    5 - Buscar todos
                    6 - Sair""", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
       }
    }

    private static void buscarTodos() {
        IClienteDAO clienteDAO = new ClienteMapDAO();

        StringBuilder clientes = new StringBuilder();

        for (Cliente cliente : clienteDAO.buscarTodos()) {
            clientes.append(cliente.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, clientes.toString(), "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isOpcaoBuscarTodos(String opcao) {
        return Objects.equals(opcao, "5");
    }

    private static void excluir(String cpf) {
        IClienteDAO clienteDAO = new ClienteMapDAO();

        clienteDAO.excluir(Long.valueOf(cpf));

        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isOpcaoExcluir(String opcao) {
        return Objects.equals(opcao, "3");
    }

    private static void alterar(String cpf) {
        IClienteDAO clienteDAO = new ClienteMapDAO();

        Cliente cliente = clienteDAO.consultar(Long.valueOf(cpf));

        if (cliente != null) {
            String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula (nome, CPF, telefone, endereco, numero, bairro, cidade, estado)", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);

            String[] dadosCliente = dados.split(",");

            String nome = isValid(dadosCliente, 0) ? dadosCliente[0] : null;
            String telefone = String.valueOf(isValid(dadosCliente, 2) ? Long.valueOf(dadosCliente[2]) : null);
            String endereco = isValid(dadosCliente, 3) ? dadosCliente[3] : null;
            String numero = String.valueOf(isValid(dadosCliente, 4) ? Integer.valueOf(dadosCliente[4]) : null);
            String bairro = isValid(dadosCliente, 5) ? dadosCliente[5] : null;
            String cidade = isValid(dadosCliente, 6) ? dadosCliente[6] : null;
            String estado = isValid(dadosCliente, 7) ? dadosCliente[7] : null;

            cliente.setNome(nome);
            cliente.setTelefone(Long.valueOf(telefone));
            cliente.setEndereco(endereco);
            cliente.setNumero(Integer.valueOf(numero));
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            clienteDAO.alterar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoAlterar(String opcao) {
        return Objects.equals(opcao, "2");
    }

    private static void consultar(String cpf) {
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");

        if (cpfNumerico.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        IClienteDAO clienteDAO = new ClienteMapDAO();

        Cliente cliente = clienteDAO.consultar(Long.valueOf(cpf));

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.toString(), "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoConsultar(String opcao) {
        return Objects.equals(opcao, "4");
    }

    private static void cadastrar(String dados) {
        String[] dadosCliente = dados.split(",");

        String nome = isValid(dadosCliente, 0) ? dadosCliente[0] : null;
        String cpf = isValid(dadosCliente, 1) ? dadosCliente[1] : null;
        String telefone = isValid(dadosCliente, 2) ? dadosCliente[2] : null;
        String endereco = isValid(dadosCliente, 3) ? dadosCliente[3] : null;
        String numero = isValid(dadosCliente, 4) ? dadosCliente[4] : null;
        String bairro = isValid(dadosCliente, 5) ? dadosCliente[5] : null;
        String cidade = isValid(dadosCliente, 6) ? dadosCliente[6] : null;
        String estado = isValid(dadosCliente, 7) ? dadosCliente[7] : null;

        Cliente cliente = new Cliente(nome, cpf, telefone, endereco, numero, bairro, cidade, estado);

        IClienteDAO clienteDAO = new ClienteMapDAO();

        if (clienteDAO.cadastrar(cliente)) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Falha no cadastro do cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isValid(String[] array, int index) {
        return index < array.length && array[index] != null && !array[index].trim().isEmpty();
    }

    private static boolean isOpcaoSair(String opcao) {
        return Objects.equals(opcao, "6");
    }

    private static boolean isOpcaoValida(String opcao) {
        return Objects.equals(opcao, "1") || Objects.equals(opcao, "2") || Objects.equals(opcao, "3") || Objects.equals(opcao, "4") || Objects.equals(opcao, "5");
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar o Red Velvet Dinner!", "Red Velvet Dinner", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoCadastro(String opcao) {
        return Objects.equals(opcao, "1");
    }
}