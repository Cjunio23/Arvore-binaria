package Item;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Item item, pesquisa;
        int num, opcao;
        int max = 1000;
        System.out.println("Ordenado (0)\n" + "Aleatorios (1)");
        opcao = ler.nextInt();


        if (opcao == 0) {
            for (int j = 0; j < 9; j++) {
                ArvoreBinaria arvore = new ArvoreBinaria();
                for (int i = 0; i < max; i++) {
                    num = i;
                    item = new Item(num);
                    arvore.insere(item);
                }
                System.out.printf("Elementos: %d ", max);
                max = max + 1000;
                pesquisa = new Item(10001);
                long tempo = System.nanoTime();
                arvore.pesquisa(pesquisa);
                long tempo2 = System.nanoTime();

                System.out.printf("Comparacoes: %d ", arvore.comparacoes);
                System.out.printf("Tempo: %d\n", (tempo2 - tempo));
                arvore.comparacoes = 0;
            }
        }
        if (opcao == 1) {
            for (int j = 0; j < 9; j++) {
                ArvoreBinaria arvore = new ArvoreBinaria();
                Random gerador = new Random();
                for (int i = 0; i < max; i++) {
                    num = gerador.nextInt();
                    item = new Item(num);
                    arvore.insere(item);
                }
                System.out.printf("Elementos: %d ", max);
                max = max + 1000;
                pesquisa = new Item(10000);
                long tempo = System.nanoTime();
                arvore.pesquisa(pesquisa);
                long tempo2 = System.nanoTime();

                System.out.printf("Comparacoes: %d ", arvore.comparacoes);
                System.out.printf("Tempo: %d\n", (tempo2 - tempo));
                arvore.comparacoes = 0;
            }


        }
    }

}