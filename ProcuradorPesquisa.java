package classes;

public class ProcuradorPesquisa {
    public static  int ProcurarNumero(int array [], int numeroprocurado){
        int baixo = 0;
        int alto = (array.length)-1;
        while(baixo <=alto){
            int meio = (baixo + alto)/2;
            if(numeroprocurado==array[meio]){
                return meio;
            }else if(numeroprocurado >array[ meio]){
                baixo = meio+1;
            }
            else if(numeroprocurado < array[meio]){
                alto = meio-1;
         
            }
        
        }
        return -1;
    }
}
