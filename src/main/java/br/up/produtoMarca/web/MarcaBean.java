package br.up.produtoMarca.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.produtoMarca.entidada.Marca;
import br.up.produtoMarca.servico.ServicoMarca;

@Named
@RequestScoped
public class MarcaBean {

	@EJB
	private ServicoMarca servicoMarca;
	private Marca marca;
	private List<Marca> marcas;

	private MarcaBean() {
		this.marca = new Marca();

	}

	public ServicoMarca getServicoMarca() {
		return servicoMarca;
	}

	public void setServicoMarca(ServicoMarca servicoMarca) {
		this.servicoMarca = servicoMarca;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> listarMarca() {
		return this.servicoMarca.listarMarca();
	}

	public void cadastrarMarcas() {
		try {
			this.servicoMarca.cadastrarMarca(marca);
			JSFUtils.enviarMensagemDeInformacao("Marca Cadastrada com Sucesso");
			this.marca = new Marca();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}

	}

	public void excluirMarca(Marca marca) {
		this.servicoMarca.excluirMarca(marca);
		JSFUtils.enviarMensagemDeAtencao("Marca excluida com Sucesso");
	}

	public List<Marca> getMarcas() {
		if(this.marcas==null) {
			this.marcas = this.servicoMarca.listarMarca();
		}
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

}
