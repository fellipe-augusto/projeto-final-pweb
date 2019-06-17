package br.fatec.ra1721040.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeEvento;
	@Temporal(TemporalType.DATE)
	private Date dthrEvento;
	private String localEvento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
	public Date getDthrEvento() {
		return dthrEvento;
	}

	public void setDthrEvento(Date dthrEvento) {
		this.dthrEvento = dthrEvento;
	}
	
	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nomeEvento == null) ? 0 : nomeEvento.hashCode());
		result = prime * result + ((dthrEvento == null) ? 0 : dthrEvento.hashCode());
		result = prime * result + ((localEvento == null) ? 0 : localEvento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		if (nomeEvento == null) {
			if (other.nomeEvento != null)
				return false;
		} else if (!nomeEvento.equals(other.nomeEvento))
			return false;
		if (dthrEvento == null) {
			if (other.dthrEvento != null)
				return false;
		} else if (!dthrEvento.equals(other.dthrEvento))
			return false;
		if (localEvento == null) {
			if (other.localEvento != null)
				return false;
		} else if (!localEvento.equals(other.localEvento))
			return false;
		return true;
		
	}

}
