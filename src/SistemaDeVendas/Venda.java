package SistemaDeVendas;

import SistemaDeVendas.exception.ObjetoNullException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private String id;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<Produto> produtos = new ArrayList<>();
    private int quantidade;
    private Double valorTotalCompra;
    private LocalDate dataRegistro;


    public Venda(Cliente cliente, Vendedor vendedor, String id, List<Produto> produtos) {
        validaObjeto(cliente);
        validaObjeto(vendedor);
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.id = id;
        this.produtos = produtos;
        this.dataRegistro = LocalDate.now();
        this.quantidade = getQuantidadeProdutosVenda();
        this.valorTotalCompra = getValorTotalVenda();
    }

    public Venda() {

    }

    public Venda(Cliente cliente) {
    }

    public void validaObjeto(Object obj) {
        if (obj == null) {
            throw new ObjetoNullException("Erro ao cadastrar objeto nullo.");
        }
    }

    public String getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Double getValorTotalVenda() {
        double valorTotalCompra = 0.0;
        for (Produto produto : produtos) {
            valorTotalCompra += produto.getValor();
        }
        return valorTotalCompra;
    }

    public int getQuantidadeProdutosVenda() {
        return produtos.size();
    }


    @Override
    public String toString() {
        return "Venda: " +
                "\nid: " + id +
                "\ncliente: " + cliente +
                "\nvendedor: " + vendedor +
                "\nprodutos: " + produtos +
                "\nquantidade: " + quantidade +
                "\nvalorTotalCompra: " + valorTotalCompra +
                "\ndataRegistro: " + dataRegistro;
    }

    public void setVendas(List<Venda> vendas) {
    }

    public List<Venda> getVendasPeloCpfCliente(String cpfBuscado) {
        return null;
    }

    public List<Venda> getVendasPeloEmailVendedor(String emailBuscado) {
        return null;
    }

    public Cliente getClientePeloCPF(String cpfBuscado) {
        return null;
    }

    public Vendedor getVendedorPeloCPF(String cpfBuscado) {
        return null;
    }

    public Produto getProdutoPeloId(String idBuscado) {
        return null;
    }
}
