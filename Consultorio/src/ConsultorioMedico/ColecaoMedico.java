package ConsultorioMedico;

import java.util.ArrayList;


	public class ColecaoMedico {
	
	ArrayList <Medico> lista_medico ; 
	
	public ColecaoMedico(){
		lista_medico = new ArrayList <Medico>();
	}
	
	public void adicionaMedico(Medico doctor){
		lista_medico.add(doctor);
	}
	
	public String pesquisaPCrm(int crm)throws Exception{
		for (Medico end : lista_medico){
			if (end.getCrm()==crm)
		return end.toString();
	}
	throw new Exception("sem medicos com este CRM");
	}
	
	public void removePeloCRM(int crm)throws Exception{
		for (Medico end : lista_medico){
			if (end.getCrm()==crm)
		        lista_medico.remove(end);
	}
	throw new Exception("sem medicos com este CRM");
	}
	
	public String pesquisaMedicoPParteNome(String nome)throws Exception{
		for (Medico end : lista_medico){
				//StringTokenizer pri_palavra = new StringTokenizer(end.getNome()," ");
				//while(pri_palavra.hasMoreTokens()){
					//if(pri_palavra.nextToken().equals(nome));
			if (end.getNome().contains(nome))			
			    return end.toString();
			}
		
	throw new Exception("sem medicos com este nome");
	}

}
