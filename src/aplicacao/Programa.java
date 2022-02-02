package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidade.ProdutoImportado;
import entidade.Produto;
import entidade.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Entre com a qtde de produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" + i + " data:");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (tipo == 'c') {
				list.add(new Produto(nome, preco));
			}
			else if (tipo == 'u') {
				System.out.print("Data de Fabricação (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome, preco, data));
			}
			else {
				System.out.print("Taxa de alfândega: ");
				double taxa = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxa));
			}
		}

		System.out.println();
		System.out.println("RESUTADO:");
		for (Produto prod : list) {
			System.out.println(prod.resultado());
		}
		
		sc.close();
	}
}