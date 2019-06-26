package br.up.produtoMarca.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.produtoMarca.entidada.Marca;

@Stateless
public class ServicoMarca {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrarMarca(Marca marca) {
		this.em.persist(marca);
	}
	
	
	public List<Marca> listarMarca() {
		Query query = this.em.createQuery("SELECT m FROM Marca m", Marca.class);
		return query.getResultList();
	}

	
	public void excluirMarca(Marca marca) {
		this.em.remove(this.em.merge(marca));
		
	}
	
}
