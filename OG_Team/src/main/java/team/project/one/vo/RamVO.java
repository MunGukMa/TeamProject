package team.project.one.vo;

public class RamVO {
	private int ram_seq;
	private String name;
	private String spec;
	private String src_link;
	
	public RamVO() {
		// TODO Auto-generated constructor stub
	}

	public RamVO(int ram_seq, String name, String spec, String src_link) {
		super();
		this.ram_seq = ram_seq;
		this.name = name;
		this.spec = spec;
		this.src_link = src_link;
	}

	public int getRam_seq() {
		return ram_seq;
	}

	public void setRam_seq(int ram_seq) {
		this.ram_seq = ram_seq;
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
		return "RamVO [ram_seq=" + ram_seq + ", name=" + name + ", spec=" + spec + ", src_link=" + src_link + "]";
	}
	
}
