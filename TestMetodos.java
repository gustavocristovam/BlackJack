import java.util.Random;
import Baralho.Baralho;
import Players.Bot;
import Players.Pessoa;
import Baralho.Deck;
import Calculos.Calculos;


public class TestMetodos {

   
    
    public static void main(String[] args) {

    Pessoa pessoa = new Pessoa();
    Bot bot = new Bot();
    Baralho baralho = new Baralho();
    Calculos calculos = new Calculos();

    Deck deckPessoa = new Deck(baralho);
    Deck deckBot = new Deck(baralho);

    bot.setMao(deckBot);
    pessoa.setMao(deckPessoa);


    bot.getMao().addCarta();
    bot.getMao().addCarta();
    bot.getMao().addCarta();

    pessoa.getMao().addCarta();
    pessoa.getMao().addCarta();


    System.out.println("BOT:" + bot.getMao().listarCartas());
    System.out.println("EU:" + pessoa.getMao().listarCartas());

    calculos.check21(deckBot,deckPessoa);


    }
}
