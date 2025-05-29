// Principal.java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CadastroItem cadastro = new CadastroItem();
        EntradaEstoque entradaEstoque = new EntradaEstoque();
        GerenciadorRequisicoes gerenciador = new GerenciadorRequisicoes();
        Auxiliares aux = new Auxiliares();

        int opcao = 0;

        while (opcao!=6) {
            opcao = aux.receberInt("""
                    1 - Cadastrar novo item
                    2 - Listar itens
                    3 - Requisitar item
                    4 - Lista de Requisições
                    5 - Entrada de estoque
                    6 - Sair
                    """);


            switch (opcao) {
                case 1:
                    cadastro.cadastrarNovoItem();
                    break;

                case 2:
                    cadastro.listarItens();
                    break;

                case 3:
                    gerenciador.novaRequisicao(cadastro);
                    break;

                case 4:
                    gerenciador.listarRequisicoes();
                    break;

                case 5:
                    entradaEstoque.entrada(cadastro);
                    break;
                case 6:
                    aux.msg("Encerrando Sistema!");
                    break;
                default:
                    aux.msg( "Opção inválida. Tente novamente.");
            };

        }
    }
}
