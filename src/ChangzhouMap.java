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
		
		//创建、初始化盒式框体
		Box  outterBox, upperBox, mapBox, inputAreaBox, profileBox, inputBox1, inputBox2;
		outterBox = Box.createVerticalBox();
		upperBox = Box.createHorizontalBox();
		mapBox = Box.createHorizontalBox();
		inputAreaBox = Box.createVerticalBox();
		inputBox1 = Box.createHorizontalBox();
		inputBox2 = Box.createHorizontalBox();
		profileBox = Box.createVerticalBox();
		
		//添加图片载入框
		JLabel imagLabel = new JLabel(new ImageIcon("./src/img/map.jpg"));
		imagLabel.setBounds(100, 0, 400, 400);
		mapBox.setBounds(0, 0, 400, 400);
		mapBox.add(imagLabel);
		
		//添加输入框的标签、输入框和提交按钮
		String[] locationstStrings = new String[] {"1", "2", "3"};
		JComboBox<String> departureComboBox = new JComboBox<String>(locationstStrings);
		JComboBox<String> arrivalComboBox = new JComboBox<String>(locationstStrings);
		JLabel JLabel1 = new JLabel("出发点:   ");
//		JTextField departmentTextField = new JTextField("请输入出发点");
		JLabel JLabel2 = new JLabel("终点:        ");
//		JTextField arrivalTextField = new JTextField("请输入终点");
		JButton submitButton = new JButton("提交");
		
		inputBox1.add(JLabel1);
//		inputBox1.add(departmentTextField);
		inputBox1.add(departureComboBox);
		inputBox2.add(JLabel2);
//		inputBox2.add(arrivalTextField);
		inputBox2.add(arrivalComboBox);
		profileBox.add(new JTextArea("介绍空间"));
		
		//输入区域的组件组装
		inputAreaBox.add(Box.createRigidArea(new Dimension(0, 20)));
		inputAreaBox.add(inputBox1);
		inputAreaBox.add(inputBox2);
		inputAreaBox.add(inputBox2);
		inputAreaBox.add(submitButton);
		submitButton.setMinimumSize(new Dimension(50,50));
		inputAreaBox.add(Box.createRigidArea(new Dimension(0, 300)));
		
		//上部横向盒子组装
		upperBox.add(mapBox);
		upperBox.add(inputAreaBox);
		
		//最外层盒子组装
		outterBox.add(upperBox);
		outterBox.add(profileBox);
		
		//窗体添加box
		myJFrame.setBounds(100, 0, 600 , 600);

		myJFrame.add(outterBox);
		myJFrame.setVisible(true);
	}

}
//class ComboBoxItemListener extends Item



