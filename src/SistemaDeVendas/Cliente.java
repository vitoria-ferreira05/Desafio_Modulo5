package SistemaDeVendas;

import SistemaDeVendas.exception.DadosJaCadastradosException;

public class Cliente extends Pessoa {


    public Cliente(String nome, String cpf, String email, Registro registro) {
        super(nome, cpf, email);
        validaClienteJaCadastrado(registro, cpf, email);
    }

    void validaClienteJaCadastrado(Registro registro, String cpf, String email) {
        for (Cliente cliente : registro.getClientes()) {
            if (cliente.getCpf().equals(cpf) || cliente.getEmail().equals(email)) {
                throw new DadosJaCadastradosException("CPF ou Email ja cadastrado para esse cliente");
            }
        }
    }
}
