import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		int n=1;
		Test test;
		/*
		String[] t={"Quanti stati ha l'America?","Il deserto del Sahara si trova in",
				"In che continente si trova la China?","La capitale del Kuwait è...",
				"Con che stati confina l'Italia"};
		String[][] r={{"20","50","40","55"},{"Marocco","Chad","Congo","Nord Africa"},
				{"America","Europa","Asia","Africa"},{"Al-Kuwait","Mascate","Dacca","Katmandu"},
				{"Svizzera","Austria","Germania","Francia"}};
		boolean[][] c={{false,true,false,false},{true,false,false,true},{false,false,true,false},
				{true,false,false,false},{true,true,false,true}};
		//*/
		
		JFileChooser jf = new JFileChooser("c:\\Users\\Andrea Felline\\Desktop");
		int i = jf.showDialog(null, "Seleziona un file");
		File f=null;
		if (i == JFileChooser.APPROVE_OPTION) {
			f=jf.getSelectedFile();
			try {
				FileReader fr = new FileReader(f);
				BufferedReader in = new BufferedReader(fr);
				String s = "";
				while ((s = in.readLine()) != null);
					//leggi
	
			} catch (IOException error) {
				System.out.println(error);
			}
		}
		String [] testo=new String[n];
		test=new Test(n);
		String[][] risp=new String[n][4];
		boolean[][] corr=new boolean[n][4];
		
		
		for(int j=0;j<test.getNum();j++){
			test.addDomanda(testo[j],risp[j],corr[j]);
		}
		FrameLog fl=new FrameLog();
		//attendi chiusura finestra fl
		test.getReg().addStudente(fl.getStud());
		TestFrame frame=new TestFrame(test);
	}

}
