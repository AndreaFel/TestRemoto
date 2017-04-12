import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameLog extends JDialog implements ActionListener {
	private JTextField nome,cog,classe;
	private JComboBox gg,mm,aa;
	private JButton log;
	private Studente temp;
	public FrameLog(){
		//super("Test");		
		this.setModal(true);
		Container c = this.getContentPane();
		JPanel p = new JPanel(new GridLayout(5,1));
		JPanel pl[]=new JPanel[5];
		for(int i=0;i<5;i++)
			pl[i]=new JPanel();
		
		JLabel nom=new JLabel("Nome: "),co=new JLabel("Cognome: "),cl=new JLabel("Classe: ");
		nome=new JTextField(15);
		cog=new JTextField(15);
		classe=new JTextField(15);
		gg=new JComboBox();
		mm=new JComboBox();
		aa=new JComboBox();
		for(int i=0;i<31;i++){
			gg.addItem(i+1);
			if(i<12)
				mm.addItem(i+1);
			aa.addItem(1969+i);
		}
		log=new JButton("Log in");
		log.addActionListener(this);
		
		pl[0].add(nom);
		pl[0].add(nome);
		pl[1].add(co);
		pl[1].add(cog);
		pl[2].add(cl);
		pl[2].add(classe);
		pl[3].add(gg);
		pl[3].add(mm);
		pl[3].add(aa);
		pl[4].add(log);
		p.add(pl[0]);
		p.add(pl[1]);
		p.add(pl[2]);
		p.add(pl[3]);
		p.add(pl[4]);
		c.add(p);
		
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocation(400, 200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == log) {
			String data=gg.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+aa.getSelectedItem();
			temp=new Studente(nome.getText(),cog.getText(),data);
			temp.setClasse(classe.getText());
			super.dispose();
		}
	}
	
	public Studente getStud(){
		return temp;
	}
	
	/*public static void main(String[] args) {
		new FrameLog();
	}*/
}
