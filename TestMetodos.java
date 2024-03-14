
public class TestMetodos {
    public static void main(String[] args) {
        Jogador jogador = new Jogador();
        Jogador CPU = new Jogador();
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

    }
}
