import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cartas {
    private ArrayList<String> deck = new ArrayList<>();
    private ArrayList<String> cartas = new ArrayList<>();
    private Players player;


   

     private ArrayList<String> criarBaralho() {
        cartas = new ArrayList<>();
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String valor: valores) {
            for(int i = 0; i < 4; i++)
                cartas.add(valor);
        }
        return cartas;
     }

     private String randomCarta() {
        Random random = new Random();
        int randomizar = random.nextInt(52);
           return baralho(randomizar);
    }
    private String baralho(int n) {
        ArrayList<String> baralho = criarBaralho();
        String carta = "";
        return carta = baralho.get(n);
     }
     
     public int somaPontos() {
        int soma = 0;
       for (String carta : deck) {
                soma += getValueCarta(carta);
       } return soma;
    }
        public void addCarta() {
            Random gerador = new Random();
            this.deck.add(randomCarta());
        }
    
        public String getCarta(int index) {
            return this.deck.get(index);
        }
    
        public int getValueCarta(String index) {
            switch (index) {
                case "A":
                    return 1;
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:
                    return Integer.parseInt(index);
            }
        }
    

    public Players getJogador() {
        return player;
    }

    public void setJogador(Players player) {
       this.player = player;
    }

    public void clearCartas() {
        deck.clear();
    }


    public int qntDeCartas() {
        return deck.size();
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
    
    




