
public class DataBasePokemon {
	Pokemon pkmn;
	String nome;
	int hptotal, atk, def, evolvl, numeropkmn, evonumero;

	DataBasePokemon(String palavra, int numero1, int vida, int ataque, int defesa, int nivel, int numero2){
		this.nome=palavra;
		this.numeropkmn=numero1;
		this.hptotal=vida;
		this.atk=ataque;
		this.def=defesa;
		this.evolvl=nivel;
		this.evonumero=numero2;
	}
	
	void CriarPokemon(int lvlinicial){
		pkmn = new Pokemon(nome, hptotal, atk, def, lvlinicial);
		boolean evolui = false;
		int proxevo;
		for(int numero=0; numero<150; numero+=1){
			if(fernandospc[numero].numeropkmn==evonumero){
				evolui = true;
				proxevo = numero;
			}
		}
		if (evolui==true){
			pkmn.atrelar(ferandospc[proxevo], evolvl);
		}
	}
	
}
