import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroImoveis {

    private List<Imovel> imovelList;

    public CadastroImoveis(List<Imovel> imovelList) {
        this.imovelList = imovelList;
    }

    public void cadastrarNovoImovel(Imovel imovel) {
        imovelList.add(imovel);
    }

    public Imovel buscarImovelPorEndereco(String cidade, String rua, Integer numero) {
        for (Imovel imovel : imovelList) {
            if (imovel.getCidade().equals(cidade) || imovel.getRua().equals(rua) || imovel.getNumero().equals(numero)) {
                return imovel;
            }
        }
        return null;
    }

    public Imovel buscarImovelPorID(Integer id) {
        for (Imovel imovel : imovelList) {
            if (imovel.getId().equals(id)) {
                return imovel;
            }
        }
        return null;
    }

    public boolean removerImovelPeloID(Integer id) {
        Imovel imovel = buscarImovelPorID(id);
        if (imovel != null) {
            return imovelList.remove(imovel);
        }
        return false;
    }

    public void atualizarImovel(Integer id, Imovel novoImovel) {
        Imovel imovel = buscarImovelPorID(id);

        if (imovel != null) {
            imovel.setRua(novoImovel.getRua());
            imovel.setNumero(novoImovel.getNumero());
            imovel.setBairro(novoImovel.getBairro());
            imovel.setCidade(novoImovel.getCidade());
            imovel.setEstado(novoImovel.getEstado());
            imovel.setCep(novoImovel.getCep());
        } else {
            System.out.println("Imóvel não encontrado com o id informado");
        }
    }

}

