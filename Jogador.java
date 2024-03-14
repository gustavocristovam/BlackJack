import java.util.ArrayList;

public class Jogador {
    private int saldo = 100;
    
     

    public int getSaldo() {
        return this.saldo;
    }

    public void lostSaldo(int saldo) {
        this.saldo -= saldo;
    }

    public void gainSaldo(int saldo) {
        this.saldo += saldo;
        
    }


    

}