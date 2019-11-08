package br.com.everis;

import br.com.everis.model.OpcaoVotacaoEnum;
import br.com.everis.model.UsuarioModel;
import br.com.everis.repositorio.VotacaoRepository;
import br.com.everis.service.VotacaoService;

public class Aplicacao {

	public static void main(String[] args) {

		VotacaoService votacaoService = new VotacaoService(new VotacaoRepository());
		
		votacaoService.votar(new UsuarioModel(1L, "Samir"), OpcaoVotacaoEnum.AZUL);
		votacaoService.votar(new UsuarioModel(1L, "Teló"), OpcaoVotacaoEnum.VERDE);
		votacaoService.votar(new UsuarioModel(1L, "Marquim Infra"), OpcaoVotacaoEnum.ROSA);
		votacaoService.votar(new UsuarioModel(1L, "Pedrim"), OpcaoVotacaoEnum.ROSA);

		votacaoService.mostrarResultado();
	}

}
