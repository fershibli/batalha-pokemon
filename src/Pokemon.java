
public class Pokemon {
	String nome;
	int hptotal, hp,atk,spatk, def,spdef, level, expatual=0,expprox=0,exptotal=0;
	String evonome;
	int evohp, evoatk, evodef, evospatk, evospdef, evolvl=101;
	boolean selvagem=true;
		
	Pokemon(String palavra,int vida,int ataque,int defesa,int spataque, int spdefesa, int velocidade, int nivel){
		this.nome=palavra;
		this.hptotal=vida;
		this.atk=ataque;
		this.def=defesa;
		this.spatk=spataque;
		this.spdef=spdefesa;
		this.level=nivel;
		for (int relembrar=1; relembrar<this.level; relembrar+=1){
			this.exptotal+=(int)((Math.sqrt(relembrar)*(relembrar/2))+((this.atk+this.def+this.spatk+this.spdef+this.hp)/50));
			this.hptotal+=(int)(1+(relembrar/20)+Math.sin(relembrar+3)+Math.cos(relembrar+3));
			this.atk+=(int)(2+Math.sin(relembrar));
			this.def+=(int)(2+Math.cos(relembrar));
			this.spatk+=(int)(2+Math.sin(relembrar+4));
			this.spdef+=(int)(2+Math.cos(relembrar+4));
		}
		this.expprox=(int)((Math.sqrt(this.level)*(this.level/2))+((this.atk+this.def+this.spatk+this.spdef+this.hp)/50));
		this.hp=this.hptotal;
		
	}
	
	void atrelar(DataBasePokemon pkmn, int nivel){
		evonome=pkmn.nome;
		evohp=pkmn.hptotal;
		evoatk=pkmn.atk;
		evodef=pkmn.def;
		evospatk=pkmn.spatk;
		evospdef=pkmn.spdef;
		evolvl=nivel;
	}
	
	void mostrar(){
		System.out.println(nome+" Nível: "+level);	
		System.out.println("Vida: "+hp);
		System.out.println("Ataque: "+atk);
		System.out.println("Defesa: "+def);
		System.out.println("Pontos de experiência: "+exptotal);
		System.out.println("Próximo nível: "+(expprox-expatual));
	}
	
	void levelup(Pokemon pkmn){
		if (pkmn.hp<=0){
			System.out.println(nome+" derrotou "+pkmn.nome+"!");
			System.out.println(nome+" ganhou "+(int)((pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk+pkmn.spdef+pkmn.spatk)/50)+pkmn.level)/3)+" pontos de experiência!");
			expatual+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk+pkmn.spdef+pkmn.spatk)/50)+pkmn.level)/3;
			exptotal+=(int)(pkmn.expprox+((pkmn.hp+pkmn.def+pkmn.atk+pkmn.spdef+pkmn.spatk)/50)+pkmn.level)/3;
			while (expatual>expprox && level<100){
				expatual=expatual-expprox;
				System.out.println(nome+" subiu para o nível "+(level+1)+"!");
				level+=1;
				expprox=(int)((Math.sqrt(level)*(level/2))+((atk+def+spatk+spdef+hp)/50));
				hptotal+=(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3));
				atk+=(int)(2+Math.sin(level));
				def+=(int)(2+Math.cos(level));
				spatk+=(int)(2+Math.sin(level+4));
				spdef+=(int)(2+Math.cos(level+4));
				System.out.println("Vida + "+(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3))+" = "+hptotal);
				System.out.println("Ataque + "+(int)(2+Math.sin(level))+" = "+atk);
				System.out.println("Defesa + "+(int)(2+Math.cos(level))+" = "+def);
				System.out.println("SP Ataque + "+(int)(2+Math.sin(level+4))+" = "+atk);
				System.out.println("SP Defesa + "+(int)(2+Math.cos(level+4))+" = "+def);
				if (evolvl<=level){
					nome=evonome;
					hptotal=evohp;
					atk=evoatk;
					def=evodef;
					spatk=evospatk;
					spdef=evospdef;
					for (int relembrar=1; relembrar<level; relembrar+=1){
						this.hptotal+=(int)(1+(relembrar/20)+Math.sin(relembrar+3)+Math.cos(relembrar+3));
						this.atk+=(int)(2+Math.sin(relembrar));
						this.def+=(int)(2+Math.cos(relembrar));
						this.spatk+=(int)(2+Math.sin(relembrar+4));
						this.spdef+=(int)(2+Math.cos(relembrar+4));
					}
				}
			}
		}
	}
	
	void atacar1(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if ((atk-pkmn.def)>0){
					System.out.println(nome+" atacou "+pkmn.nome+" causando "+(atk-pkmn.def)+" de dano!");
					pkmn.hp-=(atk-pkmn.def);
					levelup(pkmn);
				} else{
					System.out.println(nome+" atacou "+pkmn.nome+" causando 1 de dano!");
					pkmn.hp-=1;
					levelup(pkmn);
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
		
	
	}
	
	void atacar2(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if ((spatk-pkmn.spdef)>0){
					System.out.println(nome+" atacou "+pkmn.nome+" causando "+(spatk-pkmn.spdef)+" de dano!");
					pkmn.hp-=(spatk-pkmn.spdef);
					levelup(pkmn);
				} else{
					System.out.println(nome+" atacou "+pkmn.nome+" causando 1 de dano!");
					pkmn.hp-=1;
					levelup(pkmn);
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
		
	
	}
	

	void atacar3(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if ((spatk+atk-pkmn.spdef-pkmn.def)>0){
					System.out.println(nome+" atacou "+pkmn.nome+" causando "+(spatk+atk-pkmn.spdef-pkmn.def)+" de dano!");
					pkmn.hp-=(spatk+atk-pkmn.spdef-pkmn.def);
					levelup(pkmn);
				} else{
					System.out.println(nome+" atacou "+pkmn.nome+" causando 1 de dano!");
					pkmn.hp-=1;
					levelup(pkmn);
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
		
	
	}
}
