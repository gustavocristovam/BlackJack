import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        Bot bot = new Bot();

        Cartas pessoaDeck = new Cartas();
        Cartas botDeck = new Cartas();

        pessoaDeck.setJogador(pessoa);
        botDeck.setJogador(bot);
    do {
        pessoaDeck.clearCartas();
        botDeck.clearCartas();
        clearConsole();
        System.out.println("Saldo: " + pessoa.getSaldo());
       
       
        pessoaDeck.addCarta();
        pessoaDeck.addCarta();
        botDeck.addCarta();
        botDeck.addCarta();
    
        
        System.out.println("Suas cartas são: " + pessoaDeck.getCarta(0) + " : " + pessoaDeck.getCarta(1)  + "        = " + pessoaDeck.somaPontos());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Cartas do BOT: " + botDeck.getCarta(0) + " : X" );
        do {
            System.out.println("Pegas mais cartas? (true/false)");
            boolean decisao = teclado.nextBoolean();
            if (decisao) {
                clearConsole();
                pessoaDeck.addCarta();
                System.out.println("Saldo: " + pessoa.getSaldo());
                System.out.println("Suas " + pessoaDeck.listarCartas() + "        = " + pessoaDeck.somaPontos());
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Cartas do BOT: " + botDeck.getCarta(0) + " : X" );
                
            } else {
                clearConsole();
                System.out.println("Saldo: " + pessoa.getSaldo());
                System.out.println("Suas " + pessoaDeck.listarCartas()  + "        = " + pessoaDeck.somaPontos());
                
                while (botDeck.somaPontos() < 17) {
                    botDeck.addCarta();
            }
            System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Bot " + botDeck.listarCartas()  + "        = " + botDeck.somaPontos());
                System.out.println();
                switch (pessoaDeck.vencerdorPartida(pessoaDeck.somaPontos(), botDeck.somaPontos())) {
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
                decisao = teclado.nextBoolean();
                break;
                
            }
        } while (true);
    } while (true);
        
        

       

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