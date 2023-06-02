package SistemaDeVendas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true){
            System.out.println("Qual cadastro deseja realizar? " +
                    "\n 1. Cadastrar cliente" +
                    "\n 2. Cadastrar Vendedor" +
                    "\n 3. Cadastrar vendas" +
                    "\n 4. Comprar" +
                    "\n 5. Sair");
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    Vendedor vendedor = new Vendedor();
                    vendedor.cadastrarVendedor();
                    break;
                case 3:
                    Venda venda = new Venda();
                    venda.cadastrarVendas();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("O sistema de vendas foi encerrado.");
                    System.exit(0);;
                default:
                    System.out.println("Essa opção foi inválida, tente novamente!");
                    break;
            }
        }
    }
}
