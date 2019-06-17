package br.fatec.ra1721040.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.ra1721040.model.Evento;
import br.fatec.ra1721040.util.HibernateUtil;

public class EventoDAOHibernate implements EventoDAO {

	// obrigatório para classe hibernate
	// por meio da Session as operacoes do Hibernate chegam ao Banco de Dados

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Evento evento) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(evento);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir a evento. Erro: " + e.getMessage());
		}
	}

	public void atualizar(Evento evento) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(evento);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar a evento. Erro: " + e.getMessage());
		}
	}

	public void excluir(Evento evento) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(evento);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir a evento. Erro: " + e.getMessage());
		}
	}

	// como se fosse o select, busca pela chave, se nao existir retorna null
	// se usar load ao inves de get será gerada uma excecao

	public Evento carregar(Integer codigo) {
		    Evento p = new Evento();
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria c = session.createCriteria(Evento.class);
			c.add(Restrictions.eq("id", codigo));
	        p = (Evento)c.uniqueResult();
			return p;
		}

	public List<Evento> listar() {
		// this.session.getSessionFactory().openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Evento";
		@SuppressWarnings("unchecked")
		List<Evento> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("nao passou nada");
			return null;
		}
	}
	
}
