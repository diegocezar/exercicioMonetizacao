
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto getProduto(BaseDeProdutos base, int codigo) {
        for (Produto produto: base.getProdutos()) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
            "produtos=" + produtos +
            '}';
    }
}
