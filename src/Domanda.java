
public class Domanda {
	private String testo;
	private String[] risposte;
	private boolean[] corrette;
	private boolean rispSing=false;
	private int num;
	private String materia;
	public Domanda(String d) {
		testo=d;
	}
	
	public void setRisp(int n,String[] r){
		num=n;
		risposte=new String[n];
		for(int i=0;i<n;i++)
			risposte[i]=r[i];
	}
	
	public void setCorrette(boolean[] c){
		corrette=new boolean[num];
		int cor=0;
		for(int i=0;i<num;i++){
			corrette[i]=c[i];
			if (c[i]) cor++;
		}
		if(cor==1) rispSing=true;
	}
	
	public String getText(){
		return testo;
	}
	
	public String[] getRisp(){
		return risposte;
	}
	
	public boolean[] getCorrette(){
		return corrette;
	}
	
	public boolean isRS(){
		return rispSing;
	}
	
	public void setMateria(int n){
		switch(n){
		case 0: materia="Matematica";
			break;
		case 1: materia="Italiano";
		break;
		case 2: materia="Storia";
		break;
		case 3: materia="Informatica";
		break;
		case 4: materia="Sistemi";
		break;
		case 5: materia="Inglese";
		break;
		}
	}
	
	public String getMateria(){
		return materia;
	}

}
