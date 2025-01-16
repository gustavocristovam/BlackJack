package Baralho;

import java.util.ArrayList;

public class Deck {

    private ArrayList<String> cartas = new ArrayList<>();
    private Baralho baralho;
    public Deck(Baralho baralho) {
        this.baralho = baralho;
    }
    public void addCarta() {
        int carta = baralho.randomCarta();
        this.cartas.add(baralho.selecionarCarta(carta));
    }

    public String getCarta(int index) {
        return this.cartas.get(index);
    }

    public ArrayList<String> getCartas() {
        return this.cartas;
    }
    public int qntDeCartas() {
        return cartas.size();
    }

    public Boolean conterCarta(String value) {
        return cartas.contains(value);

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

    public void clearCartas() {
        cartas.clear();
    }

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

    public int valorDeck() {
        int soma = 0;
        for (String carta : cartas) {
            if (!carta.equals("A")) {
                soma += getValueCarta(carta);
            } else if (carta.equals("A")) {
                soma += 11;
                if (soma > 21) {
                    soma -= 11;
                    soma += 1;
                }
            }
        }
        return soma;
    }

        //CARTAS: A J K = soma1=30 | soma2= 21
        //CARTAS: A J K 6 = soma1=37 | soma2= 27
        //cartas A A J 9 soma1 = 41 | soma2 = 31 soma3 = 21
            //Se os dois Ases valem 11: 11 + 11 + 10 (J) + 9 = 41 (não pode).
            //Se um Ás = 11 e o outro Ás = 1: 11 + 1 + 10 (J) + 9 = 31 (não pode).
            //Se ambos os Ases valem 1: 1 + 1 + 10 (J) + 9 = 21.
        //cartas A A J soma1 = 21 | soma2 = 12
        //cartas A J soma1 = 21 | soma2 = 11







}
