package dio.springboot;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversorJson {
    @Autowired
    private Gson gson;
    public ViaCepResponse converter(String json){
        ViaCepResponse response = gson.fromJson(json, ViaCepResponse.class);
        return response;
    }
}
//essa classe pega nosso Json e transforma num objeto.
//Transformamos ela em um componente com a anotação, então podemos injetá-lo.
//Desta vez vamos usar a anotação @Bean