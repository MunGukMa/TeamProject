package team.hundred.fitc.vo;

public class RamVO {
	private int num;
	private String name;
	private String spec;
	private String src_link;
	
	public RamVO() {
		// TODO Auto-generated constructor stub
	}

	public RamVO(int num, String name, String spec, String src_link) {
		super();
		this.num = num;
		this.name = name;
		this.spec = spec;
		this.src_link = src_link;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSrc_link() {
		return src_link;
	}

	public void setSrc_link(String src_link) {
		this.src_link = src_link;
	}

	@Override
	public String toString() {
		return "RamVO [num=" + num + ", name=" + name + ", spec=" + spec + ", src_link=" + src_link + ", getNum()="
				+ getNum() + ", getName()=" + getName() + ", getSpec()=" + getSpec() + ", getSrc_link()="
				+ getSrc_link() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
