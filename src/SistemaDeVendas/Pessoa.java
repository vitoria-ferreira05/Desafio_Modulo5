package SistemaDeVendas;

import SistemaDeVendas.exception.EmailSemArrobaException;

public class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Pessoa(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }


    public Pessoa(String nome, String cpf, String email) {
        validaEmail(email);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void validaEmail(String email) {
        if (!email.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
