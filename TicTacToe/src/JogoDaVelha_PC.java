public class JogoDaVelha_PC {
    private JogoDaVelha_Mapa mapa;
    private char letra;

    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
        this.mapa = mapa;
        this.letra = 'O';

    }

    public boolean joga() {
        int linha = mapa.sortear(0, 2);
        int coluna = mapa.sortear(0, 2);

        while (!mapa.jogar(linha, coluna, letra)) {
            linha = mapa.sortear(0, 2);
            coluna = mapa.sortear(0, 2);
        }
        System.out.println("PC[" + linha + "," + coluna + "]");
        if (mapa.ganhou(letra)) {
            System.out.println("... PC GANHOU!");
            return true;
        }
        return false;
    }
}
