import javax.swing.*;

public class Auxiliares {
    public  String receberTexto(String msg){
        try{
            String texto = JOptionPane.showInputDialog(msg);
            if(texto == null || texto.trim().isEmpty()  ){
                msg("Insira um texto válido!");
                return receberTexto(msg);
            }
            return texto;
        }catch (Exception e){
            msg("Algo deu errado, tente novamente!");
            return receberTexto(msg);
        }

    }
    public double receberDouble(String msg){
        try{
            double num = Double.parseDouble(receberTexto(msg));
            if(num<0){
                msg("Insira um valor positivo.");
                return receberDouble(msg);
            }
            return num;
        }catch (NumberFormatException e){
            msg("Valor inválido!");
            return receberDouble(msg);
        }
    }
    public int receberInt(String msg){
        try{
            int num = Integer.parseInt(receberTexto(msg));
            if(num<0){
                msg("Insira um valor positivo.");
                return receberInt(msg);
            }
            return num;

        }catch (NumberFormatException e){
            msg("Valor inválido!");
            return receberInt(msg);
        }
    }

    public void msg(String txt){
        JOptionPane.showMessageDialog(null, txt);
    }


}
