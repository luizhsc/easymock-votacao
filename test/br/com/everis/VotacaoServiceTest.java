package br.com.everis;

import static org.easymock.EasyMock.expect;

import org.easymock.EasyMockSupport;

import java.util.HashMap;
import java.util.Map;

import br.com.everis.model.OpcaoVotacaoEnum;
import br.com.everis.model.UsuarioModel;
import br.com.everis.repositorio.VotacaoRepository;
import br.com.everis.service.VotacaoService;
import junit.framework.TestCase;

public class VotacaoServiceTest extends TestCase {

	VotacaoService		votacaoService;
	EasyMockSupport		support;
	VotacaoRepository	votacaoRepository;

	public void setUp() throws Exception {

		support = new EasyMockSupport();
		votacaoRepository = support.createNiceMock(VotacaoRepository.class);
		votacaoService = new VotacaoService(votacaoRepository);
	}

	public void tearDown() throws Exception {

		support.verifyAll();
	}

	public void testQuandoVotarDeveIncrementarUmVoto() {

		HashMap<OpcaoVotacaoEnum, Integer> map = new HashMap<OpcaoVotacaoEnum, Integer>();
		Integer votos = 1;

		expect(votacaoRepository.buscar()).andReturn(map).anyTimes();

		support.replayAll();

		votacaoService.votar(new UsuarioModel(1L, "Samir"), OpcaoVotacaoEnum.AZUL);

		Map<OpcaoVotacaoEnum, Integer> variavel = votacaoService.mostrarResultado();

		assertEquals(votos, variavel.get(OpcaoVotacaoEnum.AZUL));
	}
}
