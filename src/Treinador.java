
public class Treinador {
	String nome;
	Pokemon p1,p2;
	Treinador (String red, Pokemon pokebola1, Pokemon pokebola2){
		nome=red;
		p1=pokebola1;
		p2=pokebola2;
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
