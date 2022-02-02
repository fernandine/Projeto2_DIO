package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date fabricacao;

	public ProdutoUsado(String nome, Double preco, Date fabricacao) {
		super(nome, preco);
		this.fabricacao = fabricacao;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	
	@Override
	public String resultado() {
		return getNome() 
				+ " (usado) $ " 
				+ String.format("%.2f", getPreco())
				+ " (Data de Fabricação: "
				+ sdf.format(fabricacao)
				+ ")";
	}
}