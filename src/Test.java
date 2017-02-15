
public class Test {
	private Domanda d[];
	private int n,pos=0;
	public Test(int num){
		if(num>5) n=5;
		else if(num<0) n=0;
		else n=num;
		
		d=new Domanda[n];
		String[] t={"Quanti stati ha l'America?","Con quali stati confina l'Italia?",
				"La capitale del Kuwait è...","Il Deserto del Sahara si trova in...",
				"In che continente si trova la China?"};
		String[][] r={{"20","50","40","55"},{"Svizzera","Austria","Germania","Francia"},{"Al-Kuwait","Mascate","Dacca","Katmandu"},
				{"Marocco","Chad","Congo","Nord Africa"},{"America","Europa","Asia","Africa"}};
		boolean[][] c={{false,true,false,false},{true,true,false,true},{true,false,false,false},
				{true,false,false,true},{false,false,true,false}};
		for(int i=0;i<n;i++){
			addDomanda(t[i],r[i],c[i]);
		}
	}
	
	public boolean addDomanda(String t,String[] r,boolean[] c){
		try{
			d[pos]=new Domanda(t);
			d[pos].setRisp(r.length, r);
			d[pos].setCorrette(c);
			pos++;
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean correggi(int n,boolean[] scelta){
		for(int i=0;i<4;i++){
			if(scelta[i]!=d[n].getCorrette()[i]){
				return false;
			}
		}
		return true;
	}
	
	
	public Domanda getDomanda(int n){
		return d[n];
	}
	public int getNum(){
		return n;
	}
}