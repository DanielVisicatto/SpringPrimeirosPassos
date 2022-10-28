package dio.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeirosPassosSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosSpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception {
		return args ->{
			String json = "{\"cep\": \"01001-000\", \"logradouro\": \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}

}
//Isso está totalmente errado ao trabalhar com SpringBoot:
//Calculadora calculadora = new Calculadora();
//System.out.println("O resultado é: " + calculadora.somar(7,2));
//apesar do código acima rodar, esses objetos não estão disponíveis dentro do contexto SpringBoot
//conforme convenções de insersão de controle e injeção de dependências. Precisamos ter ciência
//que não usaremos =new pois o próprio SpringBoot é quem vai prover isso.
//Uma das maneiras corretas de fazer isso seria através de CLR (comment line Runner), para que
//nossos objetos sejam disponibilizados pelo container.

//Então vamos criar uma classe MyApp que vai ter sua execução semelhante ao
//método main() essa classe vai implementar o CommandLineRunner.
//Por ser uma interface, ela vai pedir para implementar o método run().
//Então para eliminarmos o =new, e usarmos os Beans componentes faremos
//através de uma anotação @Component.
//claro que nossos objetos ainda serão instaciados pela nossa aplicação, mas os componentes
//tem que vir do SpringBoot.

//Fazemos o mesmo com nossa calculadora, dizemos que é um componente.
//Aí sim nossa App vai chamar nosso componente calculadora >> private Calculadora calculadora.

//Eu não posso dar mais instruções após o Spring ser inicializado, mas como componentes ele faz
//essa injeção através da anotação @Autowired
//Nossa aplicação percebe nossa calculadora mas a anotação @Autowired na nossa App que injeta
//ela no nosso projeto.

//Então quando usaremos nossos Beans, ou Componentes?
//O contexto vai nos dizer o que fazer, por exemplo para consumirmos uma API de CEP, vamos à seguinte
//implementação: uma classe para converter o Json ConversorJson.
// Geramos componentes quando vão ser componentes a ser escaneados na nossa aplicação quando eu
//tenho acesso ao código fonte.
//Então o nosso conversor será um componente, por isso tem a anotação.

//Colocamos aqui nossa anotação @Bean no método implementado logo abaixo dos args(fora).