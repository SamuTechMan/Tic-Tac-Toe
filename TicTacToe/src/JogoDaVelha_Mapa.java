import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha_Mapa {
    private char[][] mapa;

    public char[][] getMapa() {
        return mapa;
    }

    public JogoDaVelha_Mapa() {
        mapa = new char[3][3];
        limpaMapa();
    }

    public int sortear(int inicio, int fim) {
        Random sortearNumero = new Random();
        int sorteio = inicio + sortearNumero.nextInt(fim - inicio + 1);
        return sorteio;
    }

    public void limpaMapa() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                mapa[i][j] = ' ';
            }
        }
    }

    public void desenha(int jogada) {

        System.out.println("------------- .. jogada: " + jogada);
        for (int i = 0; i < mapa.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " | ");
            }
            if (i != 2) {
                System.out.println("\n-------------");
            }
        }
        System.out.println("\n----------------------------");
    }


    public boolean jogar(int l, int c, char jogador) {
        if (l >= 0 && l < mapa.length && c >= 0 && c < mapa[l].length && mapa[l][c] == ' ') {
            mapa[l][c] = jogador;

            if (ganhou(jogador)) {
                return true;
            }

            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (mapa[i][j] == ' ') {
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean ganhou(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
                return true;
            }
            if (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador) {
                return true;
            }
        }
        if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
            return true;
        }
        if (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador) {
            return true;
        }
        return false;
    }
}
