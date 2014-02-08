import java.util.Random;

public class Treinador {
	String nome;
	Pokemon p1,p2;
	Pokemon[] p3456= new Pokemon[4];
	Pokemon[] p0 = new Pokemon[300];
	Random aleatorio = new Random();
	Treinador (String red, Pokemon pokebola1, Pokemon pokebola2){
		nome=red;
		p1=pokebola1;
		p1.selvagem=false;
		p2=pokebola2;
		p2.selvagem=false;
	}
	
	void listar(){
		System.out.println("Treinador: "+nome);
		System.out.println("Lista de pokemons");
		if (p1.hp>0){
			p1.mostrar();
		}else{
			System.out.println(p1.nome+" já foi derrotado.");
		}
		if (p2.hp>0){
			p2.mostrar();
		}else{
			System.out.println(p2.nome+" já foi derrotado.");
		}
	}
	
	void pokebolavai(Pokemon pkmn){
		if (pkmn.selvagem==true){
			System.out.println("Você lançou a pokebola!");
			if (((pkmn.hptotal/pkmn.hp)+1)<aleatorio.nextInt(pkmn.hptotal)){
				System.out.println("Conseguiu! Você capturou o "+pkmn.nome+"!");
				for (int numero=0; numero<4; numero+=1){
					if (numero<4){
						if (p3456[numero]==null){
							p3456[numero]=pkmn;
							break;
						}
					} else{
						if (p0[(numero-4)]==null){
							p0[numero-4]=pkmn;
							System.out.println(pkmn.nome+" foi enviado ao Bill's PC na posição "+(numero-3));
							break;
						}
					}
					
				}
				
			} else{
				int frase=aleatorio.nextInt(5);
				if (frase==0 || frase==5){
					System.out.println("O pokemon se libertou da pokebola!");
				}
				if (frase==1){
					System.out.println("Droga! Por tão pouco!");
				}
				if (frase==2){
					System.out.println("A pokebola arrebentou!");
				}
				if (frase==3){
					System.out.println(pkmn.nome+" rebateu a pokebola!");
				}
				if (frase==4){
					System.out.println(pkmn.nome+" desviou da pokebola!");
				}
			}
		} else{
			System.out.println("Você não pode capturar o pokemon de alguém!");
		}
	}

	void escolher(int pkmn1, int pkmn2, Treinador trnr){
		if (pkmn1==1){
			if (pkmn2==1){
				p1.atacar(trnr.p1);
			} else{
				if (pkmn2==2){
					p1.atacar(trnr.p2);
				} else{
					System.out.println("O outro treinador só tem dois pokemons! Escolha 1 ou 2.");
				}
			}
		} else{
			if (pkmn1==2){
				if (pkmn2==1){
					p2.atacar(trnr.p1);
				} else{
					if (pkmn2==2){
						p2.atacar(trnr.p2);
					} else{
						System.out.println("O outro treinador só tem dois pokemons! Escolha 1 ou 2.");
					}
				}
			}else{
				System.out.println("Você só tem dois pokemons! Escolha 1 ou 2.");
			}
		}
		if (p1.hp<=0 && p2.hp<=0){
			System.out.println("Você, "+nome+", foi derrotado.");
		} else{
			if (trnr.p1.hp<=0 && trnr.p2.hp<=0){
				System.out.println(trnr.nome+" foi derrotado.");
			}
		}
	}
}
