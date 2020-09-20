import java.util.*;
class Graph {
	//私有成员变量
	private List<Vertex> vertexList;//节点列表
	private int vertexCount;//节点数量
	private int[][] weight;//带权路径表
	private boolean weightIsUpdated;//是否更新标记，实际上未使用
	private int[][] shortestRouteLength;//最短路径权值表，用于中间存储最短路径和最终输出
	private String[][] shortestRouthStrings;//最短路径的路径表
	//getter and setter
	protected int[][] getShortestRouteLength() {
		return shortestRouteLength;
	}
	protected String[][] getShortestRouthStrings() {
		return shortestRouthStrings;
	}


	protected boolean isWeightIsUpdated() {
		return weightIsUpdated;
	}
	protected void setWeightIsUpdated(boolean weightIsUpdated) {
		this.weightIsUpdated = weightIsUpdated;
	}
	protected List<Vertex> getVertexList() {
		return vertexList;
	}
	protected void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}
	protected int getVertexNumber() {
		return vertexCount;
	}
	protected void setVertexNumber(int vertexNumber) {
		this.vertexCount = vertexNumber;
	}
	protected int[][] getWeight() {
		return weight;
	}
	protected void setWeight(int[][] weight) {
		this.weight = weight;
	}
	//默认构建函数
	public Graph() {
		// TODO Auto-generated constructor stub
		this.setVertexList(null);
		this.setVertexNumber(0);
		this.setWeight(null);
		this.setWeightIsUpdated(true);
		shortestRouteLength = weight.clone();
		for (int row = 0; row < vertexCount; row++) {
			for (int colume = 0; colume < vertexCount; colume++) {
				shortestRouthStrings[row][colume] = null;
			}
		}
	}
	//实际在主程序中使用的带参构建函数
	Graph(List<Vertex> vertexList, int[][] weight){
		this.setVertexList(vertexList);
		this.setWeight(weight);
		this.setVertexNumber(vertexList.size());
		this.setWeightIsUpdated(true);
		shortestRouteLength = weight.clone();
		shortestRouthStrings = new String[getVertexNumber()][getVertexNumber()];
		for (int i = 0; i < shortestRouthStrings.length; i++) {
			for (int j = 0; j < shortestRouthStrings.length; j++) {
				shortestRouthStrings[i][j] = "";
			}
		}

	}
	//节点添加函数
	protected void add(Vertex newVertex) {
		this.vertexList.add(newVertex);
		this.setVertexNumber(getVertexNumber() + 1);
		this.setWeightIsUpdated(false);
	}
	//生成最短路径，将任意两点的最短路径长度与路径计算完成后保存在成员变量中，算法核心为弗洛伊德算法
	public void generateShortestRoute() {
		for (int row = 0; row < vertexCount; row++) {
			for (int colume = 0; colume < vertexCount; colume++) {
				for (int insertedVertex = 0; insertedVertex < vertexCount; insertedVertex++) {
					if (insertedVertex == row && insertedVertex == colume) {
						continue;
					}
					else {
						if (shortestRouteLength[row][insertedVertex] + shortestRouteLength[insertedVertex][colume] < shortestRouteLength[row][colume]) {
							shortestRouteLength[row][colume] = shortestRouteLength[row][insertedVertex] + shortestRouteLength[insertedVertex][colume];
							shortestRouthStrings[row][colume] = shortestRouthStrings[row][insertedVertex] + vertexList.get(insertedVertex).getVertexNameString() + "-" + shortestRouthStrings[insertedVertex][colume];
						}
					}
				}
			}
		}
	}
	//打印最短路径矩阵
	public void printShortestRoute() {
		for (int row = 0; row < vertexCount; row++) {
			for (int colume = 0; colume < vertexCount; colume++) {
				System.out.print(shortestRouteLength[row][colume]+"\t");
			}
			System.out.println();
		}
		for (int row = 0; row < vertexCount; row++) {
			for (int colume = 0; colume < vertexCount; colume++) {
				System.out.print(shortestRouthStrings[row][colume]+"\t\t");
			}
			System.out.println();
		}
	}
}
