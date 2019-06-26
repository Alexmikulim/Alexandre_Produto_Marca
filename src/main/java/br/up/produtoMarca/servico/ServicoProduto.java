package br.up.produtoMarca.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.produtoMarca.entidada.Produto;

@Stateless
public class ServicoProduto {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrarProduto(Produto produto) throws Exception {
		if (produtoMesmoNome(produto).isEmpty()) {
			this.em.persist(produto);
		}else {
			throw new Exception("Produto com Esse Nome já Cadastrado");
		}
		
	}
	
	public List<Produto> listarProduto(){
		Query query = this.em.createQuery("SELECT p FROM Produto p", Produto.class );
		return query.getResultList();
	}
	
	public void excluirProduto(Produto produto) {
		this.em.remove(this.em.merge(produto));
	}
	
	public List<Produto> produtoMesmoNome(Produto produto){
		Query query = this.em.createQuery("SELECT p FROM Produto p WHERE p.nome=:p1", Produto.class);
		query.setParameter("p1", produto.getNome());
		return query.getResultList();
	}

}
