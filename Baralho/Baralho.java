package Baralho;
import java.util.ArrayList;
import java.util.Random;


public class Baralho {
    private ArrayList<String> cartas;

    // Construtor
    public Baralho() {
        cartas = new ArrayList<>();
        criarBaralho();
    }


    // Método privado para criar o baralho global
    // Método privado para criar o baralho global
    private void criarBaralho() {
        String[] valores = {"A", "2", "8", "K"};
        for (String valor : valores) {
            for (int i = 0; i < 2; i++) {
                cartas.add(valor);
            }
        }
    }

    //PEGAR CARTA ALEATORIA DO BARALHO
    public int randomCarta() {
        Random random = new Random();
        int randomizar = random.nextInt(quantidadeDeCartas());
        return randomizar;
    }


    // Método para acessar o baralho global
    public ArrayList<String> getBaralhoGlobal() {
        return cartas;
    }

    // Método para selecionar uma carta do baralho global
    public String selecionarCarta(int index) {
        String carta = cartas.get(index);
        removerCarta(index);
        return carta;
    }

    // Método para remover uma carta do baralho global
    private void removerCarta(int index) {
        cartas.remove(index);
    }

    // Método para verificar se uma carta está no baralho global
    public boolean contemCarta(String carta) {
        return cartas.contains(carta);
    }

    // Método para contar quantas cartas há no baralho global
    public int quantidadeDeCartas() {
        if (cartas.size() == 0) {
            System.out.println("Não existem mais cartas no Baralho. Encerrando jogo...");
            return 0;
        }

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
