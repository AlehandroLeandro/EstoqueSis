// Item.java
public class Item {
    private static int proximoCodigo = 1;

    private final int codigo;
    private final String descricao;
    private int quantidade;
    private double valor;

    public Item(String descricao, double valor) {
        this.codigo = proximoCodigo++;
        this.descricao = descricao;
        this.quantidade = 0;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int qtd) {
        if (qtd > 0) {
            quantidade += qtd;
        }
    }

    public boolean removerQuantidade(int qtd) {
        if (qtd > 0 && qtd <= quantidade) {
            quantidade -= qtd;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Descrição: " + descricao + " | Quantidade: " + quantidade;
    }
}
