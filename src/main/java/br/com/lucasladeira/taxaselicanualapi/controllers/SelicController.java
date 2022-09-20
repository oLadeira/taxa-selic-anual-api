package br.com.lucasladeira.taxaselicanualapi.controllers;

import br.com.lucasladeira.taxaselicanualapi.dto.SelicDTO;
import br.com.lucasladeira.taxaselicanualapi.services.SelicServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Digits;
import java.util.List;

@RestController
@RequestMapping("/api/selic")
@Validated
public class SelicController {

    @Autowired
    private SelicServiceImpl selicService;


    @GetMapping("/atual")
    @ApiOperation(value = "Retorna a última taxa Selic informada pelo BCB (atual).",
            response = SelicDTO.class)
    public ResponseEntity<SelicDTO> obterTaxaSelicAtual() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterTaxaSelicAtual());
    }

    @GetMapping("/ultimos/{ultimosMeses}")
    @ApiOperation(value = "Retorna as últimas taxas Selic baseado nos últimos meses informados pelo usuário.")
    public ResponseEntity<List<SelicDTO>> obterUltimasTaxasSelic(
            @ApiParam(value = "Quantidade de meses da consulta.")
            @PathVariable("ultimosMeses") Integer ultimosMeses) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterUltimasTaxasSelic(ultimosMeses));
    }

    @GetMapping("/ano/{ano}")
    @ApiOperation(value = "Retorna a taxa Selic do ano informado pelo usuário.")
    public ResponseEntity<List<SelicDTO>> obterTaxaSelicAno(
            @ApiParam(value = "Ano em que o usuário deseja saber a taxa Selic.")
            @PathVariable("ano") @Digits(integer = 4, fraction = 4, message = "Ano inválido!") Integer ano) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterTaxaSelicAno(ano));
    }
}
