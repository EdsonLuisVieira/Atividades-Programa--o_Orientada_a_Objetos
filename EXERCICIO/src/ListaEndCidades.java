import java.util.ArrayList;

public class ListaEndCidades {
	
	ArrayList <Endereco> lista ; 
	
	public ListaEndCidades(){
		lista = new ArrayList <Endereco>();
	}
	
	public void AdicionaEndereco(Endereco e){
		lista.add(e);
	}
	
	public Endereco BuscaEndPGps (String gps) throws Exception {
		for (Endereco end : lista){
			if (end.getGps_localizacao().equals(gps)){
				return end;
			}
		}
		
		throw new Exception ("end nao encontrada c/" +gps) ;
	}

	public void RemoveEndePGps (String gps) throws Exception{
		for (Endereco end : lista){
			if (end.getGps_localizacao().equals(gps)){
				lista.remove(end);
			}
		}
		throw new Exception ("Sem valores com este gps");
	}
	
	public int QtdEndPCep (String cep) {
		int i=0;
		for (Endereco end : lista){
			if (end.getCep().equals(cep)){
				i++;
			}
		}
		return i;
	}
	
	public ArrayList <Endereco> BuscaEndPBairro (String bairro) throws Exception {
		ArrayList <Endereco> listaaux = new ArrayList <Endereco>();
		for (Endereco end : lista){
			if (end.getBairro().equals(bairro)){
				listaaux.add(end);
			}
		}
		if (listaaux.size()!=0){
			return listaaux;
			}
		throw new Exception ("end nao encontrada c/");
	}

	@Override
	public String toString() {
		return "ListaEndCidades [lista=" + lista + "]";
	}
	
	
}
