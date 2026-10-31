
public class DataBasePokemon {
	Pokemon pkmn;
	String nome;
	int hptotal, atk, def, spatk, spdef, agi, evolvl, numeropkmn, evonumero, expbase, expgroup, eventreguehp, eventregueatk, eventreguedef, eventreguespatk, eventreguespdef, eventregueagi;

	DataBasePokemon(String palavra, int numero1, int vida, int ataque, int defesa, int spataque, int spdefesa, int velocidade, int nivel, int numero2, int exp, int grupoexperiente, int evhp, int evatk, int evdef, int evsatk, int evsdef, int evagi, int tipo1, int tipo2){
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
		this.expbase=exp;
		this.expgroup=grupoexperiente;
		this.eventreguehp=evhp;
		this.eventregueatk=evatk;
		this.eventreguedef=evdef;
		this.eventreguespatk=evsatk;
		this.eventreguespdef=evsdef;
		this.eventregueagi=evagi;
		
	}
	// v3 widened this constructor but the table still has the old 10 values
	DataBasePokemon(String palavra, int numero1, int vida, int ataque, int defesa, int spataque, int spdefesa, int velocidade, int nivel, int numero2){
		this(palavra, numero1, vida, ataque, defesa, spataque, spdefesa, velocidade, nivel, numero2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	Pokemon criarpokemon(DataBasePokemon[] catalogo, int lvlinicial){
		pkmn = new Pokemon(nome, hptotal, atk, def, spatk, spdef, agi, lvlinicial, expbase, expgroup, eventreguehp, eventregueatk, eventreguedef, eventreguespatk, eventreguespdef, eventregueagi);
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
		return pkmn;
	}

}
