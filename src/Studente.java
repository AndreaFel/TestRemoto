
public class Studente {
	private String nome,cog,classe,dataN;
	public Studente(String n,String c,String d) {
		 nome=n;
		 cog=c;
		 dataN=d;
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCog(String cog) {
		this.cog = cog;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public void setDataN(String dataN) {
		this.dataN = dataN;
	}
	
	public String toString(){
		String s="";
		s+="Nome: "+nome;
		s+="\nCognome: "+cog;
		s+="\nData di nascita: "+dataN;
		s+="\nClasse: "+classe;
		return s;
	}

}
