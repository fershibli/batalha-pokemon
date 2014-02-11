
public class DataBasePokemon {
	Pokemon pkmn;
	String nome;
	int hptotal, atk, def, spatk, spdef, agi, evolvl, numeropkmn, evonumero;

	DataBasePokemon(String palavra, int numero1, int vida, int ataque, int defesa, int spataque, int spdefesa, int velocidade, int nivel, int numero2){
		this.nome=palavra;
		this.numeropkmn=numero1;
		this.hptotal=vida;
		this.atk=ataque;
		this.def=defesa;
		this.spatk=ataque;
		this.spdef=defesa;
		this.agi=velocidade;
		this.evolvl=nivel;
		this.evonumero=numero2;
	}
	void criarpokemon(DataBasePokemon[] catalogo, int lvlinicial){
		pkmn = new Pokemon(nome, hptotal, atk, def, spatk, spdef, agi, lvlinicial);
		if (evonumero!=numeropkmn){
			int proxevo = 0;
			for(int numero=0; numero<150; numero+=1){
				if(catalogo[numero].numeropkmn==evonumero){
					proxevo = numero;
					break;
				}
			}
			pkmn.atrelar(catalogo[proxevo], evolvl);
		}
	}
}
