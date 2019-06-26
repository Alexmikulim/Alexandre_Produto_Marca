package br.up.produtoMarca.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.produtoMarca.entidada.Produto;
import br.up.produtoMarca.servico.ServicoProduto;

@Named
@RequestScoped
public class ProdutoBean {

	@EJB
	private ServicoProduto servicoProduto;
	private Produto produto;

	private ProdutoBean() {
		this.produto = new Produto();
	}

	public ServicoProduto getServicoProduto() {
		return servicoProduto;
	}

	public void setServicoProduto(ServicoProduto servicoProduto) {
		this.servicoProduto = servicoProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> listarProduto() {
		return this.servicoProduto.listarProduto();
	}

	public void cadastrarProduto() {
		try {
			this.servicoProduto.cadastrarProduto(produto);
			JSFUtils.enviarMensagemDeInformacao("Produto Cadastrada com Sucesso");
			this.produto = new Produto();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}

	}

	public void excluirProduto(Produto produto) {
		this.servicoProduto.excluirProduto(produto);
		JSFUtils.enviarMensagemDeAtencao("Marca exluida com susesso");
	}

}
