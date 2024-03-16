import java.util.Random;
import java.util.Scanner;

import Baralho.Baralho;
import Baralho.CartasPlayers;
import Players.Bot;
import Players.Pessoa;

public class Jogo {
    public static void main(String[] args) {
        boolean jogar_novamente;
        boolean pegar_cartas;
        Scanner teclado = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        Bot bot = new Bot();
        
       
    do {

        if ( pessoa.getSaldo() > 0) {
           
            Baralho baralho = new Baralho();
       
        CartasPlayers pessoaDeck = new CartasPlayers(baralho);
        CartasPlayers botDeck = new CartasPlayers(baralho);

        pessoaDeck.setJogador(pessoa);
        botDeck.setJogador(bot);
        pessoaDeck.clearCartas();
        botDeck.clearCartas();
        clearConsole(); 
       
        System.out.println("Saldo: " + pessoa.getSaldo());
       
       for (int i = 0; i < 2; i++) {
        pessoaDeck.addCarta();
        botDeck.addCarta();
       }
       
      
        


        System.out.println("CARTAS BARALHO:" + baralho.quantidadeDeCartas());
        System.out.println("Suas cartas são: " + pessoaDeck.getCarta(0) + " : " + pessoaDeck.getCarta(1)  + "        = " + pessoaDeck.somaPontos(true) + "/"  + pessoaDeck.somaPontos(false));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Cartas do BOT: " + botDeck.getCarta(0) + " : |X|" );
        do { // DO PARA PEGAR MAIS CARTAS!
            System.out.println("Pegas mais cartas? (true/false)");
            pegar_cartas = teclado.nextBoolean();
            if (pegar_cartas) {
                clearConsole();
                pessoaDeck.addCarta();
                System.out.println("Saldo: " + pessoa.getSaldo());
                System.out.println("Suas " + pessoaDeck.listarCartas() + "        = " + pessoaDeck.somaPontos(true) + "/"  + pessoaDeck.somaPontos(false));
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Cartas do BOT: " + botDeck.getCarta(0) + " : |X|" );
                
            } else {
                clearConsole();
                System.out.println("Saldo: " + pessoa.getSaldo());
                System.out.println("Suas " + pessoaDeck.listarCartas()  + "        = " + pessoaDeck.somaPontos(true) + "/"  + pessoaDeck.somaPontos(false));
                
                while (botDeck.maoForte(botDeck.somaPontos(true), botDeck.somaPontos(false)) < 17) { // 2 DECK COM 2 VALORES PRIMEIRO BUG A SER RESOLVIDO

                    botDeck.addCarta();
           }
            System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Bot " + botDeck.listarCartas()  + "        = " + botDeck.somaPontos(true) + "/"  + botDeck.somaPontos(false));
                System.out.println();
                switch (pessoaDeck.check21(botDeck.maoForte(botDeck.somaPontos(true), botDeck.somaPontos(false)), pessoaDeck.maoForte(pessoaDeck.somaPontos(true), pessoaDeck.somaPontos(false)))) {
                    case 0: 
                    System.out.println("Você perdeu!");
                    pessoa.removeSaldo(25);
                    break;
                    case 1: 
                    System.out.println("Voce ganhou!");  
                    pessoa.setSaldo(25);
                    break;
                    case 2: 
                    System.out.println("Você empatou!");  break;
                    case 3:
                     System.out.println("ERROR!");  break;
                    default:
                     System.out.println("ERROR no Switch!");  break;
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