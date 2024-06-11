package br.com.gilsonvalves.screemach;

import br.com.gilsonvalves.screemach.model.DadosSeries;
import br.com.gilsonvalves.screemach.service.ConverteDados;
import br.com.gilsonvalves.screemach.service.CosumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreemachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var cosumoAPI = new CosumoAPI();
		var json  = cosumoAPI.ObterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		//var	json = cosumoAPI.ObterDados("https://coffee.alexflipnote.dev/random.json");

		ConverteDados conversor = new ConverteDados();
		DadosSeries dados = conversor.obterDados(json,DadosSeries.class);

		System.out.println(dados);
		//System.out.println(json);
	}
}
