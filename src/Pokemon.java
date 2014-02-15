import java.util.Random;

public class Pokemon {
	String nome;
	int hptotal, hp,atk,spatk, def,spdef, agi, level, expgroup=1, expatual=0,expprox=0,exptotal=0;
	String evonome;
	int evohp, evoatk, evodef, evospatk, evospdef, evolvl=101;
	int iv, eventregue, evmax;
	int	recebidohpev, recebidoatkev, recebidodefev, recebidospatkev, recebidospdefev, recebidoagiev;
	int	entregarhpev, entregaratkev, entregardefev, entregarspatkev, entregarspdefev, entregaragiev;
	int hpbase, atkbase, defbase, spatkbase, spdefbase, agibase;
	int atknat=1, defnat=1, spatknat=1, spdefnat=1,aginat=1;
	double selvagem=1.0;
	Random aleatorio = new Random();
		
	Pokemon(String palavra,int vida,int ataque,int defesa,int spataque, int spdefesa, int velocidade, int nivel, int exp, int grupoexperiente, int evhp, int evatk, int evdef, int evsatk, int evsdef, int evagi){
		this.nome=palavra;
		this.hpbase=vida;
		this.atkbase=ataque;
		this.defbase=defesa;
		this.spatkbase=spataque;
		this.spdefbase=spdefesa;
		this.agibase=velocidade;
		this.level=nivel;
		this.iv=aleatorio.nextInt(31)+1;
		this.atk=((nivel*((ataque*2)+this.iv)/100)+5)*atknat;
		this.def=((nivel*((defesa*2)+this.iv)/100)+5)*defnat;
		this.spatk=((nivel*((spataque*2)+this.iv)/100)+5)*spatknat;
		this.spdef=((nivel*((spdefesa*2)+this.iv)/100)+5)*spdefnat;
		this.agi=((nivel*((velocidade*2)+this.iv)/100)+5)*aginat;
		this.hptotal=((nivel*((vida*2)+this.iv)/100)+10)+nivel;
		this.hp=this.hptotal;
		this.expgroup=grupoexperiente;
		this.totalexp();
		this.proxexp();
		this.entregarhpev=evhp;
		this.entregaratkev=evatk;
		this.entregardefev=evdef;
		this.entregarspatkev=evsatk;
		this.entregarspdefev=evsdef;
		this.entregaragiev=evagi;
		this.eventregue=evhp+evatk+evdef+evsatk+evsdef+evagi;
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
	
	void totalexp(){
		if (expgroup==1){//erratic
			if (level<=50){
				expprox=(int)(((level^3)*(100-level))/50);
			}
			if (level>50 && level<=68){
				expprox=(int)(((level^3)*(150-level))/100);
			}
			if (level>68 && level<=98){
				expprox=(int)(((level^3)*((1911-(10*level))/10))/500);
			}
			if (level>98){
				expprox=(int)(((level^3)*(160-level))/100);
			}
		}
		if (expgroup==2){//fast
			expprox=(int)(4*level/5);
		}
		if (expgroup==3){//mediumfast
			expprox=(int)(level^3);
		}
		if (expgroup==4){//mediumslow
			expprox=(int)((6/5)*(level^3)-(15*(level^2))+(100*level)-140);
		}
		if (expgroup==5){//slow
			expprox=(int)((5*(level^3))/4);
		}
		if (expgroup==6){//fluctuating
			if (level<=15){
				expprox=(int)(level^3)*((((level+1)/3)+24)/50);
			}
			if (level>15 && level<=36){
				expprox=(int)(level^3)*((level+14)/50);
			}
			if (level>36){
				expprox=(int)(level^3)*(((level/2)+32)/50);
			}
		}
	}
	
	void proxexp(){
		if (expgroup==1){//erratic
			if (level<=50){
				expprox=(int)((((level+1)^3)*(100-(level+1)))/50)-(((level^3)*(100-level))/50);
			}
			if (level>50 && level<=68){
				expprox=(int)((((level+1)^3)*(150-(level+1)))/100)-(((level^3)*(150-level))/100);
			}
			if (level>68 && level<=98){
				expprox=(int)((((level+1)^3)*((1911-(10*(level+1)))/10))/500)-(((level^3)*((1911-(10*level))/10))/500);
			}
			if (level>98){
				expprox=(int)((((level+1)^3)*(160-(level+1)))/100)-(((level^3)*(160-level))/100);
			}
		}
		if (expgroup==2){//fast
			expprox=(int)(4*(level+1)/5)-(4*level/5);
		}
		if (expgroup==3){//mediumfast
			expprox=(int)((level+1)^3)-(level^3);
		}
		if (expgroup==4){//mediumslow
			expprox=(int)((6/5)*((level+1)^3)-(15*((level+1)^2))+(100*(level+1))-140)-((6/5)*(level^3)-(15*(level^2))+(100*level)-140);
		}
		if (expgroup==5){//slow
			expprox=(int)((5*((level+1)^3))/4)-((5*(level^3))/4);
		}
		if (expgroup==6){//fluctuating
			if (level<=15){
				expprox=(int)((level+1)^3)*(((((level+1)+1)/3)+24)/50)-(level^3)*((((level+1)/3)+24)/50);
			}
			if (level>15 && level<=36){
				expprox=(int)((level+1)^3)*(((level+1)+14)/50)-(level^3)*((level+14)/50);
			}
			if (level>36){
				expprox=(int)((level+1)^3)*((((level+1)/2)+32)/50)-(level^3)*(((level/2)+32)/50);
			}
		}
	}
	
	void mostrar(){
		System.out.println(nome+" Nível: "+level);	
		System.out.println("Vida: "+hp);
		System.out.println("Ataque: "+atk);
		System.out.println("Defesa: "+def);
		System.out.println("SP Ataque: "+spatk);
		System.out.println("SP Defesa: "+spdef);
		System.out.println("Agilidade: "+agi);
		System.out.println("Exp Total: "+exptotal);
		System.out.println("Próximo nível: "+expatual+" de "+expprox);
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
				agi+=(int)(2+Math.cos(level+2));
				System.out.println("Vida + "+(int)(1+(level/20)+Math.sin(level+3)+Math.cos(level+3))+" = "+hptotal);
				System.out.println("Ataque + "+(int)(2+Math.sin(level))+" = "+atk);
				System.out.println("Defesa + "+(int)(2+Math.cos(level))+" = "+def);
				System.out.println("SP Ataque + "+(int)(2+Math.sin(level+4))+" = "+spatk);
				System.out.println("SP Defesa + "+(int)(2+Math.cos(level+4))+" = "+spdef);
				System.out.println("Agilidade + "+(int)(2+Math.cos(level+2))+" = "+agi);
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
						this.agi+=(int)(2+Math.cos(relembrar+2));
					}
				}
			}
		}
	}
	
	void atacar1(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if (agi+aleatorio.nextInt(agi)>pkmn.agi+aleatorio.nextInt(pkmn.agi)){
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
					System.out.println(pkmn.nome+" desviou do ataque!");
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
				if (agi+aleatorio.nextInt(agi)>pkmn.agi+aleatorio.nextInt(pkmn.agi)){
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
					System.out.println(pkmn.nome+" desviou do ataque!");
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
				if (agi+aleatorio.nextInt(agi)>pkmn.agi+aleatorio.nextInt(pkmn.agi)){
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
					System.out.println(pkmn.nome+" desviou do ataque!");
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
		
	
	}
	
	void atacar4(Pokemon pkmn){
		if (hp>0){
			if (pkmn.hp>0){
				if (agi+aleatorio.nextInt(agi)>pkmn.agi+aleatorio.nextInt(pkmn.agi)){
					if (agi+atk-(pkmn.def*2)>0){
						System.out.println(nome+" atacou "+pkmn.nome+" causando "+(agi+atk-(pkmn.def*2))+" de dano!");
						pkmn.hp-=agi+atk-(pkmn.def*2);
						levelup(pkmn);
					} else{
						System.out.println(nome+" atacou "+pkmn.nome+" causando 1 de dano!");
						pkmn.hp-=1;
						levelup(pkmn);
					}
				} else{
					System.out.println(pkmn.nome+" desviou do ataque!");
				}
			} else{
				System.out.println(pkmn.nome+" não pode lutar.");
			}
		} else{
			System.out.println(nome+" não pode lutar.");
		}
		
	
	}
}
