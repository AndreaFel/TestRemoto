import java.util.ArrayList;

public class Studente {
	private String nome,cog,classe,dataN;
	private int pos;
	public ArrayList<RisTest> rt;
	public Studente(String n,String c,String d) {
		 nome=n;
		 cog=c;
		 pos=0;
		 dataN=d;
		 rt=new ArrayList<RisTest>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCog() {
		return cog;
	}
	
	public String getClasse() {
		return classe;
	}
	
	public String getDataN() {
		return dataN;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public RisTest getRisTest(int p) {
		try {
			return rt.get(p);
		} catch (Exception e) {
			return null;
		}
	}

	public ArrayList<RisTest> getRisTest(String materia) {
		ArrayList<RisTest> temp = new ArrayList<RisTest>();
		for (int i = 0; i < pos; i++) {
			if (rt.get(i).getMateria().compareTo(materia) == 0) {
				temp.add(rt.get(i));
			}
		}
		return temp;
	}
	
	public void addRisTest(RisTest r){
		rt.add(r);
	}
	
	public String toString(){
		String s="";
		s+="Nome: "+nome;
		s+="\nCognome: "+cog;
		s+="\nData di nascita: "+dataN;
		s+="\nClasse: "+classe;
		int punti=0;
		for(int i=0;i<rt.size();i++)
			punti+=rt.get(i).getPunti();
		s+="\nPunti: "+punti+"\\"+(rt.size()*5);
		return s;
	}

}
