package br.fatec.ra1721040.controller;

import java.util.List;

import br.fatec.ra1721040.dao.DAOFactory;
import br.fatec.ra1721040.dao.ParticipanteDAO;
import br.fatec.ra1721040.model.Participante;

// unica camada que podera ser comunicar com a camada de dados
// entretanto nao existe qqq referencia ao hibernate mostrando o alto 
// nivel de dedesacoplamento entre camada de acesso a dados e regra de negocio
// por enquanto so participante so participante tera  regra de negocio
public class ParticipanteRN {
	// padrão formal criar essa propriedade e a instanciacao usando DAOFactory
	private ParticipanteDAO participanteDAO;

	public ParticipanteRN() {
		this.participanteDAO = DAOFactory.criaParticipanteDAO();
	}

	// carrega uma instancia
	public Participante carregar(Integer codigo) {
		return this.participanteDAO.carregar(codigo);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(Participante participante) {
		Integer codigo = participante.getCodigo();
		if (codigo == null || codigo == 0) {
			this.participanteDAO.salvar(participante);
		} else {
			this.participanteDAO.atualizar(participante);
		}
	}

	public void excluir(Participante participante) {
		this.participanteDAO.excluir(participante);
	}	

	@SuppressWarnings("unchecked")
	public List<Participante> listar() {
		return this.participanteDAO.listar();
	}
}
