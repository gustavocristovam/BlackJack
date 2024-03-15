package Baralho;
import java.util.ArrayList;

public class Baralho {
    private ArrayList<String> cartas;

    // Construtor
    public Baralho() {
        cartas = new ArrayList<>();
        criarBaralho();
    }

    // Método privado para criar o baralho global
    private void criarBaralho() {
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String valor : valores) {
            for (int i = 0; i < 4; i++) {
                cartas.add(valor);
            }
        }
    }

    // Método para acessar o baralho global
    public ArrayList<String> getBaralhoGlobal() {
        return cartas;
    }

    // Método para selecionar uma carta do baralho global
    public String selecionarCarta(int index) {
        return cartas.get(index);
    }

    // Método para remover uma carta do baralho global
    public void removerCarta(int index) {
        cartas.remove(index);
    }

    // Método para verificar se uma carta está no baralho global
    public boolean contemCarta(String carta) {
        return cartas.contains(carta);
    }

    // Método para contar quantas cartas há no baralho global
    public int quantidadeDeCartas() {
        return cartas.size();
    }

    // Método para listar todas as cartas do baralho global
    public String listarBaralho() {
        StringBuilder listaBaralho = new StringBuilder("Cartas no baralho: ");
        for (String carta : cartas) {
            listaBaralho.append(carta).append(" ");
        }
        return listaBaralho.toString();
    }
}
