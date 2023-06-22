package SistemaDeVendas.Test;

import SistemaDeVendas.Registro;
import SistemaDeVendas.exception.DadosJaCadastradosException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {
    @Test
    public void validaOClienteQueJaEstaCadastrado() {
        Registro registro = new Registro();

        String cpf = "324.966.680-74";
        String email = "joana@gmail.com";

        try {
            registro.validaClienteJaCadastrado(cpf, email);
        } catch (DadosJaCadastradosException e) {
            assertEquals("CPF ou email ja cadastrado para esse cliente", e.getMessage());
        }
    }
}
