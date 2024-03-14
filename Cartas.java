import java.util.ArrayList;
import java.util.Random;

public class Cartas {
    private ArrayList<Integer> deck = new ArrayList<>();
    private Players player;

   
   
    public Players getJogador() {
        return player;
    }

    public void setJogador(Players player) {
       this.player = player;
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
            StringBuilder listaCartas = new StringBuilder("cartas são: ");

            for (int i = 0; i < qntDeCartas(); i++) {
                listaCartas.append(getCarta(i));
                if (i < qntDeCartas() - 1) {
                    listaCartas.append(" : ");
                }
            }
            return listaCartas.toString();
        }

        public String vencerdorPartida(int pessoa, int bot) {
            if (pessoa > 21 && bot > 21) {
                return "Empatou!";
            } else if ((21-pessoa) < (21-bot)) { //Quem é o mais proximo de 21 o que tiver menos pontos vence!
                if(21-pessoa >= 0) { // Conferindo para ver se nao ultrapassou 21. Ex: tire 23 PONTOS. fiquei com -2. então perdi!
                    return "Você venceu!";
                } else {
                    return "Você perdeu!";
                }
            } else if ((21-bot) < (21-pessoa)) {
                if (21-bot >= 0) {
                    return "Você perdeu!";
                } else {
                    return "Você venceu!";
                }
            } else if (pessoa == bot) {
                return "Empatou!";
                
            } 
            return "Error!";
            }
        }
    
    




