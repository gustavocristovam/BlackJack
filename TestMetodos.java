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


        System.out.println(cartas_do_jogador.getCarta(1));
        System.out.println(cartas_do_jogador.getValueCarta(cartas_do_jogador.getCarta(1)));
        

    }
}
