package br.com.lucasladeira.taxaselicanualapi.config;

import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    public Retrofit retrofitBuilder(String path){
        return new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
