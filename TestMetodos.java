
public class TestMetodos {
    public static void main(String[] args) {
        Pessoa jogador = new Pessoa();
        Bot CPU = new Bot();
        Cartas cartas_do_jogador = new Cartas();
        Cartas  cartas_do_CPU = new Cartas();
       

        cartas_do_jogador.setJogador(jogador);
        cartas_do_CPU.setJogador(CPU);
        
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();
        cartas_do_jogador.addCarta();
        

        cartas_do_CPU.addCarta();
      
        System.out.println(cartas_do_jogador.listarCartas());
        System.out.println(cartas_do_jogador.somaPontos());
        System.out.println(cartas_do_CPU.somaPontos());


        cartas_do_jogador.vencerdorPartida(cartas_do_jogador.somaPontos(), cartas_do_CPU.somaPontos());

    }
}
