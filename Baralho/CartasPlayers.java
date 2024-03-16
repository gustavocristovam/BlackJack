package Baralho;

import java.util.ArrayList;
import java.util.Random;

import Players.Players;

public class CartasPlayers{

    private ArrayList<String> deck = new ArrayList<>();
    private Baralho baralho;
    private Players player;
   
    public CartasPlayers(Baralho baralho) {
        this.baralho = baralho;
    }


    //PEGAR CARTA ALEATORIA DO BARALHO
     private int randomCarta() {
        Random random = new Random();
        int randomizar = random.nextInt(baralho.quantidadeDeCartas());
           return randomizar;
    }
   
     //SOMA DE PONTOS E SISTEMA DE A = 1 OU 11
     public int somaPontos(boolean blackjack) {
        int soma = 0;
        //boolean aceUsado = false;
        if (blackjack) {
            for (String carta : deck) {
                if (!carta.equals("A")) {
                    soma += getValueCarta(carta);
                } else if (carta.equals("A")){
                   
                   
                        soma += 11;

                } 
            }
                }else if (!blackjack) {
                    for (String carta : deck) {
                 if (!carta.equals("A")) {
                     soma += getValueCarta(carta);
                    } else if (carta.equals("A")){
                        soma += 1;
                           }
           }
       }
                
        return soma;
    }
    



        //ADICIONAR CARTA AO DECK DO JOGADOR
        public void addCarta() {
            int carta = randomCarta();
            this.deck.add(baralho.selecionarCarta(carta));
           

        }
    
        //VISUALIZAR CARTA NUM CERTO INDEX DO DECK
        public String getCarta(int index) {
            return this.deck.get(index);
        }
    
        //CONFERIR SE A CARTA EXISTE NO DECK
        public Boolean conterCarta(String value) {
            return deck.contains(value);
            
        }

        
//      //DESCOBRIR VALOR ATRIBUIDO A CADA CARTA
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

    //LIMPAR CARTAS
    public void clearCartas() {
        deck.clear();
    }

    // CONFERIR TAMANHO DO BARALHO
    public int qntDeCartas() {
        return deck.size();
    }
    


    
      
        //LISTAR TODAS AS CARTAS DO DECK
        public String listarCartas() {
            StringBuilder listaCartas = new StringBuilder( "("+qntDeCartas()+")" + " cartas são: ");

            for (int i = 0; i < qntDeCartas(); i++) {
                listaCartas.append(getCarta(i));
                if (i < qntDeCartas() - 1) {
                    listaCartas.append(" : ");
                }
            }
            return listaCartas.toString();
        }



        public int maoForte( int blackJack, int NoBlackJack) {
            int pontos;
            if (21-blackJack < 21-NoBlackJack) { // SE A MAO EM QUE O "A" VALE 1, A SOMA DE QUANTIDADE DE PONTOS -21 FOR maior QUE A MAO EM QUE O "A" 11. SETAR MAO EM QUE O "A" VALE 1
                pontos = blackJack;                 //EX: DECK: A9  BLACKJACK = 20  NOBLACKJACK = 10
           } else if ((21-blackJack > 21-NoBlackJack)) {
               pontos = NoBlackJack;
           } else {
               pontos = blackJack;
           }
           return pontos;
        }




        public int check21(int pessoaBlackJack, int botBlackJack, int pessoaNoBlackJack, int botNoBlackJack ) {
                //maior ponto em relação a 21
            int pontosBot;
            int pontosPessoa;
            if (21-pessoaBlackJack < 21-pessoaNoBlackJack) {
                 pontosPessoa = pessoaBlackJack;
            } else if (21-pessoaBlackJack > 21-pessoaNoBlackJack){
                 pontosPessoa = pessoaNoBlackJack;
            } else {
                pontosPessoa = pessoaBlackJack;
            }

            if (21-botBlackJack < 21-botNoBlackJack) {
                 pontosBot = botBlackJack;
            } else if ((21-botBlackJack > 21-botNoBlackJack)) {
                pontosBot = botNoBlackJack;
            } else {
                pontosBot = botBlackJack;
            }

            if (pontosPessoa > 21 && pontosBot > 21) {   // 1 = venceu  0 =  perdeu 2 = empatou 3 = erro
                return 2;
            } else if ((21-pontosPessoa) < (21-pontosBot)) { //Quem é o mais proximo de 21 o que tiver menos pontos vence!
                if(21-pontosPessoa >= 0) { // Conferindo para ver se nao ultrapassou 21. Ex: tire 23 PONTOS. fiquei com -2. então perdi!
                    return 1;
                } else {
                    return 0;
                   
                }
            } else if ((21-pontosBot) < (21-pontosPessoa)) {
                if (21-pontosBot >= 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (pontosPessoa == pontosBot) {
                return 2;
                
            } 
            return 3;
            }
            
        }
    




