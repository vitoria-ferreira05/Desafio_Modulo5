package SistemaDeVendas.Test;

import SistemaDeVendas.Registro;
import SistemaDeVendas.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VendedorTest {

    private Registro registro;
    private List<Vendedor> vendedores;

    @BeforeEach
    public void setUp() {
        registro = new Registro();

        vendedores = new ArrayList<>();

        vendedores.add(new Vendedor("Maria", "907.172.190-62", "maria123@gmail.com", null));
        vendedores.add(new Vendedor("Maria Cristina", "025.145.350-26", "mariaCris123@gmail.com", null));

    }

    @Test
    public void testValidaCpfVendedorJaCadastrado_ThrowsException() {

        String cpfExistente = "123456789";
        String emailExistente = "vendedor2@example.com";

//        Assertions.assertThrows(DadosJaCadastradosException.class, () -> {
//            registro.validaClienteJaCadastrado(cpfExistente, emailExistente);
//        });
    }

    @Test
    public void testValidaCpfVendedorJaCadastrado_NoException() {
        String cpfNovo = "111111111";
        String emailNovo = "novovendedor@example.com";

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> {
            registro.validaClienteJaCadastrado(cpfNovo, emailNovo);
        });
    }
}
