package Calculos;

public class Calculos {

    public boolean check21(int pontosBot, int pontosPessoa) {
        int pontosAproximadosJogador = 21- pontosPessoa ;
        int pontosAproximadosBot = 21 - pontosBot;

        if (pontosAproximadosJogador < 0 && pontosAproximadosBot < 0) {   // 1 = venceu  0 =  perdeu 2 = empatou 3 = erro
            System.out.println("AMBOS ESTOURAM");
            return false;
        } else if (pontosAproximadosJogador < pontosAproximadosBot) { //Quem é o mais proximo de 21 o que tiver menos pontos vence!
            if(pontosAproximadosJogador >= 0) { // Conferindo para ver se nao ultrapassou 21. Ex: tire 23 PONTOS. fiquei com -2. então perdi!
                ganhou();
               return true;
            } else {
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

           System.out.println("EMPATEE!");

        }
        return false;
    }



    private void perdeu() {
        System.out.println("VOCÊ PERDEU!");
    }

    private void ganhou() {
        System.out.println("VOCÊ GANHOU!");
    }

}
