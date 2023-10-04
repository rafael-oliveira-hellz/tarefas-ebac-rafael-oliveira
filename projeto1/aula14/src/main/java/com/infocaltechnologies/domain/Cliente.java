package com.infocaltechnologies.domain;

import java.util.Objects;

/**
 * @author rafael.oliveira
 **/
public class Cliente {
    private String nome;
    private Long cpf;
    private Long telefone;
    private String endereco;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente(String nome, String cpf, String telefone, String endereco, String numero, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.cpf = parseLongOrNull(cpf);
        this.telefone = parseLongOrNull(telefone);
        this.endereco = endereco;
        this.numero = parseIntOrNull(numero);
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    private Long parseLongOrNull(String s) {
        if (s == null || s.trim().isEmpty()) {
            return null;
        }
        try {
            return Long.valueOf(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseIntOrNull(String s) {
        if (s == null || s.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.valueOf(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente encontrado: {" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
