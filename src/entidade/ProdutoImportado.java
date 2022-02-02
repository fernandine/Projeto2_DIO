package entidade;

public class ProdutoImportado extends Produto {

	private Double taxa;

	public ProdutoImportado(String nome, Double preco, Double taxa) {
		super(nome, preco);
		this.taxa = taxa;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double totalPreco() {
		return getPreco() + taxa;
	}
	
	@Override
	public String resultado() {
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", totalPreco())
				+ " (Taxa de alfândega: $ " 
				+ String.format("%.2f", taxa)
				+ ")";
	}
}