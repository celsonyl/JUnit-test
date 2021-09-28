package com.celso.domain;

import com.celso.domain.exceptions.IdadeNaoPermitidaException;

import java.util.List;

public class GerenciadoraClientes {

    private List<Cliente> clientesDoBanco;

    public GerenciadoraClientes(List<Cliente> clientesDoBanco) {
        this.clientesDoBanco = clientesDoBanco;
    }

    /**
     * Retorna uma lista com todos os clientes do banco.
     *
     * @return lista com todos os clientes do banco
     */
    public List<Cliente> getClientesDoBanco() {
        return clientesDoBanco;
    }

    /**
     * Pesquisa por um cliente a partir do seu ID.
     *
     * @param idCliente id do cliente a ser pesquisado
     * @return o cliente pesquisado ou null, caso não seja encontrado
     */
    public Cliente pesquisaCliente(int idCliente) {

        for (Cliente cliente : clientesDoBanco) {
            if (cliente.getId() == idCliente)
                return cliente;
        }
        return null;
    }

    /**
     * Adiciona um novo cliente à lista de clientes do banco.
     *
     * @param novoCliente novo cliente a ser adicionado
     */
    public void adicionaCliente(Cliente novoCliente) {
        clientesDoBanco.add(novoCliente);
    }

    /**
     * Remove cliente da lista de clientes do banco.
     *
     * @param idCliente ID do cliente a ser removido
     * @return true se o cliente foi removido. False, caso contrário.
     */
    public boolean removeCliente(int idCliente) {
        boolean clienteRemovido = false;

        for (int i = 0; i < clientesDoBanco.size(); i++) {
            Cliente cliente = clientesDoBanco.get(i);
            if (cliente.getId() == idCliente) {
                clientesDoBanco.remove(i);
                return true;
            }
        }

        return clienteRemovido;
    }

    public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
        if (idade < 18 || idade > 65)
            throw new IdadeNaoPermitidaException("Idade não permitida");

        return true;
    }
}