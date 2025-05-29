import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Requisicao {
    private static int proximoCodigo = 1;
    private final int codigo;
    private final LocalDate data;
    private final Map<Item, Integer> itensRequisitados;
    Auxiliares aux = new Auxiliares();

    public Requisicao() {
        this.codigo = proximoCodigo++;
        this.data = LocalDate.now();
        this.itensRequisitados = new HashMap<>();
    }

    public boolean adicionarItem(Item item, double quantidade) {
        if (item.getQuantidade() >= quantidade && quantidade > 0) {
            itensRequisitados.put(item, (int) (itensRequisitados.getOrDefault(item, 0) + quantidade));
            aux.msg( "Item adicionado à requisição.");
            return true;
        } else {
            aux.msg("Estoque insuficiente ou quantidade inválida.");
            return false;
        }
    }

    public void listarItensTemporarios() {
        if (itensRequisitados.isEmpty()) {
            aux.msg( "Nenhum item adicionado à requisição.");
            return;
        }

        StringBuilder sb = new StringBuilder("Itens na requisição:\n");
        for (Map.Entry<Item, Integer> entry : itensRequisitados.entrySet()) {
            sb.append("Código: ").append(entry.getKey().getCodigo())
                    .append(" | Descrição: ").append(entry.getKey().getDescricao())
                    .append(" | Quantidade: ").append(entry.getValue()).append("\n");
        }
        aux.msg( sb.toString());
    }

    public void confirmar() {
        for (Map.Entry<Item, Integer> entry : itensRequisitados.entrySet()) {
            entry.getKey().removerQuantidade(entry.getValue());
        }
        aux.msg("Requisição #" + codigo + " confirmada e estoque atualizado.");
    }

    public LocalDate getData() {
        return data;
    }

    public int getCodigo() {
        return codigo;
    }
}
