package SistemaDeVendas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Venda {

    private Cliente cliente;
    private Vendedor vendedor;
    private double preco;
    private LocalDate dataDeRegistro;
    private String codigo;
    private int quantidade;
    private String nomeDoProduto;

    public Venda() {

    }

    public Venda(Cliente cliente, Vendedor vendedor, double preco, LocalDate dataDeRegistro, String codigo, int quantidade, String nomeDoProduto) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.preco = preco;
        this.dataDeRegistro = dataDeRegistro;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nomeDoProduto = nomeDoProduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void cadastrarVendas() {

        LocalDate dataDeregistro = LocalDate.now();
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Venda venda = new Venda();
        Set<Venda> vendas = new HashSet<>();

        Cliente primeiroCliente = new Cliente("Vitoria Nunes", "12345678910", "vitoria123@gmail.com");
        Cliente segundoCliente = new Cliente("Maria Santos", "45678912341", "marias@gmail.com");
        Vendedor vendedor = new Vendedor("Rose Cristina", "12345678912", "rosec1@gmail.com");
        Venda primeiraVenda = new Venda(primeiroCliente, vendedor, 3.0, LocalDate.of(2023, 12, 03), "321", 2, "caneta");
        Venda segundaVenda = new Venda(segundoCliente, vendedor, 2.0, LocalDate.of(2023, 12, 03), "3298", 3, "lapis");
        vendas.add(primeiraVenda);
        vendas.add(segundaVenda);


        boolean cadastrarMaisVendas = true;
        System.out.println("-------------------------------------");
        System.out.println("REALIZAR NOVOS CADASTROS");
        while (cadastrarMaisVendas) {
            System.out.print("Vendedor: ");
            vendedor.setNome(sc.nextLine());
            System.out.print("Cliente: ");
            primeiroCliente.setNome(sc.nextLine());
            System.out.println("Data de registro: " + dataDeregistro);
            System.out.print("Nome do produto: ");
            setNomeDoProduto(sc.next());
            System.out.print("Código do produto: ");
            setCodigo(sc.next());
            System.out.print("Preço: R$ ");
            setPreco(sc.nextDouble());
            System.out.print("Quantidade: ");
            setQuantidade(sc.nextInt());
            double valorTotalCompra = getPreco() * getQuantidade();
            System.out.println("Valor total da compra: R$ " + valorTotalCompra);

            vendas.add(venda);


            System.out.print("Deseja cadastrar outra venda? " +
                    "\n 1. Sim" +
                    "\n 2. Não" +
                    "\n 3. Consultar vendas cadastradas");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarMaisVendas = true;
                    break;
                case 2:
                    cadastrarMaisVendas = false;
                    break;
                case 3:
                    Set<Venda> novasVendas = new HashSet<>();
                    System.out.println("CADASTROS REALIZADOS");
                    for (Venda vendasCadastradas : vendas) {
                        System.out.println("-------------------------------------");
                        System.out.println("Data de registro: " + dataDeregistro);
                        System.out.println("Vendedor: " + vendedor);
                        System.out.println("Cliente: " + getCliente());
                        System.out.println("Código do produto: " + getCodigo());
                        System.out.println("Nome do produto: " + getNomeDoProduto());
                        System.out.println("Preço: " + getPreco());
                        System.out.println("Quantidade: " + getQuantidade());
                        double valorTotalCompras = getPreco() * getQuantidade();
                        System.out.println("Valor total da compra: R$ " + valorTotalCompras);

                        vendas.addAll(novasVendas);
                    }
                    break;
            }
        }
        System.out.println("Vendas cadastradas:");
        for (Venda vendasCadastradas : vendas) {
            System.out.println(vendasCadastradas);
        }
    }
}


