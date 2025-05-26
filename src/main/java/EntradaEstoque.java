// EntradaEstoque.java
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class EntradaEstoque {
    Auxiliares aux = new Auxiliares();
    public void importarDeArquivo(String caminho, CadastroItem cadastro) {
        try (Scanner scanner = new Scanner(new File(caminho))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    int codigo = Integer.parseInt(partes[0].trim());
                    int quantidade = Integer.parseInt(partes[1].trim());

                    Item item = cadastro.buscarPorCodigo(codigo);
                    if (item != null) {
                        item.adicionarQuantidade(quantidade);
                    }
                }
            }
            aux.msg( "Itens importados com sucesso.");
        } catch (FileNotFoundException e) {
            aux.msg( "Arquivo não encontrado.");
        } catch (Exception e) {
            aux.msg( "Erro ao processar o arquivo.");
        }
    }
}
