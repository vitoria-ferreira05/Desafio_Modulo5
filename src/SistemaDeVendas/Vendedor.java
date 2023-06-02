package SistemaDeVendas;

import java.util.Scanner;

public class Vendedor {
    private String nome;
    private String cpf;
    private String email;

    public Vendedor(){

    }
    public Vendedor(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public void cadastrarVendedor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome completo do vendedor: ");
        nome = sc.nextLine();
        System.out.print("CPF do vendedor: ");
        cpf = sc.next();
        System.out.print("Email do vendedor: ");
        email = sc.next();
    }
}
