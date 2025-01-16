import java.util.Scanner;
import Baralho.Baralho;
import Players.Bot;
import Players.Pessoa;
import Baralho.Deck;
import Calculos.Calculos;

public class Jogo {
    public static void main(String[] args) {
        boolean jogar_novamente;
        boolean pegar_cartas;
        Scanner teclado = new Scanner(System.in);
        Calculos calculos = new Calculos();
        Pessoa jogador = new Pessoa();
        Bot bot = new Bot();
        
       
    do {
        if ( jogador.getSaldo() > 0) {

            Baralho baralho = new Baralho();


        Deck deckJogador = new Deck(baralho);
        Deck deckBot = new Deck(baralho);
        jogador.setMao(deckJogador);
        bot.setMao(deckBot);
        jogador.getMao().clearCartas();
        bot.getMao().clearCartas();

        clearConsole();

        System.out.println("Saldo Atual: " + jogador.getSaldo());
        System.out.println("Digite o valor da aposta: ");

        int posta = teclado.nextInt();
        while (true) {
            if(posta <= jogador.getSaldo()) {
                break;
            } else {
                System.out.println("VALOR INVÁLIDO!");
                System.out.println("Saldo Atual: " + jogador.getSaldo());
                System.out.println("Digite o valor da aposta: ");
                posta = teclado.nextInt();
            }
        }

        jogador.setSaldo(-posta);
       for (int i = 0; i < 2; i++) {
        jogador.getMao().addCarta();
        bot.getMao().addCarta();
       }


            clearConsole();

            System.out.println("Saldo Atual: " + jogador.getSaldo());
        System.out.println("CARTAS BARALHO:" + baralho.quantidadeDeCartas());
        System.out.println("Suas cartas são: " + jogador.getMao().getCarta(0) + " : " + jogador.getMao().getCarta(1)  + "        = " + jogador.getMao().valorDeck());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Cartas do BOT: " + bot.getMao().getCarta(0) + " : |X|" );
        do { // DO PARA PEGAR MAIS CARTAS!
            System.out.println("Pegas mais cartas? (true/false)");
            pegar_cartas = teclado.nextBoolean();
            if (pegar_cartas) {
                clearConsole();
                clearConsole();
                jogador.getMao().addCarta();
                System.out.println("Saldo: " + jogador.getSaldo());
                System.out.println("Suas " + jogador.getMao().listarCartas() + "        = " + jogador.getMao().valorDeck());
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Cartas do BOT: " + bot.getMao().getCarta(0) + " : |X|" );
                
            } else {
                clearConsole();
                System.out.println("Saldo: " + jogador.getSaldo());
                System.out.println("Suas " + jogador.getMao().listarCartas()  + "      = " + jogador.getMao().valorDeck());
                
                while (bot.getMao().valorDeck() < 17) { // 2 DECK COM 2 VALORES PRIMEIRO BUG A SER RESOLVIDO

                    bot.getMao().addCarta();
           }
            System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Bot " + bot.getMao().listarCartas()  + "        = " + bot.getMao().valorDeck());
                System.out.println();
                if(calculos.check21(bot.getMao(),jogador.getMao())){
                    jogador.setSaldo(posta*2);
                } else {
                    if(jogador.getMao().valorDeck() == bot.getMao().valorDeck()) {
                        jogador.setSaldo(posta);
                    }
                }
                System.out.println("JOGAR NOVAMENTE? (true/false)");
                jogar_novamente = teclado.nextBoolean();
                break;
            }
        } while (true);
    } else {
        System.out.println("Você nao dinheiro suficiente para jogar!");
        break;
    }
    } while (jogar_novamente);
    }

   // Método para limpar o console
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            // Verifica qual sistema operacional está sendo usado
            if (os.contains("Windows")) {
                // Se for Windows, usa o comando 'cls' para limpar o console
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Se for outro sistema operacional (UNIX/Linux/Mac), usa o comando 'clear'
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            // Se ocorrer uma exceção, imprime-a
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
}