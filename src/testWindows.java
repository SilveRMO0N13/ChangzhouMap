import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jFrame = new JFrame("≤Â»ÎÕº∆¨");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(0, 0, 600, 600);
		JLabel imageJLabel = new JLabel(new ImageIcon("./src/img/map.jpg"));
		imageJLabel.setBounds(0, 0, 400, 400);
		jFrame.add(imageJLabel);
		jFrame.setVisible(true);
		
	}

}
