
public class Test {
	private Domanda d[];
	private Registro r;
	private int n,pos=0;
	public Test(int num){
		if(num>5) n=5;
		else if(num<1) n=1;
		else n=num;
		
		d=new Domanda[n];
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