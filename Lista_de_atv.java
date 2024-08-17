package projeto_com_lista_encadeada;

public class Lista_de_atv  {
	
	No_de_atv lista_de_atv=null;
	int tam=0;
	
	
	public void add_atv(String nome,int dia) {
		No_de_atv novo=new No_de_atv();
		novo.nome=nome;
		novo.dia=dia;
		novo.prox=null;
		if(lista_de_atv==null) {
			lista_de_atv=novo;
		}
		else {
			No_de_atv aux=lista_de_atv;
			while(aux.prox!=null) {
				aux=aux.prox;
			}
			aux.prox=novo;
		}
		tam++;
	}
	
	public boolean verificar_dia(int dia){
		No_de_atv aux=lista_de_atv;
		while(aux!=null) {
			if(aux.dia==dia) {
				return false;
			}
			aux=aux.prox;
		}
		return true;
	}
	
	public void mostrar() {
		No_de_atv aux=lista_de_atv;
		while(aux!=null) {
			System.out.println(aux.nome);
			aux=aux.prox;
		}
	}
}
