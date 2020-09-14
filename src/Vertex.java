import java.io.File;

class Vertex {
	private int vertexIndex;
	private String vertexNameString;
	private File spotIntroFile;
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
	public File getSpotIntroFile() {
		return spotIntroFile;
	}
	public void setSpotIntroFile(File spotIntroFile) {
		this.spotIntroFile = spotIntroFile;
	}
	Vertex() {
		// TODO Auto-generated constructor stub
		this.setVertexIndex(-1);
		this.setVertexNameString("NULL");
		this.setSpotIntroFile(null);
	}
	Vertex(int vertexIndex, String vertexNameString, File spotIntroFile){
		this.setVertexIndex(vertexIndex);
		this.setVertexNameString(vertexNameString);
		this.setSpotIntroFile(spotIntroFile);
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
