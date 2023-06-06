package SistemaDeVendas;

import SistemaDeVendas.exception.ProdutoNaoEncontradoExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Registro registro = new Registro();
    static Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void main(String[] args) {

        int opcao = 0;
        do {
            System.out.println("---Sistema de vendas---\n" +
                    "1 - Cadastrar produto \n" +
                    "2 - Ver produtos cadastrados\n" +
                    "3 - Cadastrar vendedor\n" +
                    "4 - Ver vendedores cadastrados\n" +
                    "5 - Cadastrar cliente\n" +
                    "6 - Ver clientes cadastrados\n" +
                    "7 - Registrar venda\n" +
                    "8 - Ver vendas\n" +
                    "9 - Ver vendas pelo cpf do cliente\n" +
                    "10 - Ver vendas pelo email do vendedor\n" +
                    "0 - Sair do sistema");
            opcao = Integer.parseInt(sc.nextLine());
            decisao(opcao);
        } while (opcao > 0);
    }

    protected static void decisao(int opcao) {
        switch (opcao) {
            case 1:
                Produto produto = cadastrarProduto();
                registro.getProdutos().add(produto);
                break;
            case 2:
                System.out.println(registro.getProdutos().toString());
                break;
            case 3:
                try {
                    Vendedor vendedor = cadastrarVendedor();
                    registro.getVendedores().add(vendedor);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println(registro.getVendedores().toString());
                break;
            case 5:
                try {
                    Cliente cliente = cadastrarCliente();
                    registro.getClientes().add(cliente);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                System.out.println(registro.getClientes().toString());
                break;
            case 7:
                try {
                    Venda venda = cadastrarVenda();
                    registro.getVendas().add(venda);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 8:
                System.out.println(registro.getVendas().toString());
                break;
            case 9:
                List<Venda> vendasCliente = getVendaPeloCPFCliente();
                System.out.println("As vendas do cliente sao:\n");
                System.out.println(vendasCliente.toString());
                break;
            case 10:
                List<Venda> vendasVendedor = getVendaPeloEmailVendedor();
                System.out.println("As vendas do vendedor sao:\n");
                System.out.println(vendasVendedor.toString());
                break;
            case 0:
                System.out.println("Obrigado por usar nosso sistema =))");
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }

    protected static List<Venda> getVendaPeloEmailVendedor() {
        System.out.println("Digite o email do vendedor:");
        String email = sc.nextLine();
        return registro.getVendasPeloEmailVendedor(email);
    }

    protected static List<Venda> getVendaPeloCPFCliente() {
        System.out.println("Digite o cpf do cliente:");
        String cpf = sc.nextLine();
        return registro.getVendasPeloCpfCliente(cpf);
    }

    protected static Venda cadastrarVenda() {
        System.out.println("Os clientes cadastrados sao:");
        System.out.println(registro.getClientes().toString());
        System.out.print("Escolha o cliente para essa venda pelo cpf:");
        String cpfCliente = sc.nextLine();
        Cliente cliente = registro.getClientePeloCPF(cpfCliente);
        System.out.println("Cliente encontrado:" + cliente.getNome());

        System.out.println("Vendedores cadastrados sao:");
        System.out.println(registro.getVendedores().toString());
        System.out.print("Escolha o vendedor para essa venda pelo cpf:");
        String cpfVendedor = sc.nextLine();
        Vendedor vendedor = registro.getVendedorPeloCPF(cpfVendedor);
        System.out.println("Vendedor encontrado: " + vendedor.getNome());

        System.out.print("Digite o id da venda: ");
        String idVenda = sc.nextLine();

        List<Produto> produtos = registrarProdutosDaVenda();

        return new Venda(cliente, vendedor, idVenda, produtos);
    }

    protected static List<Produto> registrarProdutosDaVenda() {
        List<Produto> produtos = new ArrayList<>();
        System.out.println("Cadastrando produtos da venda!");
        int opcao = 0;
        while (opcao != 2) {
            try {
                Produto produto = buscarProduto();
                produtos.add(produto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Produtos listados para a venda: " + produtos);
            System.out.println("Digite 2 se nao deseja registrar mais produtos na venda atual");
            opcao = Integer.parseInt(sc.nextLine());
        }
        return produtos;
    }

    protected static Produto buscarProduto() throws ProdutoNaoEncontradoExeption {
        System.out.println("Produtos disponiveis no estoque sao:");
        System.out.println(registro.getProdutos().toString());
        System.out.println("Escolha o produto pelo id:");
        String codProduto = sc.nextLine();
        return registro.getProdutoPeloId(codProduto);
    }

    protected static Cliente cadastrarCliente() {
        System.out.print("Digite o nome do cliente:");
        String nome = sc.nextLine();
        System.out.print("Digite o cpf do cliente:");
        String cpf = sc.nextLine();
        System.out.print("Digite o email do cliente:");
        String email = sc.nextLine();
        return new Cliente(nome, cpf, email, registro);
    }

    protected static Vendedor cadastrarVendedor() {
        System.out.print("Digite o nome do vendedor:");
        String nome = sc.nextLine();
        System.out.print("Digite o cpf do vendedor:");
        String cpf = sc.nextLine();
        System.out.print("Digite o email do vendedor:");
        String email = sc.nextLine();
        return new Vendedor(nome, cpf, email, registro);
    }

    protected static Produto cadastrarProduto() {
        System.out.print("Digite o id do produto:");
        String idProduto = sc.nextLine();
        System.out.print("Digite o nome do produto:");
        String nomeProduto = sc.nextLine();
        System.out.print("Digite o preco do produto:");
        Double valorProduto = Double.valueOf(sc.nextLine());

        return new Produto(idProduto, nomeProduto, valorProduto);
    }
}
