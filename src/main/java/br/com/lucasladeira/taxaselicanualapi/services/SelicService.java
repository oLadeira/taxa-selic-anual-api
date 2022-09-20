package br.com.lucasladeira.taxaselicanualapi.services;

import br.com.lucasladeira.taxaselicanualapi.dto.SelicDTO;
import br.com.lucasladeira.taxaselicanualapi.entities.Selic;
import br.com.lucasladeira.taxaselicanualapi.entities.response.SelicResponse;

import java.util.List;

public interface SelicService {
    SelicDTO obterTaxaSelicAtual() throws Exception;
    List<SelicDTO> obterUltimasTaxasSelic(Integer ultimosMeses) throws Exception;
    List<SelicDTO> obterTaxaSelicAno(Integer ano) throws Exception;
}
