import java.util.ArrayList;
import java.util.List;

public class ConsoleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vertex spotVertex1 = new Vertex(0, "��÷��԰", null);
		Vertex spotVertex2 = new Vertex(1, "������", null);
		Vertex spotVertex3 = new Vertex(2, "���Ĺ�԰", null);
		Vertex spotVertex4 = new Vertex(3, "����", null);
		Vertex spotVertex5 = new Vertex(4, "����԰", null);
		Vertex spotVertex6 = new Vertex(5, "����վ", null);
		Vertex spotVertex7 = new Vertex(6, "�±����", null);
		Vertex spotVertex8 = new Vertex(7, "�Ӻ���ѧ", null);
		Vertex spotVertex9 = new Vertex(8, "����Ժ", null);
		Vertex spotVertex10 = new Vertex(9, "���ݴ�ѧ", null);
		List<Vertex> spotVertexList = new ArrayList<Vertex>();
		spotVertexList.add(spotVertex1);
		spotVertexList.add(spotVertex2);
		spotVertexList.add(spotVertex3);
		spotVertexList.add(spotVertex4);
		spotVertexList.add(spotVertex5);
		spotVertexList.add(spotVertex6);
		spotVertexList.add(spotVertex7);
		spotVertexList.add(spotVertex8);
		spotVertexList.add(spotVertex9);
		spotVertexList.add(spotVertex10);
		int[][] weight = new int[spotVertexList.size()][spotVertexList.size()];
		int max=10000;
		for(int i=0;i<spotVertexList.size();i++ ) {
			 for(int j=0;j<spotVertexList.size();j++) {
		         weight[i][j]=max;
			 }
		 }//���ڽӾ��󸳳�ֵ��Ĭ����û�б�
		for(int i=0;i<spotVertexList.size();i++) {
			 for(int j=0;j<spotVertexList.size();j++) {
				 if(i==j) {weight[i][j]=0;}//�������޻�ͼ�������ڽӾ���Խ��ߵ�ֵ��0
			 }
		 }
		weight[1][2]=3;
		weight[2][1]=3;
		weight[2][4]=10;
		weight[4][2]=10;
		weight[3][5]=7;
		weight[5][3]=7;
		weight[4][5]=11;
		weight[5][4]=11;
		weight[6][8]=5;
		weight[8][6]=5;
		weight[7][0]=8;
		weight[0][7]=8;
		weight[8][2]=6;
		weight[2][8]=6;
		weight[9][4]=13;
		weight[4][9]=13;
		weight[9][7]=4;
		weight[7][9]=4; 
		Graph spotGraph = new Graph(spotVertexList, weight);
		spotGraph.generateShortestRoute();
		spotGraph.printShortestRoute();
	}

}
