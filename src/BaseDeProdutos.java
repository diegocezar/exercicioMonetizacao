
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseDeProdutos {

    public List<Produto> produtos;

    public BaseDeProdutos() {
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto(int codigo) {
        for (Produto produto: produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public int getQuantidade(int codigo) {
        return Collections.frequency(produtos, getProduto(codigo));
    }

    public boolean addProduto(Produto produto) {
        return produtos.add(produto);
    }

    public boolean remove(Produto produto) {
        return produtos.remove(produto);
    }


}
