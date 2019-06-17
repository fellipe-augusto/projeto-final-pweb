package br.fatec.ra1721040.controller;

import java.util.List;

import br.fatec.ra1721040.dao.DAOFactoryEvento;
import br.fatec.ra1721040.dao.EventoDAO;
import br.fatec.ra1721040.model.Evento;

// unica camada que podera ser comunicar com a camada de dados
// entretanto nao existe qqq referencia ao hibernate mostrando o alto 
// nivel de dedesacoplamento entre camada de acesso a dados e regra de negocio
// por enquanto so evento so evento tera  regra de negocio
public class EventoRN {
	// padrão formal criar essa propriedade e a instanciacao usando DAOFactory
	private EventoDAO eventoDAO;

	public EventoRN() {
		this.eventoDAO = DAOFactoryEvento.criaEventoDAO();
	}

	// carrega uma instancia
	public Evento carregar(Integer codigo, String opcao) {
		return this.eventoDAO.carregar(codigo);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(Evento evento) {
		Integer id = evento.getId();
		if (id == null || id == 0) {
			this.eventoDAO.salvar(evento);
		} else {
			this.eventoDAO.atualizar(evento);
		}
	}

	public void excluir(Evento evento) {
		this.eventoDAO.excluir(evento);
	}	

	@SuppressWarnings("unchecked")
	public List<Evento> listar() {
		return this.eventoDAO.listar();
	}
}
