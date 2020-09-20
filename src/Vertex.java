

class Vertex {
	//私有变量
	private int vertexIndex;//节点编号
	private String vertexNameString;//节点名字
	private String spotIntroFilePath;//节点介绍文件的路径
	//getter and setter
	public int getVertexIndex() {
		return vertexIndex;
	}
	public void setVertexIndex(int vertexIndex) {
		this.vertexIndex = vertexIndex;
	}
	public String getVertexNameString() {
		return vertexNameString;
	}
	public void setVertexNameString(String vertexNameString) {
		this.vertexNameString = vertexNameString;
	}
	public String getSpotIntroFilePath() {
		return spotIntroFilePath;
	}
	public void setSpotIntroFilePath(String spotIntroFilePath) {
		this.spotIntroFilePath = spotIntroFilePath;
	}
	//Constructors
	Vertex() {
		// TODO Auto-generated constructor stub
		this.setVertexIndex(-1);
		this.setVertexNameString("NULL");
		this.setSpotIntroFilePath(null);
	}
	Vertex(int vertexIndex, String vertexNameString, String spotIntroFilePath){
		this.setVertexIndex(vertexIndex);
		this.setVertexNameString(vertexNameString);
		this.setSpotIntroFilePath(spotIntroFilePath);
	}
	//主程序中所采用的构造方法，利用配置文件中的一行配置读取节点信息直接创建节点
	Vertex(String configString){
		String[] vertexItems = configString.split(":"); 
		this.setVertexIndex(Integer.parseInt(vertexItems[0]));
		this.setVertexNameString(vertexItems[1]);
		this.setSpotIntroFilePath(vertexItems[2]);
	}
	@Override
	public boolean equals(Object comparedVertex) {
		// TODO Auto-generated method stub
		if (comparedVertex instanceof Vertex) {
			return this.vertexNameString.equals(((Vertex)comparedVertex).vertexNameString);
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getVertexIndex()+getVertexNameString();
	}
}
