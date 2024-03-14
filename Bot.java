import java.util.ArrayList;

public class Bot {

    private ArrayList<Integer> cartas = new ArrayList<>();;
     



public int qntDeCartas() {
    return cartas.size();
}

    public void addCarta(int carta) {
        this.cartas.add(carta);
    }

    public int infoCarta(int index) {
        
        return this.cartas.get(index);
    }

    public int somaPontos() {
        int soma = 0;
        for( int i = 0; i < cartas.size(); i++) {
               soma += cartas.get(i);

    } return soma;
    }
    
   

}