
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseDeCompras {

//    Relatórios de vendas: produtos vendidos, compras feitas pelo cliente, clientes que mais
//    compram, clientes que mais realizam operações de monetização, etc.

    private List<Compra> compras;

    public BaseDeCompras() {
        compras = new ArrayList<>();
    }

    public boolean add(Compra compra) {
        return compras.add(compra);
    }

    public List<Compra> comprasPorCliente(Cliente cliente) {
        List<Compra> comprasCliente = new ArrayList<>();
        for (Compra compra: compras) {
            if (compra.getCliente().equals(cliente)) {
                comprasCliente.add(compra);
            }
        }
        return comprasCliente;
    }

    public int getComprasSize() {
        return compras.size();
    }

    public List<Produto> todosProdutosVendidos() {
        List<Produto> produtosVendidos = new ArrayList<>();
        for (Compra compra: compras) {
            List<Produto> vendidosCompra = compra.getProdutosVendidos();
            for (Produto produto: vendidosCompra) {
                produtosVendidos.add(produto);
            }

        }
        return produtosVendidos;
    }
        
    	public HashMap<Cliente, Integer> clientesQueMaisCompram() {
    		
    		HashMap<Cliente, Integer> freqClientes = new HashMap();
    		for(Compra compra: compras) {
    			Cliente cliente = compra.getCliente();
    			if(freqClientes.containsKey(cliente)) {
    				Integer frequencia = freqClientes.get(cliente);
    				freqClientes.replace(cliente, frequencia + 1);
    			} else {
    				freqClientes.put(cliente, 1);
    			}	
    		}
    		return freqClientes;
    }

}
