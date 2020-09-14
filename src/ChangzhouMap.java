/**
 * 
 */

/**
 * @author James
 *
 */
import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class ChangzhouMap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(System.getProperty("user.dir"));
		JFrame myJFrame = new JFrame("Test JFrame");
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myJFrame.setSize(800, 600);
		//BoxLayout boxLayout = new BoxLayout(myJFrame, 0);
		
		//��������ʼ����ʽ����
		Box  outterBox, upperBox, mapBox, inputAreaBox, profileBox, inputBox1, inputBox2;
		outterBox = Box.createVerticalBox();
		upperBox = Box.createHorizontalBox();
		mapBox = Box.createHorizontalBox();
		inputAreaBox = Box.createVerticalBox();
		inputBox1 = Box.createHorizontalBox();
		inputBox2 = Box.createHorizontalBox();
		profileBox = Box.createVerticalBox();
		
		//���ͼƬ�����
		JLabel imagLabel = new JLabel(new ImageIcon("./src/img/map.jpg"));
		imagLabel.setBounds(100, 0, 400, 400);
		mapBox.setBounds(0, 0, 400, 400);
		mapBox.add(imagLabel);
		
		//��������ı�ǩ���������ύ��ť
		String[] locationstStrings = new String[] {"1", "2", "3"};
		JComboBox<String> departureComboBox = new JComboBox<String>(locationstStrings);
		JComboBox<String> arrivalComboBox = new JComboBox<String>(locationstStrings);
		JLabel JLabel1 = new JLabel("������:   ");
//		JTextField departmentTextField = new JTextField("�����������");
		JLabel JLabel2 = new JLabel("�յ�:        ");
//		JTextField arrivalTextField = new JTextField("�������յ�");
		JButton submitButton = new JButton("�ύ");
		
		inputBox1.add(JLabel1);
//		inputBox1.add(departmentTextField);
		inputBox1.add(departureComboBox);
		inputBox2.add(JLabel2);
//		inputBox2.add(arrivalTextField);
		inputBox2.add(arrivalComboBox);
		profileBox.add(new JTextArea("���ܿռ�"));
		
		//��������������װ
		inputAreaBox.add(Box.createRigidArea(new Dimension(0, 20)));
		inputAreaBox.add(inputBox1);
		inputAreaBox.add(inputBox2);
		inputAreaBox.add(inputBox2);
		inputAreaBox.add(submitButton);
		submitButton.setMinimumSize(new Dimension(50,50));
		inputAreaBox.add(Box.createRigidArea(new Dimension(0, 300)));
		
		//�ϲ����������װ
		upperBox.add(mapBox);
		upperBox.add(inputAreaBox);
		
		//����������װ
		outterBox.add(upperBox);
		outterBox.add(profileBox);
		
		//�������box
		myJFrame.setBounds(100, 0, 600 , 600);

		myJFrame.add(outterBox);
		myJFrame.setVisible(true);
	}

}
//class ComboBoxItemListener extends Item



