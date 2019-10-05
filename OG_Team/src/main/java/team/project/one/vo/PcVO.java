package team.project.one.vo;

public class PcVO {
	private String cpu;
	private String ram;
	private String gpu;
	private String mainboard;
	private String power;
	private String pc_case;
	
	public PcVO() {
		// TODO Auto-generated constructor stub
	}

	public PcVO(String cpu, String ram, String gpu, String mainboard, String power, String pc_case) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.gpu = gpu;
		this.mainboard = mainboard;
		this.power = power;
		this.pc_case = pc_case;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getMainboard() {
		return mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPc_case() {
		return pc_case;
	}

	public void setPc_case(String pc_case) {
		this.pc_case = pc_case;
	}

	@Override
	public String toString() {
		return "PcVO [cpu=" + cpu + ", ram=" + ram + ", gpu=" + gpu + ", mainboard=" + mainboard + ", power=" + power
				+ ", pc_case=" + pc_case + "]";
	}
	
	
}
