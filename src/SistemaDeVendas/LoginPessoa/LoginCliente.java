package SistemaDeVendas.LoginPessoa;

import SistemaDeVendas.Pessoa;
import SistemaDeVendas.exception.EmailSemArrobaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SistemaDeVendas.LoginPessoa.CriptografiaSenha.criptografarSenha;

public class LoginCliente extends Pessoa{
    static Scanner sc = new Scanner(System.in);
    static List<Pessoa> clienteCadastrado = new ArrayList<>();

    public LoginCliente(String email, String senha) {
        super(email, senha);
    }

    static public void realizarLoginCliente() {

        System.out.println("Digite o email do cliente: ");
        String emailLogin = sc.next();

        if (!emailLogin.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }
        System.out.println("Digite a senha: ");
        String senhaLogin = sc.next();

        String senhaCripto = criptografarSenha(senhaLogin);

        for (Pessoa pessoa: clienteCadastrado){
            if(pessoa.getEmail().equals(emailLogin) && pessoa.getSenha().equals(senhaCripto)){
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Email ou senha inválida!");
            }
        }
    }

    static public void resgistrarDadosLoginCliente(){
        System.out.println("Digite o email do cliente: ");
        String emailLogin = sc.next();

        if (!emailLogin.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }
        System.out.println("Digite a senha: ");
        String senhaLogin = sc.next();

        String senhaCripto = criptografarSenha(senhaLogin);

        clienteCadastrado.add(new Pessoa(emailLogin, senhaCripto));
    }

    public static void mostrarClientesCadastrados() {
        if(clienteCadastrado.isEmpty()){
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for(Pessoa pessoa : clienteCadastrado){
                System.out.println(pessoa.toString());
            }
        }

    }
}

