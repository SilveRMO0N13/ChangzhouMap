/**
 * 
 */

/**
 * @author James
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ChangzhouMap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        String configString = readToString("./src/config.txt");
        System.out.println(configString);
        String[] configStrings = configString.split("\r\n");
        System.out.println(configStrings[0]);
        Vertex testVertex = new Vertex(configStrings[0]);
        System.out.println(readToString(testVertex.getSpotIntroFilePath()));
        //从将内存中的节点信息转化为节点类对象
        List<Vertex> spotVertexs = new ArrayList<Vertex>();
        for (int index = 0; index < configStrings.length; index++) {
			spotVertexs.add(new Vertex(configStrings[index]));
		}
        //处理带权路径路线文件
        String matrixString = readToString("./src/weight.txt");
        String[] matrixLine = matrixString.split("\r\n");
        String[][] weightStrings = new String[spotVertexs.size()][spotVertexs.size()];
        for (int row = 0; row < matrixLine.length; row++) {
			weightStrings[row] = matrixLine[row].split(",");
		}
        int weight[][] = new int[spotVertexs.size()][spotVertexs.size()];
        for (int row = 0; row < spotVertexs.size(); row++) {
        	for (int colume = 0; colume < matrixLine.length; colume++) {
				weight[row][colume] = Integer.parseInt(weightStrings[row][colume]);
			}
		}
        weight.toString();
        //生成图对象，生成最短路径矩阵和
		Graph spotGraph = new Graph(spotVertexs, weight);
		spotGraph.generateShortestRoute();
//		spotGraph.printShortestRoute();
		
		
		//创建窗体，一个主窗体，一个副窗体用来提示最短路径
		JFrame mainJFrame = new JFrame("常州景点介绍");
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame sideJFrame = new JFrame("最短路径");
		sideJFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		sideJFrame.setBounds(200, 200, 600, 200);;
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(40);
		flowLayout.setVgap(20);
		flowLayout.setAlignment(FlowLayout.CENTER);
		sideJFrame.setLayout(flowLayout);
		JLabel shortestPathJLabel = new JLabel();
		JLabel shortestPathCountJLabel = new JLabel();
		sideJFrame.add(shortestPathJLabel);
		sideJFrame.add(shortestPathCountJLabel);
		//创建、初始化盒式框体
		Box  outterBox, upperBox, mapBox, inputAreaBox, profileBox, inputBox1, inputBox2;
		outterBox = Box.createVerticalBox();
		upperBox = Box.createHorizontalBox();
		mapBox = Box.createHorizontalBox();
		inputAreaBox = Box.createVerticalBox();
		inputBox1 = Box.createHorizontalBox();
		inputBox2 = Box.createHorizontalBox();
		profileBox = Box.createVerticalBox();
		
		
		//添加景点列表
		String[] vertexNamesForJList = new String[spotVertexs.size()];
		for (int index = 0; index < vertexNamesForJList.length; index++) {
			vertexNamesForJList[index] = spotVertexs.get(index).getVertexNameString();
		}
		JList<String> menuJList = new JList<String>();
		menuJList.setListData(vertexNamesForJList);
		JTextArea profileArea = new JTextArea("介绍空间");
		profileArea.setLineWrap(true);
		menuJList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedIndex = menuJList.getSelectedIndex();
				String selectedVertexPathString = spotVertexs.get(selectedIndex).getSpotIntroFilePath();
				profileArea.setText(readToString(selectedVertexPathString));
			}
		});
		mapBox.add(menuJList);
		
		//添加输入框的标签、输入框和提交按钮
		JComboBox<String> departureComboBox = new JComboBox<String>(vertexNamesForJList);
		JComboBox<String> arrivalComboBox = new JComboBox<String>(vertexNamesForJList);
		JLabel JLabel1 = new JLabel("出发点:   ");
//		JTextField departmentTextField = new JTextField("请输入出发点");
		JLabel JLabel2 = new JLabel("终点:        ");
//		JTextField arrivalTextField = new JTextField("请输入终点");
		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int departureVertexIndex, arrivalVertexIndex;
				departureVertexIndex = departureComboBox.getSelectedIndex();
				arrivalVertexIndex = arrivalComboBox.getSelectedIndex();
				String pathInfoString = null;
				String pathCountInfoString = null;
				if (departureVertexIndex == arrivalVertexIndex) {
					shortestPathJLabel.setText("请选择两个不同的地点");
				}
				else {
					pathInfoString = String.format("从%s到%s的最短路径为：%s    ", 
							spotVertexs.get(departureVertexIndex).getVertexNameString(), 
							spotVertexs.get(arrivalVertexIndex).getVertexNameString(),
							spotVertexs.get(departureVertexIndex).getVertexNameString() + "-"+spotGraph.getShortestRouthStrings()[departureVertexIndex][arrivalVertexIndex] + spotVertexs.get(arrivalVertexIndex).getVertexNameString());
					pathCountInfoString = String.format("最短路径长度为：%d", spotGraph.getShortestRouteLength()[departureVertexIndex][arrivalVertexIndex]);
					shortestPathJLabel.setText(pathInfoString);
					shortestPathCountJLabel.setText(pathCountInfoString);
				}
				sideJFrame.setVisible(true);

			}
		});
		
		inputBox1.add(JLabel1);
//		inputBox1.add(departmentTextField);
		inputBox1.add(departureComboBox);
		inputBox2.add(JLabel2);
//		inputBox2.add(arrivalTextField);
		inputBox2.add(arrivalComboBox);
		profileBox.add(profileArea);
		
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
		mainJFrame.setBounds(100, 0, 600 , 800);

		mainJFrame.add(outterBox);
		mainJFrame.setVisible(true);
	}
	//来源https://www.cnblogs.com/longronglang/p/7458027.html
	public static String readToString(String filePath) {  
        String encoding = "UTF-8";  
        File file = new File(filePath);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }  

}




