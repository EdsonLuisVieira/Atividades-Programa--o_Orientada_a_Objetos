package logistica;


public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estoque loja =new Estoque();

		Produto p = new Produto (1, "500c", 5.0, "audi");
		loja.addProduto(p);
		Produto u = new Produto (2, "5000c", 5.0, "audi");
		loja.addProduto(u);
		System.out.println(loja.quantidade());
		int x =loja.contPCaros(4.0);
		System.out.println("qntd carros:"+x);
		int y= loja.qtdMarcas("audi");
		System.out.println("qntd marcas:"+y);
		Produto var = loja.pesquisaPid(1);
	//	var.toString();
		System.out.println(loja.pesquisaPid(1).toString());
		System.out.println(loja.pesquisaPid(2).toString());
		loja.removePId(1);
		int z= loja.qtdMarcas("audi");
		System.out.println("qntd marcas:"+z);
		System.out.println(loja.quantidade());
		
	}

}
