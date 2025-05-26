import javax.swing.*;

public class Auxiliares {
    public  String receberTexto(String msg){
        try{
            String texto = JOptionPane.showInputDialog(msg);
            if(texto == null || texto.trim().isEmpty()  ){
                throw new IllegalArgumentException("Insira um texto válido!");
            }
            return texto;
        }catch (Exception e){
            throw new IllegalArgumentException("Erro ao receber o texto: " + e.getMessage());
        }

    }
    public double receberDouble(String msg){
        try{
            double num = Double.parseDouble(receberTexto(msg));
            if(num<0){
                throw new IllegalArgumentException("Insira um valor positivo.");
            }
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Insira um valor válido: " + e.getMessage());
        }
    }
    public int receberInt(String msg){
        try{
            int num = Integer.parseInt(receberTexto(msg));
            if(num<0){
                throw new IllegalArgumentException("Insira um valor positivo.");
            }
            return num;

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Insira um valor válido: " + e.getMessage());
        }
    }

    public void msg(String txt){
        JOptionPane.showMessageDialog(null, txt);
    }


}
