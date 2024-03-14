import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jogador jogador = new Jogador();
        Bot bot = new Bot();
        Random gerador = new Random();
        System.out.println("Saldo: " + jogador.getSaldo());
        System.out.println("Pegando cartas...");
        
        jogador.addCarta((gerador.nextInt(10) +1));
        jogador.addCarta((gerador.nextInt(10) +1));
        bot.addCarta((gerador.nextInt(10) +1));
        bot.addCarta((gerador.nextInt(10) +1));

        System.out.println("Suas cartas são: " + jogador.infoCarta(0) + " : " + jogador.infoCarta(1));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Cartas do BOT: " + bot.infoCarta(0) + " : X" );
        do {
            System.out.println("Pegas mais cartas? (true/false)");
            boolean decisao = teclado.nextBoolean();
            if (decisao) {
                jogador.addCarta(gerador.nextInt(10) + 1);
                int numCartas = jogador.qntDeCartas();
                System.out.print("Suas cartas são: ");
                for (int i = 0; i < numCartas; i++) {
                    System.out.print(jogador.infoCarta(i));
                    if (i < numCartas - 1) {
                        System.out.print(" : ");
                    }
                }
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Cartas do BOT: " + bot.infoCarta(0) + " : X" );
                
            } else {
                int numCartas = jogador.qntDeCartas();
                System.out.print("Suas cartas são: ");
                for (int i = 0; i < numCartas; i++) {
                    System.out.print(jogador.infoCarta(i));
                    if (i < numCartas - 1) {
                        System.out.print(" : ");
                    }
                }
                System.out.println();
                while (bot.somaPontos() < 17) {
                    bot.addCarta((gerador.nextInt(10) +1));
                }
                System.out.println("------------------------------------------------------------------------------------");
                int numCartasBot = bot.qntDeCartas();
                System.out.print("Cartas do bot: ");
                for (int i = 0; i < numCartasBot; i++) {
                    System.out.print(bot.infoCarta(i));
                    if (i < numCartasBot - 1) {
                        System.out.print(" : ");
                    }
                }
                System.out.println();
                if (bot.somaPontos() > jogador.somaPontos() && bot.somaPontos() <= 21) {
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("O BOT FOI VENCEDOR!!!!");
                    break;
                } else if (jogador.somaPontos() > bot.somaPontos() && jogador.somaPontos() <= 21) {
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("O JOGADOR FOI VENCEDOR!!!!");
                    break;
                } else {
                    break;
                }
            }
        } while (true);

       

    }
}
