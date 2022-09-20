package br.com.lucasladeira.taxaselicanualapi.controllers;

import br.com.lucasladeira.taxaselicanualapi.dto.SelicDTO;
import br.com.lucasladeira.taxaselicanualapi.services.SelicServiceImpl;
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
    public ResponseEntity<SelicDTO> obterTaxaSelicAtual() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterTaxaSelicAtual());
    }

    @GetMapping("/ultimos/{ultimosMeses}")
    public ResponseEntity<List<SelicDTO>> obterUltimasTaxasSelic(@PathVariable("ultimosMeses") Integer ultimosMeses) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterUltimasTaxasSelic(ultimosMeses));
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<SelicDTO>> obterTaxaSelicAno(
            @PathVariable("ano") @Digits(integer = 4, fraction = 4, message = "Ano inválido!") Integer ano) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(selicService.obterTaxaSelicAno(ano));
    }
}
