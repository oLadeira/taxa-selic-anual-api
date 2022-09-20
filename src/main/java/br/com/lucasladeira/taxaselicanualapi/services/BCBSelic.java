package br.com.lucasladeira.taxaselicanualapi.services;

import br.com.lucasladeira.taxaselicanualapi.entities.response.SelicResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface BCBSelic {

    @GET("dados/serie/bcdata.sgs.1178/dados/ultimos/{ultimosMeses}?formato=json")
    Call<List<SelicResponse>> obterTaxaSelicUltimosMeses(
        @Path("ultimosMeses") Integer ultimosMeses
    );

    @GET("dados/serie/bcdata.sgs.1178/dados?formato=json")
    Call<List<SelicResponse>> obterTaxasSelicTodosAnos();
}
