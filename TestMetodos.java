import java.util.ArrayList;
import java.util.Random;

public class TestMetodos {
    public static void main(String[] args) {
        
       
        Random g = new Random();
        Pessoa jogador = new Pessoa();
        Bot CPU = new Bot();
        Cartas cartas_do_jogador = new Cartas();
        Cartas  cartas_do_CPU = new Cartas();
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();
        
        


        System.out.println("CARTAS: " + cartas_do_jogador.qntDeCartas());        
        System.out.println(cartas_do_jogador.listarCartas());
        System.out.println(cartas_do_jogador.somaPontos());
      

        if (cartas_do_jogador.conterCarta("A")) {
            System.out.println("TEMMM!!!");
        };
        

        //SE A TIVER JUNTO DE UM K Q J 10 = BLACK JACK NATURAL
        //SE CONTER UM A e soma dos pontos >21 A vale 1.
            

    }
}
