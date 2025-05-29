import java.util.ArrayList;
import javax.swing.*;


public class GerenciadorRequisicoes {
    private final ArrayList<Requisicao> requisicoes = new ArrayList<>();
    Auxiliares aux = new Auxiliares();

    public void novaRequisicao(CadastroItem cadastro) {
        Requisicao requisicao = new Requisicao();

        while (true) {
            int codigo = aux.receberInt("Código do item (ou 0 para encerrar):");
            if (codigo == 0) break;

            Item item = cadastro.buscarPorCodigo(codigo);
            if (item == null) {
                aux.msg( "Item não encontrado.");
                continue;
            }

            double quantidade = aux.receberDouble("Quantidade:");
            requisicao.adicionarItem(item, quantidade);
        }

        requisicao.listarItensTemporarios();
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja confirmar esta requisição?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            requisicao.confirmar();
            requisicoes.add(requisicao);
        } else {
            aux.msg( "Requisição cancelada.");
        }
    }

    public void listarRequisicoes() {
        if (requisicoes.isEmpty()) {
            aux.msg( "Nenhuma requisição registrada.");
            return;
        }

        StringBuilder sb = new StringBuilder("Histórico de Requisições:\n");
        for (Requisicao r : requisicoes) {
            sb.append("Requisição #").append(r.getCodigo()).append(" - ").append(r.getData()).append("\n");
        }
        aux.msg( sb.toString());
    }
}
