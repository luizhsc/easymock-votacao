package br.com.everis.repositorio;

import java.util.HashMap;

import br.com.everis.model.OpcaoVotacaoEnum;

public class VotacaoRepository {

	public HashMap<OpcaoVotacaoEnum, Integer> votos = new HashMap<OpcaoVotacaoEnum, Integer>();

	public void salvar(HashMap<OpcaoVotacaoEnum, Integer> votos) {

		this.votos = votos;
	}

	public HashMap<OpcaoVotacaoEnum, Integer> buscar() {

		return votos;
	}
}
