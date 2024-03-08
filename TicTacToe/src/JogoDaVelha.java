import java.util.Scanner;

public class JogoDaVelha {
    private JogoDaVelha_Mapa jogoMapa;
    private JogoDaVelha_PC jogoPC;
    private JogoDaVelha_Jogador jogoJogador;

    public JogoDaVelha(JogoDaVelha_Mapa jogoMapa, JogoDaVelha_PC jogoPC, JogoDaVelha_Jogador jogoJogador) {
        this.jogoMapa = jogoMapa;
        this.jogoPC = jogoPC;
        this.jogoJogador = jogoJogador;
    }

    private void jogar(Scanner teclado) {
        String jogarNovamente;

        do {
            jogoMapa.limpaMapa();
            jogoMapa.desenha(0);
            int quemComeca = jogoMapa.sortear(0, 1);
            int numerosDeJogadas = 0;
            boolean jogoContinua = true;
            boolean jogadorGanhou = false;
            while (jogoContinua) {
                if (quemComeca == 0) {
                    jogadorGanhou = jogoJogador.joga(teclado);
                } else {
                    jogadorGanhou = jogoPC.joga();
                }
                numerosDeJogadas++;
                jogoMapa.desenha(numerosDeJogadas);

                if (jogadorGanhou || numerosDeJogadas == 9) {
                    jogoContinua = false;
                } else {
                    quemComeca = 1 - quemComeca;
                }
            }
            if (numerosDeJogadas == 9 && !jogadorGanhou) {
                jogoMapa.desenha(numerosDeJogadas);
                System.out.println("... EMPATOU!");
            }
            System.out.println("\n________________________");
            System.out.println("Deseja jogar novamente (s/n)?");
            jogarNovamente = teclado.next();
        } while (jogarNovamente.equalsIgnoreCase("s"));
        teclado.close();
        System.out.println("--- FIM ---");
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
        JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
        JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
        JogoDaVelha jogo = new JogoDaVelha(jogoMapa, jogoPC, jogoJogador);

        jogo.jogar(teclado);

    }
}