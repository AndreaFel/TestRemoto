import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		int n=1;
		Test test;
		
		

			try {
				FileReader fr = new FileReader("Database.txt");
				BufferedReader in = new BufferedReader(fr);
				System.out.println(in.readLine());
				
			} catch (IOException error) {
				File f=new File("Database.txt");
				try {
					FileWriter fout = new FileWriter(f);
					PrintWriter out = new PrintWriter(fout);
					out.close();
					fout.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			
			
		FrameLog fl=new FrameLog();
		JFileChooser jf = new JFileChooser("c:\\Users\\Andrea Felline\\Desktop");
		int i = jf.showDialog(null, "Seleziona un file");
		File f=null;
		if (i == JFileChooser.APPROVE_OPTION) {
			String s="0";
			f=jf.getSelectedFile();
			try {
				FileReader fr = new FileReader(f);
				BufferedReader in = new BufferedReader(fr);
				s = in.readLine();
				n=Integer.valueOf(s);
			} catch (IOException error) {
				System.out.println(error);
			}
			//il file è visto come 
			//num domande
			//domanda
			//risposta falsa
			//-risposta vera
			String [] testo=new String[n];
			test=new Test(n);
			String[][] risp=new String[n][4];
			boolean[][] corr=new boolean[n][4];
				
			try{
				FileReader fr = new FileReader(f);
				BufferedReader in = new BufferedReader(fr);
				s = in.readLine();
				for(int j=0;j<n;j++){
					s = in.readLine();
					testo[j]=s;
					System.out.println(s);
					for(int k=0;k<4;k++){
						s = in.readLine();
						risp[j][k]=s;
						if(s.charAt(0)=='-'){
							corr[j][k]=true;
							risp[j][k]=s.substring(1,s.length());
						}else corr[j][k]=false;
						System.out.println(risp[j][k] + " " + corr[j][k]);
					}
				}
			} catch (IOException error) {
				System.out.println(error);
			}
			
			for(int j=0;j<test.getNum();j++){
				test.addDomanda(testo[j],risp[j],corr[j]);
			}
			
			test.getReg().addStudente(fl.getStud());
			TestFrame frame=new TestFrame(test);
		}
	}
	

	}
