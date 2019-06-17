package br.fatec.ra1721040.dao;

import br.fatec.ra1721040.util.HibernateUtil;

public class DAOFactory {

	
	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		      participanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return participanteDAO;
	}

}
