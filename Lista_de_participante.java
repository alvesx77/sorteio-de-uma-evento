package projeto_com_lista_encadeada;

import java.util.Scanner;

public class Lista_de_participante{
	public static Scanner leitor=new Scanner(System.in);
	No_de_participante lista=null;
	int num=1;
	public void add_part(String nome,String email) {
		No_de_participante novo=new No_de_participante();
		novo.nome=nome;
		novo.email=email;
		novo.num_d_part=num;
		novo.prox=null;
		if(lista==null) {
			lista=novo;
		}
		else {
			No_de_participante aux=lista;
			while(aux.prox!=null) {
				aux=aux.prox;
			}
			aux.prox=novo;
		}
		num++;
	}
	
	public void add_prese(int tabela[][],Lista_de_atv l){
		No_de_participante aux1=lista;
		int li=0,c;
		while(aux1!=null) {
			c=0;
			No_de_atv aux=l.lista_de_atv;
			while(aux!=null) {
				System.out.print(aux1.nome+" participou da atividade "+ aux.nome+": ");
				tabela[li][c]=leitor.nextInt();
				aux=aux.prox;
				c++;
			}
			aux1=aux1.prox;
			li++;
		}
	}
	public void verificar_presensa(Lista_de_atv lista_de_a,int tabela [][]) {
		int linha=0;
		No_de_participante aux_p=lista;
		while(aux_p!=null) {
			int coluna=0,cont=0;
			float media=0;
			No_de_atv aux_a=lista_de_a.lista_de_atv;
			while(aux_a!=null) {
				if(tabela[linha][coluna]==1) {
					cont++;
				}
				aux_a=aux_a.prox;
				coluna++;
			}
			media=((cont*100)/lista_de_a.tam);
			aux_p.media_de_prese=media;
			aux_p=aux_p.prox;
			linha++;
			
		}
	}
	public void mostrar() {
		No_de_participante aux=lista;
		while(aux!=null) {
			System.out.print(aux.nome+aux.media_de_prese);
			aux=aux.prox;
		}
	}
}
