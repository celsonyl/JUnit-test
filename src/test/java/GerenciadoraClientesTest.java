import com.celso.domain.Cliente;
import com.celso.domain.GerenciadoraClientes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciadoraClientesTest {
    private GerenciadoraClientes gerenciadoraClientes;

    @Before
    public void setUp() {
        //Montando cenario
        Cliente c1 = new Cliente(1, "Celso", 20, "celso@hotmail.com", 1, true);
        Cliente c2 = new Cliente(2, "Garrafa", 10, "celso@hotmail.com", 1, true);

        List<Cliente> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        gerenciadoraClientes = new GerenciadoraClientes(list);
    }

    @Test
    public void testPesquisaCliente() {
        //=== Executando o metodo
        Cliente cliente = gerenciadoraClientes.pesquisaCliente(1);

        //===== Testando
        assert (cliente.getId() == 1);
        assert (Objects.equals(cliente.getNome(), "Celso"));
    }

    @Test
    public void testRemoveCliente() {
        //=== Executando o metodo
        boolean removeCliente = gerenciadoraClientes.removeCliente(2);

        //===== Testando
        assert (removeCliente);
        assert (gerenciadoraClientes.pesquisaCliente(2) == null);
    }
}
