
public class Registro {
	private RisTest[] rt;
	private int num, pos;

	public Registro(int n) {
		num = n;
		rt = new RisTest[n];
		pos=0;
	}

	public RisTest getRisTest(int p) {
		try {
			return rt[p];
		} catch (Exception e) {
			return null;
		}
	}

	public RisTest[] getRisTest(Studente s) {
		int n = 0;
		for (int i = 0; i < pos; i++) {
			if (rt[i].getS() == s)
				n++;
		}
		RisTest[] temp = new RisTest[n];
		for (int i = 0, j = 0; i < pos; i++) {
			if (rt[i].getS() == s) {
				temp[j] = rt[i];
				j++;
			}
		}
		return temp;
	}

	public RisTest[] getRisTest(String materia) {
		int n = 0;
		for (int i = 0; i < pos; i++) {
			if (rt[i].getMateria().compareTo(materia) == 0)
				n++;
		}
		RisTest[] temp = new RisTest[n];
		for (int i = 0, j = 0; i < pos; i++) {
			if (rt[i].getMateria().compareTo(materia) == 0) {
				temp[j] = rt[i];
				j++;
			}
		}
		return temp;
	}
	
	public void addRisTest(RisTest r){
		if(pos<=num)
			rt[pos]=r;
		if(pos<num)
			pos++;
	}

}
