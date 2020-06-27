package br.com.mastertech.nfe.mappers;

import br.com.mastertech.nfe.dtos.NfeSolicitacaoRequest;
import br.com.mastertech.nfe.dtos.NfeEmissaoResponse;
import br.com.mastertech.nfe.dtos.NfeResponse;
import br.com.mastertech.nfe.dtos.NfeStatusResponse;
import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfe.models.Nfe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NfeMapper {

    public NfeEmissao fromNfeEmissaoRequest(NfeSolicitacaoRequest nfeSolicitacaoRequest) {
        NfeEmissao nfeEmissao = new NfeEmissao();

        nfeEmissao.setIdentidade(nfeSolicitacaoRequest.getIdentidade());
        nfeEmissao.setValor(nfeSolicitacaoRequest.getValor());

        return nfeEmissao;
    }

    public NfeStatusResponse fromNfeEmissao(NfeEmissao nfeEmissao) {
        NfeStatusResponse nfeStatusResponse = new NfeStatusResponse();
        nfeStatusResponse.setStatus(nfeEmissao.getStatus());
        return nfeStatusResponse;
    }

    public List<NfeEmissaoResponse> fromNfeEmissaoList(List<NfeEmissao> nfeEmissaoList) {
        return nfeEmissaoList
                .stream()
                .map(emissao -> toNfeEmissaoResponse(emissao))
                .collect(Collectors.toList());
    }

    private NfeEmissaoResponse toNfeEmissaoResponse(NfeEmissao nfeEmissao) {
        NfeEmissaoResponse nfeEmissaoResponse = new NfeEmissaoResponse();
        NfeResponse nfeResponse = toNfeResponse(nfeEmissao.getNfe());

        nfeEmissaoResponse.setIdentidade(nfeEmissao.getIdentidade());
        nfeEmissaoResponse.setNfe(nfeResponse);
        nfeEmissaoResponse.setStatus(nfeEmissao.getStatus());
        nfeEmissaoResponse.setValor(nfeEmissao.getValor());
        return nfeEmissaoResponse;
    }

    private NfeResponse toNfeResponse(Nfe nfe) {
        if (nfe == null) {
            return null;
        }

        NfeResponse nfeResponse = new NfeResponse();
        nfeResponse.setValorInicial(nfe.getValorInicial());
        nfeResponse.setValorIRRF(nfe.getValorIRRF());
        nfeResponse.setValorCSLL(nfe.getValorCSLL());
        nfeResponse.setValorCofins(nfe.getValorCofins());
        nfeResponse.setValorFinal(nfe.getValorFinal());
        return nfeResponse;
    }
}
