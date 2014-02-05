
public class Principal {
	public static void main(String[] args){
		Pokemon[] billspc = new Pokemon[12];
		billspc[0] = new Pokemon("Alakazam",55,135,85,1);
		billspc[1] = new Pokemon("Golem",80,110,130,1);
		billspc[2] = new Pokemon("Gyarados",95,125,79,100);
		billspc[3] = new Pokemon("Arcanine",90,110,80,41);
		billspc[4] = new Pokemon("Arcanine",90,110,80,42);
		billspc[5] = new Pokemon("Arcanine",90,110,80,43);
		billspc[6] = new Pokemon("Arcanine",90,110,80,44);
		billspc[7] = new Pokemon("Arcanine",90,110,80,100);
		billspc[8] = new Pokemon("Alakazam",55,135,85,41);
		billspc[9] = new Pokemon("Alakazam",55,135,85,42);
		billspc[10] = new Pokemon("Alakazam",55,135,85,50);
		billspc[11] = new Pokemon("Alakazam",55,135,85,100);
		for (int contador=0;contador<=11;contador+=1){
			billspc[contador].mostrar();
		}
		for (int contador=0; contador<=350;contador+=1){
			billspc[0].atacar(billspc[2]);
		}
	}
}
