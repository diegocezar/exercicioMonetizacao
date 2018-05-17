
public class Cliente {

    private String cpf;

    public String getNome() {
        return nome;
    }

    private String nome;
    private String email;
    private Conta conta;
    private Carrinho carrinho;

    public Cliente(String cpf, String nome, String email, Conta conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.conta = conta;
        carrinho = new Carrinho();
    }

    public String getCpf() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "cpf='" + cpf + '\'' +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", conta=" + conta +
            '}';
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Carrinho limpaCarrinho() {
        return carrinho = new Carrinho();
    }
}
