package SistemaDeVendas.exception;

public class ProdutoNaoEncontradoExeption extends RuntimeException{

    public ProdutoNaoEncontradoExeption(String message) {
        super(message);
    }
}
