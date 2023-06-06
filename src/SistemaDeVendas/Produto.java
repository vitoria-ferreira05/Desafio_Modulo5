package SistemaDeVendas;

public class Produto {
    private String id;
    private String nome;
    private Double valor;

    public Produto(String id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto - " +
                "id: " + id +
                ", nome: " + nome +
                ", valor: " + valor;
    }
}
