
public class Test {
	private Domanda d[];
	private Registro r;
	private int n,pos=0;
	public Test(int num){
		if(num>5) n=5;
		else if(num<0) n=0;
		else n=num;
		
		d=new Domanda[n];
		String[] t={"Quanti stati ha l'America?","Il deserto del Sahara si trova in",
				"In che continente si trova la China?","La capitale del Kuwait è...",
				"Con che stati confina l'Italia"};
		String[][] r={{"20","50","40","55"},{"Marocco","Chad","Congo","Nord Africa"},
				{"America","Europa","Asia","Africa"},{"Al-Kuwait","Mascate","Dacca","Katmandu"},
				{"Svizzera","Austria","Germania","Francia"}};
		boolean[][] c={{false,true,false,false},{true,false,false,true},{false,false,true,false},
				{true,false,false,false},{true,true,false,true}};
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
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
	
	public boolean correggi(int n,boolean[] scelte){
		for(int i=0;i<4;i++)
			if(scelte[i]!=d[n].getCorrette()[i])
				return false;
		return true;
	}
	
	public Domanda getDomanda(int x){
		return d[x];
	}
	
	public int getNum(){
		return n;
	}
	
}