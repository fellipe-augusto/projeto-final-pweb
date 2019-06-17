package br.fatec.ra1721040.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fatec.ra1721040.dao.EventoDAO;
import br.fatec.ra1721040.dao.EventoDAOHibernate;
import br.fatec.ra1721040.model.Evento;

@ManagedBean(name = "eventoBean")
@RequestScoped

public class EventoBean {

	private Evento evento = new Evento(); // propriedade do tipo Evento

	private DataModel<Evento> listaEventos;

	@SuppressWarnings("unchecked")
	public DataModel<Evento> getListaEventos() {
		if (listaEventos == null) {
			EventoDAO dao = new EventoDAOHibernate();
			listaEventos = new ListDataModel<Evento>(dao.listar());
		}
		return listaEventos;
	}

	public void setListaEventos(DataModel<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

		// porta de entrada do formulário
	// preparar cadastro novo evento
	public String novo() {
	this.evento = new Evento();
	/**	this.evento.setInserir(true);
		this.evento.setAlterar(true);
		this.evento.setExcluir(true);
		this.evento.setVisualizar(true);**/
		
		
		return "publico/evento"; // tenta exibir evento.xhtml
	}

	public String listagem() {
		this.evento = new Evento();
		return "publico/listagemp"; // tenta exibir eventoalt.xhtml
	}

	public String salvar() {
		// se deu certo
		EventoRN eventoRN = new EventoRN();
		eventoRN.salvar(this.evento);
		return "eventosucesso"; // tenta abrir pagina /public/eventosucesso
									// nao colocou o publico mas
		// o contexto de salvar está em /publico
	}

	public Evento buscaPorLogin() {
		EventoDAO dao = new EventoDAOHibernate();
		Evento Permi = dao.carregar(evento.getId());
		return  Permi;
	//	return "publico/eventoalt"; // tenta exibir eventoalt.xhtml
	
	}


}
