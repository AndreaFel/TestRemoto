import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame extends JFrame implements ActionListener {
	private JCheckBox cb[][];
	private JRadioButton rb[][];
	private JMenuItem invia, exit, info, help;
	private Test t;
	private int num;
	private JLabel[] l;

	public TestFrame() {
		super("Test");

		num = 5;
		menu();
		t = new Test(num);
		Container c = this.getContentPane();
		JPanel p = new JPanel();
		JPanel pd[] = new JPanel[num];
		for (int i = 0; i < num; i++)
			pd[i] = new JPanel();
		p.setLayout(new GridLayout(num, 1));
		l = new JLabel[num];
		int k = 0, f = 0;

		rb = new JRadioButton[3][4];
		cb = new JCheckBox[2][4];

		for (int i = 0; i < num; i++) {
			pd[i].setLayout(new GridLayout(5, 1, 100, 0));
			l[i] = new JLabel(t.getDomanda(i).getText());

			pd[i].add(l[i]);

			if (t.getDomanda(i).isRS()) {// f
				String[] risp = t.getDomanda(i).getRisp();
				for (int j = 0; j < 4; j++) {
					cb[f][j] = new JCheckBox(risp[j]);
					pd[i].add(cb[f][j]);
				}
				f++;
			} else {// k
				ButtonGroup bg = new ButtonGroup();
				String[] risp = t.getDomanda(i).getRisp();
				for (int j = 0; j < 4; j++) {
					rb[k][j] = new JRadioButton(risp[j]);
					bg.add(rb[k][j]);
					pd[i].add(rb[k][j]);
				}
				k++;
			}
			p.add(pd[i]);
		}

		c.add(p);

		// this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocation(400, 200);
		setVisible(true);
	}

	public void menu() {
		JMenu op, inf;
		JMenuBar mb = new JMenuBar();

		op = new JMenu("File");
		inf = new JMenu("?");

		invia = new JMenuItem("Invia", 'I');
		exit = new JMenuItem("Esci", 'E');
		info = new JMenuItem("Info", 'I');
		help = new JMenuItem("Aiuto", 'A');

		invia.addActionListener(this);
		exit.addActionListener(this);
		info.addActionListener(this);
		help.addActionListener(this);

		op.add(invia);
		op.addSeparator();
		op.add(exit);
		inf.add(info);
		inf.add(help);

		mb.add(op);
		mb.add(inf);

		this.setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == invia) {
			int punti = 0, k = 0, f = 0;

			for (int i = 0; i < num; i++) {

				if (!t.getDomanda(i).isRS()) {
					boolean[] scelte = { rb[k][0].isSelected(), rb[k][1].isSelected(), rb[k][2].isSelected(),
							rb[k][3].isSelected() };
					if (t.correggi(i, scelte)) punti++;
					k++;
				} else {

					boolean[] scelte = { cb[f][0].isSelected(), cb[f][1].isSelected(), cb[f][2].isSelected(),
							cb[f][3].isSelected() };
					if (t.correggi(i, scelte))
						punti++;
					f++;
				}
			}
			JOptionPane.showMessageDialog(null, "Punti: " + punti + "/5", "Punteggio", JOptionPane.INFORMATION_MESSAGE,
					null);
			System.exit(0);

		} else if (o == exit) {
			System.exit(0);
		} else if (o == info) {
			JOptionPane.showMessageDialog(null, "v 1.0\nSviluppato da\nAndrea Felline", "Informazioni",
					JOptionPane.INFORMATION_MESSAGE, null);
		} else if (o == help) {
			JOptionPane.showMessageDialog(null, "Rispondere alle domande e poi scegliere File>Invia", "Aiuto",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public static void main(String[] args) {
		new TestFrame();
	}

}
