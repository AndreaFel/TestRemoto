
public class RisTest {
	private String dataS, materia;
	private int punti;
	private Studente s;

	public RisTest(String d, int p, String m, Studente stud) {
		dataS = d;
		materia = m;
		punti = p;
		s = stud;
	}

	public String getDataS() {
		return dataS;
	}

	public String getMateria() {
		return materia;
	}

	public int getPunti() {
		return punti;
	}

	public Studente getS() {
		return s;
	}
}
