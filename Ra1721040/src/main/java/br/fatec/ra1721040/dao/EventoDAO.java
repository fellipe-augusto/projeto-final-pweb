package br.fatec.ra1721040.dao;

import java.util.List;

import br.fatec.ra1721040.model.Evento;

public interface EventoDAO {
	
	public void salvar(Evento evento);
	public void atualizar(Evento evento);	
	public void excluir(Evento evento);
	public Evento carregar(Integer codigo);
	public List listar();

}
