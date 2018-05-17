
import java.time.LocalDateTime;
import java.util.List;

public class Compra {

    private int codigo;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private List<Produto> produtosVendidos;
    private double total;

    public Compra(int codigo, LocalDateTime dataHora, Cliente cliente, List<Produto> produtosVendidos, double total) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.produtosVendidos = produtosVendidos;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public double getTotal() {
        return total;
    }
}
