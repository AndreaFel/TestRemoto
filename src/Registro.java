import java.util.ArrayList;

public class Registro {
	private ArrayList<Studente> stud;

	public Registro() {
		stud = new ArrayList<Studente>();
	}
	
	public void addStudente(Studente s){
		stud.add(s);
	}
	
	public Studente getStud(String nome,String cog){
		for(int i=0;i<stud.size();i++){
			if(stud.get(i).getNome().compareTo(nome)==0 && stud.get(i).getCog().compareTo(cog)==0)
				return stud.get(i);
		}
		return null;
	}
	
	public ArrayList<Studente> getStud(String classe){
		ArrayList<Studente> temp=new ArrayList<Studente>();
		for(int i=0;i<stud.size();i++){
			if(stud.get(i).getClasse().compareTo(classe)==0)
				temp.add(stud.get(i));
		}
		return temp;
	}

}
