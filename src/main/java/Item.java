// Item.java
public class Item {
    private static int proximoCodigo = 1;

    private final int codigo;
    private final String descricao;
    private double quantidade;
    private double valor;

    public Item(String descricao, double valor) {
        this.codigo = proximoCodigo++;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(double qtd) {
        if (qtd > 0) {
            quantidade += qtd;
        }
    }

    public boolean removerQuantidade(double qtd) {
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
