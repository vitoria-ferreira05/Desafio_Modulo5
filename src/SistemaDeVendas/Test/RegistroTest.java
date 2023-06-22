package SistemaDeVendas.Test;

import SistemaDeVendas.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class RegistroTest {

    static Venda venda = new Venda();

    @Test
    public void testGetVendasPeloCpfCliente() {

        String cpfBuscado = "123456789";
        List<Venda> vendasEsperadas = new ArrayList<>();

        List<Venda> vendasEncontradas = venda.getVendasPeloCpfCliente(cpfBuscado);

        Assertions.assertEquals(vendasEsperadas, vendasEncontradas.size());
        Assertions.assertTrue(vendasEncontradas.containsAll(vendasEsperadas));
    }

    @Test
    public void testGetVendasPeloEmailVendedor() {
        String emailBuscado = "vendedor@example.com";

        List<Venda> vendasEsperadas = new ArrayList<>();

        List<Venda> vendasEncontradas = venda.getVendasPeloEmailVendedor(emailBuscado);

        Assertions.assertEquals(vendasEsperadas.size(), vendasEncontradas.size());
        Assertions.assertTrue(vendasEncontradas.containsAll(vendasEsperadas));
    }

    @Test
    public void testGetClientePeloCPF() {
        String cpfBuscado = "123456789";

        Cliente clienteEsperado = new Cliente("Maria", "985.640.000-75", "maria@gmail.com", null);

        Cliente clienteEncontrado = venda.getClientePeloCPF(cpfBuscado);

        Assertions.assertEquals(clienteEsperado, clienteEncontrado);
    }

    @Test
    public void testGetVendedorPeloCPF() {
        String cpfBuscado = "987654321";

        Vendedor vendedorEsperado = new Vendedor("Maria", "985.640.000-75", "maria@gmail.com", null);

        Vendedor vendedorEncontrado = venda.getVendedorPeloCPF(cpfBuscado);

        Assertions.assertEquals(vendedorEsperado, vendedorEncontrado);
    }

    @Test
    public void testGetProdutoPeloId() {
        String idBuscado = "ABC123";
        Produto produtoEsperado = new Produto("ABC123", "pao", 2.00);

        Produto produtoEncontrado = venda.getProdutoPeloId(idBuscado);

        Assertions.assertEquals(produtoEsperado, produtoEncontrado);
    }
}

