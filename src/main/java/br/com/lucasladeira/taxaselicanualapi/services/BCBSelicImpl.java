package br.com.lucasladeira.taxaselicanualapi.services;

import br.com.lucasladeira.taxaselicanualapi.config.RetrofitConfig;
import br.com.lucasladeira.taxaselicanualapi.entities.response.SelicResponse;
import br.com.lucasladeira.taxaselicanualapi.exceptions.APINotAvaliableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

@Service
public class BCBSelicImpl {

    @Autowired
    private RetrofitConfig retrofitConfig;
    private String baseUrl = "http://api.bcb.gov.br/";
    private Logger logger = LoggerFactory.getLogger(BCBSelicImpl.class);

    public List<SelicResponse> obterTaxaSelicUltimosMeses(Integer ultimosMeses) throws Exception {
        BCBSelic apiService = retrofitConfig
                .retrofitBuilder(baseUrl)
                .create(BCBSelic.class);

        Call<List<SelicResponse>> call = apiService.obterTaxaSelicUltimosMeses(ultimosMeses);

        try {
            logger.info("Chamando API BCB");
            Response<List<SelicResponse>> execute = call.execute();
            return execute.body();
        }catch (Exception ex){
            logger.info("Erro na chamada da API BCB");
            throw new APINotAvaliableException("Erro na chamada da API BCB");
        }
    }

    public List<SelicResponse> obterTaxasSelicTodosAnos() throws Exception {
        BCBSelic apiService = retrofitConfig
                .retrofitBuilder(baseUrl)
                .create(BCBSelic.class);

        Call<List<SelicResponse>> call = apiService.obterTaxasSelicTodosAnos();

        try {
            logger.info("Chamando API BCB");
            Response<List<SelicResponse>> execute = call.execute();
            return execute.body();
        }catch (Exception ex){
            logger.info("Erro na chamada da API BCB");
            throw new APINotAvaliableException("Erro na chamada da API BCB");
        }
    }
}
