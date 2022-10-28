package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    private Calculadora calculadora;
    @Autowired
    private ViaCepResponse response;

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("O resultado é: " + calculadora.somar(7,2));
        System.out.println(response);
    }
}
