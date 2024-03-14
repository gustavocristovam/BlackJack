public class Pessoa extends Players {
    private int saldo = 100;

    public int getSaldo() {
        return this.saldo;
    }

    public void removeSaldo(int saldo) {
        this.saldo -= saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo += saldo;
    }
}
