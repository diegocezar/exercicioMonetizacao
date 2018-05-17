
public class Conta {

    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean deposito(double valor) {
        if (valor < 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean transferencia(double valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
