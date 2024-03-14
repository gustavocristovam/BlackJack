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

        public int vencerdorPartida(int pessoa, int bot) {
            if (pessoa > 21 && bot > 21) {   // 1 = venceu  0 =  perdeu 2 = empatou 3 = erro
                return 2;
            } else if ((21-pessoa) < (21-bot)) { //Quem é o mais proximo de 21 o que tiver menos pontos vence!
                if(21-pessoa >= 0) { // Conferindo para ver se nao ultrapassou 21. Ex: tire 23 PONTOS. fiquei com -2. então perdi!
                    return 1;
                } else {
                    return 0;
                   
                }
            } else if ((21-bot) < (21-pessoa)) {
                if (21-bot >= 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (pessoa == bot) {
                return 2;
                
            } 
            return 3;
            }
        }
    
    




