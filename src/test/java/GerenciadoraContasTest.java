import com.celso.domain.ContaCorrente;
import com.celso.domain.GerenciadoraContas;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GerenciadoraContasTest {

    @Test
    public void testTransfereValor() {
        //===== Criando cenario
        ContaCorrente c1 = new ContaCorrente(1, 1500.00, true);
        ContaCorrente c2 = new ContaCorrente(2, 500.00, false);

        List<ContaCorrente> contaCorrenteList = new ArrayList<>();
        contaCorrenteList.add(c1);
        contaCorrenteList.add(c2);

        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contaCorrenteList);

        //== Executando o metodo
        gerenciadoraContas.transfereValor(1, 100, 2);
        var conta = gerenciadoraContas.pesquisaConta(1);
        gerenciadoraContas.contaAtiva(2);

        //== Testando
        assert (c2.getSaldo() == 600 && c1.getSaldo() == 1400);
        assert (conta.getId() == 1);
        assert (!c2.isAtiva());
    }

    @Test
    public void testTransfereValorSaldoInsuficiente() {
        //Cenario
        ContaCorrente c1 = new ContaCorrente(1, 100, true);
        ContaCorrente c2 = new ContaCorrente(2, 50, true);

        List<ContaCorrente> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(list);

        //Executa o metodo
        var sucess = gerenciadoraContas.transfereValor(2, 100, 1);

        //Testando
        assert (!sucess);
        assert (c1.getSaldo() == 100);
        assert (c2.getSaldo() == 50);
    }
}
