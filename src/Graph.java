import java.util.*;
class Graph {
	private List<Vertex> vertexList;
	private int vertexCount;
	private int[][] weight;
	private boolean weightIsUpdated;
	private int[][] shortestRouteLength;
	protected int[][] getShortestRouteLength() {
		return shortestRouteLength;
	}
	protected String[][] getShortestRouthStrings() {
		return shortestRouthStrings;
	}

	private String[][] shortestRouthStrings;
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
	protected void add(Vertex newVertex) {
		this.vertexList.add(newVertex);
		this.setVertexNumber(getVertexNumber() + 1);
		this.setWeightIsUpdated(false);
	}
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
