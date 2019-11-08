package br.com.everis.service;

import java.util.HashMap;
import java.util.Map;

import br.com.everis.model.OpcaoVotacaoEnum;
import br.com.everis.model.UsuarioModel;
import br.com.everis.repositorio.VotacaoRepository;

public class VotacaoService {

	private VotacaoRepository votacaoRepository;

	public VotacaoService(VotacaoRepository votacaoRepository){

		super();
		this.votacaoRepository = votacaoRepository;
	}

	public void votar(UsuarioModel usuario, OpcaoVotacaoEnum opcao) {

		HashMap<OpcaoVotacaoEnum, Integer> votacao = votacaoRepository.buscar();

		if (votacao.containsKey(opcao)) {
			votacao.put(opcao, votacao.get(opcao) + 1);
		} else {
			votacao.put(opcao, 1);
		}

		votacaoRepository.salvar(votacao);
	}

	public Map<OpcaoVotacaoEnum, Integer> mostrarResultado() {

		HashMap<OpcaoVotacaoEnum, Integer> votacao = votacaoRepository.buscar();
		return votacao;
	}
}
