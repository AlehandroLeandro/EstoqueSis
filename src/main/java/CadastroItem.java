// CadastroItem.java
import javax.swing.*;
import java.util.ArrayList;

public class CadastroItem {
    private ArrayList<Item> itens;
    private Auxiliares aux = new Auxiliares();

    public CadastroItem() {
        this.itens = new ArrayList<>();
    }

    public void cadastrarNovoItem() {
        String descricao = aux.receberTexto("Digite a descrição do novo item:");
        double valor = aux.receberDouble("Digite o valor do novo item:");
        if (descricao != null && !descricao.isEmpty()) {
            Item item = new Item(descricao, valor);
            itens.add(item);
            aux.msg( "Item cadastrado com sucesso!\n" + item);
        } else {
            aux.msg(  "Descrição inválida.");
        }
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public Item buscarPorCodigo(int codigo) {
        for (Item item : itens) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            aux.msg(  "Nenhum item cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder("Itens cadastrados:\n");
        for (Item item : itens) {
            sb.append(item).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
