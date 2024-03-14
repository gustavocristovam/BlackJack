import java.util.ArrayList;

public class Baralho {
    private ArrayList<String> cartas = new ArrayList<>();

    private ArrayList<String> criarBaralho() {
        cartas = new ArrayList<>();
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String valor: valores) {
            for(int i = 0; i < 4; i++)
                cartas.add(valor);
        }
        return cartas;
     }
     public String baralhoSeletor(int n) {
        ArrayList<String> baralho = criarBaralho();
        String carta = "";
        return carta = baralho.get(n);
     }
}
