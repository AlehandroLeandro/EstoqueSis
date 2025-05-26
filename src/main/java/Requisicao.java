import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Requisicao {
    Auxiliares aux = new Auxiliares();

    private static int geradorCodigo = 1;

    private final int codigo;
    private final LocalDate data;
    private final Map<Item, Integer> itens;
    private double valorTotal;

    public Requisicao() {
        this.codigo = geradorCodigo++;
        this.data = LocalDate.now();
        this.itens = new HashMap<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Item item, int quantidade) {
        if (quantidade > 0 && item.getQuantidade() >= quantidade) {
            item.removerQuantidade(quantidade);
            itens.put(item, itens.getOrDefault(item, 0) + quantidade);
            aux.msg(  "Item adicionado à requisição.");
        } else {
            aux.msg(  "Quantidade inválida ou insuficiente no estoque.");
        }
    }

    public void removerItem(int codigoItem) {
        Item encontrado = null;
        for (Item item : itens.keySet()) {
            if (item.getCodigo() == codigoItem) {
                encontrado = item;
                break;
            }
        }

        if (encontrado != null) {
            int qtdRemovida = itens.remove(encontrado);
            encontrado.adicionarQuantidade(qtdRemovida);
            aux.msg(  "Item removido da requisição.");
        } else {
            aux.msg(  "Item não encontrado na requisição.");
        }
    }

    public void mostrarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Requisição #").append(codigo).append(" - ").append(data).append("\n");
        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            sb.append("Item: ").append(entry.getKey().getDescricao())
                    .append(" | Quantidade: ").append(entry.getValue()).append("\n");
        }
        aux.msg(sb.toString());
    }
}
