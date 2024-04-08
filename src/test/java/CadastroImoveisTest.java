import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CadastroImoveisTest {

    private CadastroImoveis cadastro;
    private List<Imovel> imoveis;

    @BeforeEach
    public void setUp() {
        imoveis = new ArrayList<>();
        cadastro = new CadastroImoveis(imoveis);
    }

    @Test
    public void testCadastrarNovoImovel() {
        Imovel imovel = new Imovel(1, "Rua A", 600, "Bairro A", "Cidade A", "Estado A", "12345-678");
        cadastro.cadastrarNovoImovel(imovel);
        assertEquals(1, imoveis.size()); // Verifica se o tamanho da lista após iteraçao é 1
    }

    @Test
    public void testBuscarImovelPorEndereco() {
        Imovel imovel = new Imovel(1, "Rua A", 600, "Bairro A", "Cidade A", "Estado A", "12345-678");
        cadastro.cadastrarNovoImovel(imovel);
        Imovel encontrado = cadastro.buscarImovelPorEndereco("Cidade A", "Rua A", 600);
        assertEquals(imovel, encontrado); // Verifica se o imovel foi encontrado pelo endereco
    }

    @Test
    public void testBuscarImovelPorID() {
        Imovel imovel = new Imovel(1, "Rua A", 600, "Bairro A", "Cidade A", "Estado A", "12345-678");
        cadastro.cadastrarNovoImovel(imovel);
        Imovel encontrado = cadastro.buscarImovelPorID(1);
        assertEquals(imovel, encontrado); // Verifica se o imovel foi encontrado pelo id
    }

    @Test
    public void testRemoverImovel() {
        Imovel imovel = new Imovel(1, "Rua A", 600, "Bairro A", "Cidade A", "Estado A", "12345-678");
        cadastro.cadastrarNovoImovel(imovel);
        assertTrue(cadastro.removerImovelPeloID(1)); // Verifica se após a remocão do imovel retornará true(1)
    }

    @Test
    public void testAtualizarImovel() {
        Imovel imovel1 = new Imovel(1, "Rua A", 1001, "Bairro A", "Cidade A", "Estado A", "12345-678");
        cadastro.cadastrarNovoImovel(imovel1);
        Imovel imovel2 = new Imovel(2, "Rua B", 1002, "Bairro B", "Cidade B", "Estado B", "12345-678");
        cadastro.atualizarImovel(1, imovel2);

        // Verifica se os atributos do imóvel foram atualizados corretamente
        assertEquals("Rua B", imoveis.get(0).getRua());
        assertEquals(Integer.valueOf(1002), imoveis.get(0).getNumero());
        assertEquals("Bairro B", imoveis.get(0).getBairro());
        assertEquals("Cidade B", imoveis.get(0).getCidade());
        assertEquals("Estado B", imoveis.get(0).getEstado());
        assertEquals("12345-678", imoveis.get(0).getCep());
    }
}