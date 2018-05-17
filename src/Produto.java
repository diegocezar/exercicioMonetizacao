

public class Produto {

    private int codigo;
    private double preco;
    private String nome;

    public Produto(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (codigo != produto.codigo) return false;
        if (Double.compare(produto.preco, preco) != 0) return false;
        return nome != null ? nome.equals(produto.nome) : produto.nome == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = codigo;
        temp = Double.doubleToLongBits(preco);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return 
        		  nome +
            " codigo=" + codigo +
            ", preco=" + preco;
    }
}
