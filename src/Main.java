
public class Main {

	public static void main(String[] args) {
		int n=5;
		Test test=new Test(n);
		
		String[] t={"Quanti stati ha l'America?","Il deserto del Sahara si trova in",
				"In che continente si trova la China?","La capitale del Kuwait è...",
				"Con che stati confina l'Italia"};
		String[][] r={{"20","50","40","55"},{"Marocco","Chad","Congo","Nord Africa"},
				{"America","Europa","Asia","Africa"},{"Al-Kuwait","Mascate","Dacca","Katmandu"},
				{"Svizzera","Austria","Germania","Francia"}};
		boolean[][] c={{false,true,false,false},{true,false,false,true},{false,false,true,false},
				{true,false,false,false},{true,true,false,true}};

		for(int i=0;i<test.getNum();i++){
			test.addDomanda(t[i],r[i],c[i]);
		}
		
		TestFrame frame=new TestFrame(test);
	}

}
