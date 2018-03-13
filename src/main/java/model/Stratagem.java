package model;

public class Stratagem {

	private String name;
	private String sequence;
	private int type;
	private String iconFileName;

	public Stratagem() {

	}

	public Stratagem(String name, String sequence, int type, String iconFileName) {
		super();
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.iconFileName = iconFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

}
