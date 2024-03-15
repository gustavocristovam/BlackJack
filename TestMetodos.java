import java.util.ArrayList;
import java.util.Random;
import Baralho.Baralho;
import Baralho.CartasPlayers;
import Players.Bot;
import Players.Pessoa;

public class TestMetodos {

   
    
    public static void main(String[] args) {

        
        Random g = new Random();
        Pessoa jogador = new Pessoa();
        Bot CPU = new Bot();


        Baralho baralho = new Baralho();
     
        CartasPlayers cartas_do_jogador = new CartasPlayers(baralho);
        CartasPlayers cartas_do_CPU = new CartasPlayers(baralho);;

        System.out.println("QTD CARTAS BARALHO: " + baralho.quantidadeDeCartas());
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();

        cartas_do_CPU.addCarta();
        cartas_do_CPU.addCarta();
        cartas_do_CPU.addCarta();
        
        


        System.out.println("CARTAS: JOGADOR " +  cartas_do_jogador.listarCartas());   
        System.out.println("CARTAS: CPU " +  cartas_do_CPU.listarCartas());    
        
        
        
        System.out.println("QTD CARTAS BARALHO: " +  baralho.quantidadeDeCartas());
        System.out.println(":" + baralho.listarBaralho());
       
      //System.out.println("BARALHO POSSUI AS CARTAS: " + baralho_object.listarBaralho() );

      
        

        //SE A TIVER JUNTO DE UM K Q J 10 = BLACK JACK NATURAL
        //SE CONTER UM A e soma dos pontos >21 A vale 1.
            

    }
}
