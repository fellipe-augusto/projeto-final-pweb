package br.fatec.ra1721040.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.fatec.ra1721040.dao.ParticipanteDAO;
import br.fatec.ra1721040.dao.ParticipanteDAOHibernate;
import br.fatec.ra1721040.model.Participante;

@ManagedBean(name = "participanteBean")
@RequestScoped

public class ParticipanteBean {

	private List<SelectItem> participanteItem;
	
	private Participante participante = new Participante(); // propriedade do tipo Participante

	private DataModel<Participante> listaParticipantes;

	@SuppressWarnings("unchecked")
	public DataModel<Participante> getListaParticipantes() {
		if (listaParticipantes == null) {
			ParticipanteDAO dao = new ParticipanteDAOHibernate();
			listaParticipantes = new ListDataModel<Participante>(dao.listar());
		}
		return listaParticipantes;
	}

	public void setListaParticipantes(DataModel<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	// porta de entrada do formulário
	// preparar cadastro novo participante
	public String novo() {
		this.participante = new Participante();
		return "publico/participante"; // tenta exibir participante.xhtml
	}

	public String listagem() {
		this.participante = new Participante();
		return "publico/listagem"; // tenta exibir participantealt.xhtml
	}

	public String salvar() {
		// se deu certo
		ParticipanteRN participanteRN = new ParticipanteRN();
		participanteRN.salvar(this.participante);
		return "participantesucesso"; // tenta abrir pagina /public/participantesucesso
									// nao colocou o publico mas
		// o contexto de salvar está em /publico
	}

	public List<SelectItem> getParticipantes() {
		// Cria objeto de modelo Faces
		participanteItem = new ArrayList<SelectItem>();
		// cria objeto DAO
		ParticipanteRN pais = new ParticipanteRN();
		List<Participante> participante2 = pais.listar();
		// Alimenta Modelo
		for (Participante c : participante2) {
			SelectItem selecao = new SelectItem(c.getCodigo(), c.getNome());
			participanteItem.add(selecao);
		}
		return participanteItem;
	}
}
