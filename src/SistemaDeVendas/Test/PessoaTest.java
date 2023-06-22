package SistemaDeVendas.Test;

import SistemaDeVendas.Pessoa;
import SistemaDeVendas.exception.EmailSemArrobaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class PessoaTest {
    @Test
    public void verificaSeEmailEstaValidado() {
        Pessoa pessoa = new Pessoa("Joana", "324.966.680-74", "joana@gmail.com");
        String email = "joana@gmail.com";
        if (!email.contains("@")) {
            throw new EmailSemArrobaException("@");
        }

        try {
            pessoa.validaEmail(email);
        } catch (EmailSemArrobaException e) {
            fail("Nao deveria ter lancado EmailSemArrobaException");
        }
    }
}

