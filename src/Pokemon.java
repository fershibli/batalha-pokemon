
public class Pokemon {
	String nome;
	int hptotal, hp,atk,def, level, expatual=0,expprox=0,exptotal=0;
		
	Pokemon(String palavra,int vida,int ataque,int defesa, int nivel){
		this.nome=palavra;
		this.hptotal=vida;
		this.atk=ataque;
		this.def=defesa;
		this.level=nivel;
		for (int relembrar=1; relembrar<this.level; relembrar+=1){
			this.exptotal+=(int)((Math.sqrt(relembrar)*(relembrar/2))+((this.atk+this.def+this.hp)/30));
			this.hptotal+=(int)(1+(relembrar/20)+Math.sin(relembrar+3)+Math.cos(relembrar+3));
			this.atk+=(int)(2+Math.sin(relembrar));
			this.def+=(int)(2+Math.cos(relembrar));
		}
		this.expprox=(int)((Math.sqrt(this.level)*(this.level/2))+((this.atk+this.def+this.hp)/30));
		this.hp=this.hptotal;
	}
	void mostrar(){
		System.out.println(nome+" Nível: "+level);	
		System.out.println("Vida: "+hp);
		System.out.println("Ataque: "+atk);
		System.out.println("Defesa: "+def);
		System.out.println("Pontos de experiência: "+exptotal);
		System.out.println("Próximo nível: "+(expprox-expatual));
	}
	
	void atacar(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if ((atk-pkmn.def)>0){
					System.out.println(nome+" atacou "+pkmn.nome+" causando "+(atk-pkmn.def)+" de dano!");
					pkmn.hp-=(atk-pkmn.def);
					if (pkmn.hp<=0){
						System.out.println(nome+" derrotou "+pkmn.nome+"!");
						System.out.println(nome+" ganhou "+(int)((pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3)+" pontos de experiência!");
						expatual+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3;
						exptotal+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3;
						while (expatual>expprox){
							expatual=expatual-expprox;
							System.out.println(nome+" subiu para o nível "+(level+1)+"!");
							level+=1;
							expprox=(int)((Math.sqrt(level)*(level/2))+((atk+def+hp)/30));
							hptotal+=(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3));
							atk+=(int)(2+Math.sin(level));
							def+=(int)(2+Math.cos(level));
							System.out.println("Vida + "+(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3))+" = "+hptotal);
							System.out.println("Ataque + "+(int)(2+Math.sin(level))+" = "+atk);
							System.out.println("Defesa + "+(int)(2+Math.cos(level))+" = "+def);
						}
					}
				} else{
					System.out.println(nome+" atacou "+pkmn.nome+" causando 1 de dano!");
					pkmn.hp-=1;
					if (pkmn.hp<=0){
						System.out.println(nome+" derrotou "+pkmn.nome+"!");
						System.out.println(nome+" ganhou "+(int)((pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3)+" pontos de experiência!");
						expatual+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3;
						exptotal+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk)/30)+pkmn.level)/3;
						while (expatual>expprox){
							expatual=expatual-expprox;
							System.out.println(nome+" subiu para o nível "+(level+1)+"!");
							level+=1;
							expprox=(int)((Math.sqrt(level)*(level/2))+((atk+def+hp)/30));
							hptotal+=(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3));
							atk+=(int)(2+Math.sin(level));
							def+=(int)(2+Math.cos(level));
							System.out.println("Vida + "+(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3))+" = "+hptotal);
							System.out.println("Ataque + "+(int)(2+Math.sin(level))+" = "+atk);
							System.out.println("Defesa + "+(int)(2+Math.cos(level))+" = "+def);
						}
					}
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
	}
	

}
