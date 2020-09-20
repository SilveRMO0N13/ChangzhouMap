

class Vertex {
	//˽�б���
	private int vertexIndex;//�ڵ���
	private String vertexNameString;//�ڵ�����
	private String spotIntroFilePath;//�ڵ�����ļ���·��
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
	//�������������õĹ��췽�������������ļ��е�һ�����ö�ȡ�ڵ���Ϣֱ�Ӵ����ڵ�
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
