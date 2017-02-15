import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {
	private JMenuItem correggi, esci, istruzioni, about;
	private Test t;
	private JRadioButton[] rb;
	private JCheckBox[] cb;
	private JLabel[] l;
	private JButton inv;
	private int num;
	public Frame(){
		super("TEST");
		
		menu();
		num=1;
		t=new Test(num);
		
		Container c=this.getContentPane();
		JPanel p=new JPanel();
		JPanel jb[]=new JPanel[num];
		for(int i=0;i<num;i++)
			jb[i]=new JPanel();
		p.setLayout(new GridLayout(num,1));
		l=new JLabel[num];
		for(int i=0;i<num;i++){	
			jb[i].setLayout(new GridLayout(5,1));
			l[i]=new JLabel(t.getDomanda(i).getText());
			
			jb[i].add(l[i]);
			
			
			if(t.getDomanda(i).isRS()){
				cb=new JCheckBox[4];
				String[] risp=t.getDomanda(i).getRisp();
				for(int j=0;j<4;j++){
					cb[j]=new JCheckBox(risp[j]);
					jb[i].add(cb[j]);
				}
				}
			else{
				ButtonGroup bg=new ButtonGroup();
				rb=new JRadioButton[4];
				String[] risp= t.getDomanda(i).getRisp();
				for(int j=0;j<4;j++){
					rb[j]=new JRadioButton(risp[j]);
					bg.add(rb[j]);
					jb[i].add(rb[j]);
				}
			}
			
			
			p.add(jb[i]);
		}
		c.add(p);
		
		setResizable(false);
		setLocation(100, 100);
		switch (num){
		case 1: setSize(400, 200);
		break;
		case 2: setSize(400, 350);
		break;
		case 3: setSize(400, 450);
		break;
		case 4: setSize(400, 550);
		break;
		case 5: setSize(400, 650);
		break;
		}
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void menu() {
		JMenu test = new JMenu("Opzioni");
		JMenu help = new JMenu("Help");
		JMenuBar mb = new JMenuBar();

		correggi = new JMenuItem("Correggi", 'C');
		esci = new JMenuItem("Esci", 'E');
		about = new JMenuItem("About", 'A');
		istruzioni = new JMenuItem("Istruzioni", 'I');

		correggi.addActionListener(this);
		esci.addActionListener(this);
		about.addActionListener(this);
		istruzioni.addActionListener(this);

		test.add(correggi);
		test.addSeparator();
		test.add(esci);
		help.add(about);
		help.add(istruzioni);

		mb.add(test);
		mb.add(help);

		this.setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o=arg0.getSource();
		if(o==correggi){
			//for(int i=0;i<num;i++){
			
			
			//}
		}
		else if(o==esci){
			System.exit(0);
			}
		else if(o==about){
			JOptionPane.showMessageDialog(null,"v 1.0 \n Matteo Rizzello","Informazioni",JOptionPane.INFORMATION_MESSAGE,null);
		}
		else if(o==istruzioni){
			JOptionPane.showMessageDialog(null,"Rispondere alle domande e poi premere Opzioni>Invia","Aiuto",JOptionPane.INFORMATION_MESSAGE,null);
		}

	}

	public static void main(String[] args) {
		new Frame();
	}
}
