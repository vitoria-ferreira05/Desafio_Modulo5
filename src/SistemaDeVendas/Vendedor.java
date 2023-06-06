package SistemaDeVendas;

import SistemaDeVendas.exception.DadosJaCadastradosException;

public class Vendedor extends Pessoa {

    public Vendedor(String nome, String cpf, String email, Registro registro) {
        super(nome, cpf, email);
        if (registro != null) {
            validaCpfVendedorJaCadastrado(registro, cpf, email);
        }
    }

    void validaCpfVendedorJaCadastrado(Registro registro, String cpf, String email) {
        for (Vendedor vendedor : registro.getVendedores()) {
            if (vendedor.getCpf().equals(cpf) || vendedor.getCpf().equals(email)) {
                throw new DadosJaCadastradosException("CPF ou Email ja cadastrado para esse vendedor");
            }
        }
    }
}
