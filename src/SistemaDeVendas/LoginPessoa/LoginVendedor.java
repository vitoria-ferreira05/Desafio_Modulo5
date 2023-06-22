package SistemaDeVendas.LoginPessoa;

import SistemaDeVendas.Pessoa;
import SistemaDeVendas.exception.EmailSemArrobaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static SistemaDeVendas.LoginPessoa.CriptografiaSenha.criptografarSenha;

public class LoginVendedor extends Pessoa{
    static Scanner sc = new Scanner(System.in);
    static List<Pessoa> vendedorCadastrado = new ArrayList<>();

   public LoginVendedor(String email, String senha) {
        super(email, senha);
    }
    public static void realizarLoginVendedor() {
        System.out.println("Digite o email do vendedor: ");
        String emailLogin = sc.next();

        if (!emailLogin.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }
        System.out.println("Digite a senha: ");
        String senhaLogin = sc.next();

        String senhaCripto = criptografarSenha(senhaLogin);

        for (Pessoa pessoa : vendedorCadastrado) {
            if (pessoa.getEmail().equals(emailLogin) && pessoa.getSenha().equals(senhaCripto)) {
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Email ou senha inválida!");
            }
        }
    }

    public static void resgistrarDadosLoginVendedor() {
        System.out.println("Digite o email do cliente: ");
        String emailLogin = sc.next();

        if (!emailLogin.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }
        System.out.println("Digite a senha: ");
        String senhaLogin = sc.next();

        String senhaCripto = criptografarSenha(senhaLogin);

        vendedorCadastrado.add(new Pessoa(emailLogin, senhaCripto));
    }
    public static void mostrarVendedoresCadastrados() {
        if(vendedorCadastrado.isEmpty()){
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for(Pessoa pessoa : vendedorCadastrado){
                System.out.println(pessoa.toString());
            }
        }
    }
}

