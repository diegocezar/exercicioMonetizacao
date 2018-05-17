
import java.util.ArrayList;
import java.util.List;

public class BaseDeClientes {

    public List<Cliente> clientes;

    public BaseDeClientes() {
        clientes = new ArrayList<>();
    }

    public boolean addClientes(Cliente cliente) {
        for (Cliente cadastrado : clientes) {
            if(cadastrado.getCpf().equals(cliente.getCpf())) {
                return false;
            }
        }
        return clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscaClientePorCPF(String cpf) {
        for (Cliente cliente: clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
