package projeto_com_lista_encadeada;
import java.util.Scanner;
public class Main {
	
	public static Scanner leitor=new Scanner(System.in);
	
	public static void main(String[] args) {
		Lista_de_participante lista=new Lista_de_participante();
		String nome="f";
		String email=" ";
		while(nome.compareTo("fim")!=0) {
			System.out.print("digite seu nome: ");
			nome=leitor.next();
			if(nome.compareTo("fim")!=0) {
				System.out.print("digite seu email: ");
				email=leitor.next();
				lista.add_part(nome,email);
			}
		}
		Lista_de_atv list_atv=new Lista_de_atv();
		String nome_da_atv=" ";
		int dia;
		while(nome_da_atv.compareTo("fim")!=0) {
			System.out.print("digite o nome da atividade: ");
			nome_da_atv=leitor.next().toLowerCase();
			if(nome_da_atv.compareTo("fim")!=0) {
				System.out.print("digite o dia da atividade: ");
				dia=leitor.nextInt();
				if(list_atv.verificar_dia(dia)==true) {
					list_atv.add_atv(nome_da_atv, dia);
				}
				else {
					System.out.println("esse dia ja tem atividade marcada");
				}
			}
		}
		
		int tabela_de_presenca[][]=new int[lista.num][list_atv.tam];
		lista.add_prese(tabela_de_presenca,list_atv);
		lista.verificar_presensa(list_atv, tabela_de_presenca);
		System.out.print("\n");
		Lista_de_participante_do_sorteio lista_de_part_s=new Lista_de_participante_do_sorteio();
		
		lista_de_part_s.add_parti_s(lista);
		if(lista_de_part_s.total_de_part()>=3) {
			lista_de_part_s.sortados();
			lista_de_part_s.mos_sort();
		}
		else {
			System.out.print("numero insuficiente de participantes");
		}
		
	}
}
