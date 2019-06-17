package br.fatec.ra1721040.dao;

import br.fatec.ra1721040.util.HibernateUtil;

public class DAOFactoryEvento {

	
	public static EventoDAO criaEventoDAO() {
		EventoDAOHibernate eventoDAO = new EventoDAOHibernate();
			      eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return eventoDAO;
		}


}
