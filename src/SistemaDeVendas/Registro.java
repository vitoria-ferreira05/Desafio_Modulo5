package SistemaDeVendas;

import SistemaDeVendas.exception.ClienteNaoEncontradoExeption;
import SistemaDeVendas.exception.ProdutoNaoEncontradoExeption;
import SistemaDeVendas.exception.VendedorNaoEncontradoExeption;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<Venda> vendas = new ArrayList<>();
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>();

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Venda> getVendasPeloCpfCliente(String cpf) {
        List<Venda> vendasCliente = new ArrayList<>();
        for (Venda venda : this.vendas) {
            if (venda.getCliente().getCpf().equals(cpf)) {
                vendasCliente.add(venda);
            }
        }
        return vendasCliente;
    }

    public List<Venda> getVendasPeloEmailVendedor(String email) {
        List<Venda> vendas = new ArrayList<>();
        for (Venda venda : this.vendas) {
            if (venda.getVendedor().getEmail().equals(email)) {
                vendas.add(venda);
            }
        }
        return vendas;
    }

    public Cliente getClientePeloCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoExeption("Cliente nao encontrado para o cpf: " + cpf);
    }

    public Vendedor getVendedorPeloCPF(String cpf) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        throw new VendedorNaoEncontradoExeption("Vendedor nao encontrado para o cpf: " + cpf);
    }

    public Produto getProdutoPeloId(String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoExeption("Produto nao encontrado para o id: " + id);
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
