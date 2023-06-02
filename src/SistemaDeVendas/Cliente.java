package SistemaDeVendas;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente{
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome completo do cliente: ");
        nome = sc.nextLine();
        System.out.print("CPF do cliente: ");
        cpf = sc.next();
        System.out.print("Email do cliente: ");
        email = sc.next();
    }
}
