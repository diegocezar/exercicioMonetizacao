
import java.time.LocalDateTime;
import java.util.List;

public class Sistema {

    public Sistema(BaseDeProdutos baseDeProdutos, BaseDeClientes baseDeClientes, BaseDeCompras baseDeCompras) {
        this.baseDeProdutos = baseDeProdutos;
        this.baseDeClientes = baseDeClientes;
        this.baseDeCompras = baseDeCompras;
    }

    private BaseDeProdutos baseDeProdutos;
    private BaseDeClientes baseDeClientes;
    private BaseDeCompras baseDeCompras;

    public boolean venda(Cliente cliente) {
        List<Produto> produtos = cliente.getCarrinho().getProdutos();
        double total = 0.0;
        for (Produto prod : produtos) {
            total += prod.getPreco();
        }

        if (cliente.getConta().getSaldo() >= total) {
        	
            cliente.getConta().transferencia(total);
            Compra compra = new Compra (baseDeCompras.getComprasSize() + 1, LocalDateTime.now(), cliente, produtos, total);
            System.out.println("Data e hora da compra efetuada:");
            System.out.println(compra.getDataHora());
            baseDeCompras.add(compra);
            for (Produto prod: produtos) {
                baseDeProdutos.remove(prod);
            }
            cliente.limpaCarrinho();
            return true;
        }

        return false;
    }


}
