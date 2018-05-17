
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args ){

        System.out.println("---Sistema de Monetização---");
        BaseDeClientes baseDeClientes = inicializaClientes();
        BaseDeProdutos baseDeProdutos = inicializaProdutos();
        BaseDeCompras baseDeCompras = new BaseDeCompras();

        Sistema sistema = new Sistema(baseDeProdutos, baseDeClientes, baseDeCompras);
        Cliente cliente = new Cliente(null, null, null, null);
        Scanner menu = new Scanner(System.in);
        do {
            imprimirMenu();           
            switch (menu.nextLine()) {
                case "1":
                    System.out.println("Para criar um novo Cliente:");
                    System.out.println("Digite um CPF:");
                    String cpf = menu.next();
                    System.out.println("Digite um Nome:");
                    String nome = menu.next();
                    System.out.println("Digite um Email:");
                    String email = menu.next();
                    if(cpf.matches("\\d+") && nome.matches("[a-z]+")) {
                    	  cliente = new Cliente(cpf, nome, email, new Conta(126, 0.0));
                    	 if (baseDeClientes.addClientes(cliente)) {
                        System.out.println("Cliente adicionado com sucesso!");
                        System.out.println(cliente.toString());
                      } 
                   } else {
                       System.out.println("Revise seu cpf ou nome");
                   }                  
                    break;                   
                case "2":
                    System.out.println("Criar novos produtos");
                    System.out.println("Digite a ID do Produto");
                    String id = menu.next();

                    Integer converted = Integer.valueOf(id);

                    System.out.println("Nome do Produto");
                    String nomeProduto = menu.next();

                    System.out.println("Preço do Produto, formato exemplo: 10.40");
                    String precoProdutos = menu.next();

                    Double convertedPrice = Double.parseDouble(precoProdutos);

                    Produto produto = new Produto(converted, convertedPrice, nomeProduto);
                    baseDeProdutos.addProduto(produto);

                    System.out.println("Produto adicionado com sucesso" + produto);
                    break;
                case "3":
                    System.out.println("Listar Pessoas");
                    baseDeClientes.getClientes().forEach(cli -> System.out.println(cli.toString()));
                    break;
                case "4":
                    System.out.println("Listar Produtos");
                    baseDeProdutos.getProdutos().forEach(prod -> System.out.println(prod.toString()));
                    break;
                case "5":
                    System.out.println("Saldo Cliente");
                    System.out.println("Digite o CPF");
                    String cpfCliente = menu.next();
                    double saldo = baseDeClientes.buscaClientePorCPF(cpfCliente).getConta().getSaldo();
                    System.out.println(saldo);
                    break;
                case "6":
                    System.out.println("Deposito Cliente");
                    System.out.println("Digite o CPF");
                    cpf = menu.next();
                    System.out.println("Digite o Valor");
                    String valor = menu.next();
                    boolean deposito = baseDeClientes.buscaClientePorCPF(cpf).getConta().deposito(Double.valueOf(valor));
                    System.out.println("Depositado" + valor + "na conta de " + baseDeClientes.buscaClientePorCPF(cpf));
                    break;
                case "7":
                    System.out.println("Add Items Carrinho");
                    System.out.println("Digite o CPF");
                    cpf = menu.next();
                    System.out.println("Digite o produto");
                    String produtoCarrinho = menu.next();
                    cliente = baseDeClientes.buscaClientePorCPF(cpf);
                    Carrinho carrinho = cliente.getCarrinho();
                    Produto prod = carrinho.getProduto(baseDeProdutos, Integer.valueOf(produtoCarrinho));
                    carrinho.add(prod);
                    System.out.println("O Produto " + prod.toString() + " foi adicionado no carrinho do Cliente " + cliente.getNome());
                    break;
                case "8":
                    System.out.println("Ver Carrinho cliente");
                    System.out.println("Digite o CPF");
                    cpf = menu.next();
                    cliente = baseDeClientes.buscaClientePorCPF(cpf);
                    carrinho = cliente.getCarrinho();
                    carrinho.getProdutos().forEach(System.out::println);

                    break;
                case "9":
                    System.out.println("Comprar");
                    System.out.println("Digite o CPF");
                    cpf = menu.next();
                    boolean venda = sistema.venda(baseDeClientes.buscaClientePorCPF(cpf));
                    if (venda) {
                    		
                        System.out.println("Compra para cliente " + baseDeClientes.buscaClientePorCPF(cpf).getNome() + " Aprovada ");
                    } else {
                        System.out.println("Compra não aprovada");
                    }
                    break;
                case "10":
                    System.out.println("Listar todos produtos comprados");
                    List<Produto> vendidos = baseDeCompras.todosProdutosVendidos();
                    vendidos.forEach(System.out::println);
                    break;
                case "11":
                    System.out.println("Listar todos comprados por cliente");
                    System.out.println("Digite o CPF");
                    cpf = menu.next();
                    Cliente aaa = baseDeClientes.buscaClientePorCPF(cpf);
                    List<Compra> comprasPorCliente = baseDeCompras.comprasPorCliente(aaa);
                    comprasPorCliente.forEach(compra -> System.out.println(compra.getProdutosVendidos()));
                    break;
                case "12":
                    System.out.println("Listar maiores compradores"); 
                    HashMap<Cliente, Integer> clientesQueMaisCompram = baseDeCompras.clientesQueMaisCompram();
                    System.out.println(Arrays.asList(clientesQueMaisCompram));
                    break;    
                case "0":
                    System.out.println("Sair");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!menu.nextLine().equals("0"));
        return;
    }

    private static BaseDeClientes inicializaClientes() {
        BaseDeClientes baseDeClientes = new BaseDeClientes();
        baseDeClientes.addClientes(new Cliente("999", "Dino", "dino@silvasauro.com", new Conta(123, 100.00)));
        baseDeClientes.addClientes(new Cliente("000", "Baby", "baby@silvasauro.com", new Conta(124, 100.00)));
        baseDeClientes.addClientes(new Cliente("111", "Sushi", "sushi@silvasauro.com", new Conta(125, 100.00)));
        baseDeClientes.addClientes(new Cliente("123", "Diego", "diego@email.com", new Conta(126, 0.00)));
        return baseDeClientes;
    }

    private static BaseDeProdutos inicializaProdutos() {
        BaseDeProdutos baseDeProdutos = new BaseDeProdutos();
        baseDeProdutos.addProduto(new Produto(1, 10.0, "Bolo"));
        baseDeProdutos.addProduto(new Produto(2, 5.0, "Chocolate"));
        baseDeProdutos.addProduto(new Produto(3, 15.0, "Pizza"));
        baseDeProdutos.addProduto(new Produto(4, 7.0, "Torrada"));

        
        
        return baseDeProdutos;
    }

    private static void imprimirMenu() {
        System.out.println("1 - Criar novos clientes");
        System.out.println("2 - Criar novos produtos");
        System.out.println("3 - Listar clientes");
        System.out.println("4 - Listar produtos");
        System.out.println("5 - Saldo cliente");
        System.out.println("6 - Deposito cliente");
        System.out.println("7 - Add Items Carrinho");
        System.out.println("8 - Ver Carrinho cliente");
        System.out.println("9 - Comprar");
        System.out.println("10 - Listar produtos comprados");
        System.out.println("11 - Listar produtos comprados por cliente");
        System.out.println("12 - Listar maiores compradores");
        System.out.println("0 - Sair do programa");
    }




}
