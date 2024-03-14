import java.util.ArrayList;
import java.util.Random;

public class Cartas {
    private ArrayList<Integer> deck = new ArrayList<>();
    private Jogador jogador;

   
   
    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }


    public int qntDeCartas() {
        return deck.size();
    }
    
        public void addCarta() {
            Random gerador = new Random();
            this.deck.add( (gerador.nextInt(10) +1));
        }
    
        public int getCarta(int index) {
            
            return this.deck.get(index);
        }
    
        public int somaPontos() {
            int soma = 0;
            for( int i = 0; i < deck.size(); i++) {
                   soma += deck.get(i);
    
        } return soma;
        }

        public String listarCartas() {
            StringBuilder listaCartas = new StringBuilder("Suas cartas são: ");
            for (int i = 0; i < qntDeCartas(); i++) {
                listaCartas.append(getCarta(i));
                if (i < qntDeCartas() - 1) {
                    listaCartas.append(" : ");
                }
            }
            return listaCartas.toString();
        }
    }
    




