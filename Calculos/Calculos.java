package Calculos;

import Baralho.Deck;

import java.util.ArrayList;

public class Calculos {

    public boolean check21(Deck deckBot, Deck deckPessoa) {
        int pontosAproximadosJogador = 21- deckPessoa.valorDeck() ;
        int pontosAproximadosBot = 21 - deckBot.valorDeck();

        if (pontosAproximadosJogador < 0 && pontosAproximadosBot < 0) {   // 1 = venceu  0 =  perdeu 2 = empatou 3 = erro
            System.out.println("AMBOS ESTOURAM");
            return false;
        } else if (pontosAproximadosJogador < pontosAproximadosBot) { //J = 2  B = 5
            if(pontosAproximadosJogador >= 0) { ///J = 2  B = 5
                ganhou();
               return true;
            } else {   // J = -1 B = 5
                perdeu();
                return false;
            }
        } else if (pontosAproximadosBot < pontosAproximadosJogador) {
            if (pontosAproximadosBot >= 0) {
                perdeu();
                return false;
            } else {
                ganhou();
                return true;
            }
        } else if (pontosAproximadosBot == pontosAproximadosBot) {
            if(blackJackNatural(deckPessoa) && blackJackNatural(deckBot)){
                System.out.println("EMPATEE!");
            } else {
                if(blackJackNatural(deckPessoa)) {
                    ganhou();
                    return true;
                } else if (blackJackNatural(deckBot)) {
                    perdeu();
                    return false;
                }
            }


        }
        return false;
    }

    private boolean blackJackNatural(Deck player) {
        ArrayList<String>  playerCartas = player.getCartas();
        if(player.valorDeck() == 21 && playerCartas.contains("A") &&
                playerCartas.contains("K") ||
                playerCartas.contains("Q") ||
                playerCartas.contains("J") ||
                playerCartas.contains("10")) {
            return true;
        } else {
            return false;
        }
    }



    private void perdeu() {
        System.out.println("VOCÊ PERDEU!");
    }

    private void ganhou() {
        System.out.println("VOCÊ GANHOU!");
    }

}
