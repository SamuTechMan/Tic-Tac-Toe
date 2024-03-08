import java.util.Scanner;

public class JogoDaVelha_Jogador {
    private JogoDaVelha_Mapa mapa;
    private char letra;

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
        this.letra = 'X';
    }

    public boolean joga(Scanner teclado) {
        int linha, coluna;
        System.out.println("Jogador ..");
        System.out.print("  linha:\n");
        linha = teclado.nextInt();
        System.out.print("  coluna:\n");
        coluna = teclado.nextInt();

        while (!mapa.jogar(linha, coluna, letra)) {
            System.out.println("Posição ocupada/Inválida. Tente novamente.");
            System.out.println("Jogador ..");
            System.out.print("  linha:\n");
            linha = teclado.nextInt();
            System.out.print("  coluna:\n");
            coluna = teclado.nextInt();
        }
        if (mapa.ganhou(letra)) {
            System.out.println("... Jogador GANHOU!");
            return true;
        }
        return false;
    }
}
