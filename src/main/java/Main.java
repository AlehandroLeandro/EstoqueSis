// Principal.java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CadastroItem cadastro = new CadastroItem();
        EntradaEstoque entradaEstoque = new EntradaEstoque();
        Requisicao requisicao = new Requisicao();
        Auxiliares aux = new Auxiliares();

        while (true) {
            String[] opcoes = {
                    "1. Cadastrar novo item",
                    "2. Listar itens",
                    "3. Requisitar item",
                    "4. Remover item da requisição",
                    "5. Ver requisição atual",
                    "6. Entrada de estoque via arquivo",
                    "0. Sair"
            };

            String escolha = (String) JOptionPane.showInputDialog(
                    null, "Escolha uma opção:", "Menu",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == null || escolha.startsWith("0")) break;

            switch (escolha.charAt(0)) {
                case '1' -> cadastro.cadastrarNovoItem();
                case '2' -> cadastro.listarItens();
                case '3' -> {
                    String codStr = aux.receberTexto("Código do item:");
                    String qtdStr = aux.receberTexto("Quantidade:");

                    if (codStr != null && qtdStr != null) {
                        try {
                            int codigo = Integer.parseInt(codStr);
                            int quantidade = Integer.parseInt(qtdStr);
                            Item item = cadastro.buscarPorCodigo(codigo);
                            if (item != null) {
                                requisicao.adicionarItem(item, quantidade);
                            } else {
                                aux.msg( "Item não encontrado.");
                            }
                        } catch (NumberFormatException e) {
                            aux.msg( "Entrada inválida.");
                        }
                    }
                }
                case '4' -> {
                    String codStr = aux.receberTexto("Código do item para remover da requisição:");
                    if (codStr != null) {
                        try {
                            int codigo = Integer.parseInt(codStr);
                            requisicao.removerItem(codigo);
                        } catch (NumberFormatException e) {
                            aux.msg( "Código inválido.");
                        }
                    }
                }
                case '5' -> requisicao.mostrarResumo();
                case '6' -> {
                    String caminho = aux.receberTexto("Digite o caminho do arquivo:");
                    if (caminho != null) {
                        entradaEstoque.importarDeArquivo(caminho, cadastro);
                    }
                }
            }
        }

        aux.msg( "Sistema encerrado.");
    }
}
