package projeto_com_lista_encadeada;

import java.util.Random;

public class Lista_de_participante_do_sorteio {
	
	public static Random gerar=new Random();
	
	No_de_participante lista_de_part_s=null;
	
	public void add_parti_s(Lista_de_participante lista_p) {
		No_de_participante aux=lista_p.lista;
		while(aux!=null) {
			if(aux.media_de_prese>=75) {
				No_de_participante novo=new No_de_participante();
				novo.nome=aux.nome;
				novo.email=aux.email;
				novo.num_d_part=aux.num_d_part;
				novo.media_de_prese=aux.media_de_prese;
				novo.prox=null;
				if(lista_de_part_s==null){
					lista_de_part_s=novo;
				}
				else {
					No_de_participante aux_s=lista_de_part_s;
					while(aux_s.prox!=null) {
						aux_s=aux_s.prox;
					}
					aux_s.prox=novo;
				}
			}
			aux=aux.prox;
		}
	}
	
	public int total_de_part() {
		int cont=0;
		No_de_participante aux=lista_de_part_s;
		while(aux!=null) {
			cont++;
			aux=aux.prox;
		}
		return cont;
	}
	
	No_de_participante sort=null;
	
	public boolean verificar_sort(int num_g) {
		int cont=0;
		No_de_participante aux=lista_de_part_s;
		while(cont<num_g) {
			aux=aux.prox;
			cont++;
		}
		No_de_participante aux2=sort;
		while(aux2!=null) {
			if(aux2.nome.equalsIgnoreCase(aux.nome) && aux2.num_d_part==aux.num_d_part){
				return false;
			}
			aux2=aux2.prox;
		}
		return true;
	}
	
	public No_de_participante sorteado(int num_g){
		No_de_participante aux=lista_de_part_s;
		int cont=0;
		while(cont<num_g) {
			aux=aux.prox;
			cont++;
		}
		return aux;
	}
	
	public void sortados() {
		int cont=0;
		int num_g;
		while(cont<3) {
			num_g=gerar.nextInt(0,total_de_part());
			if(verificar_sort(num_g)) {
				No_de_participante novo=new No_de_participante();
				novo.nome=sorteado(num_g).nome;
				novo.email=sorteado(num_g).email;
				novo.num_d_part=sorteado(num_g).num_d_part;
				novo.media_de_prese=sorteado(num_g).media_de_prese;
				novo.prox=null;
				if(sort==null) {
					sort=novo;
				}
				else {
					No_de_participante a=sort;
					while(a.prox!=null) {
						a=a.prox;
					}
					a.prox=novo;
				}
				cont++;
			}
		}
	}
	
	public void mos_sort() {
		No_de_participante aux=sort;
		while(aux!=null) {
			System.out.println(aux.nome);
			aux=aux.prox;
		}
	}
}