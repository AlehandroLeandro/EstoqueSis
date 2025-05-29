import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EntradaEstoque {
    Auxiliares aux = new Auxiliares();
    public void entrada( CadastroItem cadastro) {
        try{
            int codItem = aux.receberInt("Código do Item:");
            double qntItem = aux.receberDouble("Quantidade: ");
            Item item = cadastro.buscarPorCodigo(codItem);
            if(item!=null){
                item.adicionarQuantidade(qntItem);
                aux.msg( "Entrada de itens com sucesso.");
            }

        } catch (NumberFormatException e) {
            aux.msg( "Código ou quantidade inválida");
        }catch (IllegalArgumentException e){
            aux .msg("Item não existe.");
        }
    }
}