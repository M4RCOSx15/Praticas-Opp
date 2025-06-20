package classes;

import java.util.Scanner;

public class PesquisaBinaria{
    public static void main(String[] args) {
        int arr [] = {1,3,5,7,8,10,15,16};
        Scanner leia = new Scanner(System.in);
        System.out.println("os numeros disponiveis: ");
        for (int i : arr) {
             System.out.print(" ["+i+"] ");
        }
       System.out.println();
        System.out.println("Digite qual número deseja procurar:");
        int num = leia.nextInt();
        System.out.println("O número :"+num+" Está na posição :"+ProcuradorPesquisa.ProcurarNumero(arr,num));
     leia.close();
    }
}