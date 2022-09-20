package br.com.lucasladeira.taxaselicanualapi.services;

import br.com.lucasladeira.taxaselicanualapi.dto.SelicDTO;
import br.com.lucasladeira.taxaselicanualapi.entities.Selic;
import br.com.lucasladeira.taxaselicanualapi.entities.response.SelicResponse;
import br.com.lucasladeira.taxaselicanualapi.exceptions.SelicNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelicServiceImpl implements SelicService{

    @Autowired
    private BCBSelicImpl bcbService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SelicDTO obterTaxaSelicAtual() throws Exception {
        SelicDTO selicDTO = mapper.map(bcbService
                .obterTaxaSelicUltimosMeses(1)
                .get(0), SelicDTO.class);
        if (selicDTO == null){
            throw new SelicNotFoundException("Não foi encontrada a taxa Selic solicitada!");
        }
        return selicDTO;
    }

    @Override
    public List<SelicDTO> obterUltimasTaxasSelic(Integer ultimosMeses) throws Exception {
        List<SelicDTO> selicDTOList = bcbService
                .obterTaxaSelicUltimosMeses(ultimosMeses)
                .stream()
                .map(selicResponse -> mapper.map(selicResponse, SelicDTO.class))
                .collect(Collectors.toList());
        if (selicDTOList.isEmpty()){
            throw new SelicNotFoundException("Não foi encontrada a taxa Selic solicitada!");
        }
        return selicDTOList;
    }

    @Override
    public List<SelicDTO> obterTaxaSelicAno(Integer ano) throws Exception {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        List<SelicResponse> selicResponseList = bcbService.obterTaxasSelicTodosAnos();
        List<Selic> selicList = new ArrayList<>();

        for (SelicResponse selic : selicResponseList){
            selicList.add(new Selic(LocalDate.parse(selic.getData(), parser), selic.getValor()));
        }


        List<SelicDTO> selicDTOFiltered = selicList
                .stream()
                .filter(selic -> selic.getData().getYear() == ano)
                .map(selic -> {
                    SelicDTO selicDTO = mapper.map(selic, SelicDTO.class);
                    selicDTO.setData(formatter.format(selic.getData()));
                    return selicDTO;
                })
                .collect(Collectors.toList());

        if (selicDTOFiltered.isEmpty()){
            throw new SelicNotFoundException("Não foi encontrada a taxa Selic solicitada!");
        }

        return selicDTOFiltered;
    }
}
