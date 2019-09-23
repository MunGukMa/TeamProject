package parshing;

public class ParsingVO 
{
	String name;
	String csocket;
	String cprocess;
	String core;
	String thread;
	String clock;
	String l2memory;
	String l3memory;
	String bit;
	String power;
	String ddrtype;
	String ingraphic;
	String corespeed;
	String more;
	
	public ParsingVO() {
		// TODO Auto-generated constructor stub
	}

	public ParsingVO(String name, String csocket, String cprocess, String core, String thread, String clock,
			String l2memory, String l3memory, String bit, String power, String ddrtype, String ingraphic,
			String corespeed, String more) {
		super();
		this.name = name;
		this.csocket = csocket;
		this.cprocess = cprocess;
		this.core = core;
		this.thread = thread;
		this.clock = clock;
		this.l2memory = l2memory;
		this.l3memory = l3memory;
		this.bit = bit;
		this.power = power;
		this.ddrtype = ddrtype;
		this.ingraphic = ingraphic;
		this.corespeed = corespeed;
		this.more = more;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCsocket() {
		return csocket;
	}

	public void setCsocket(String csocket) {
		this.csocket = csocket;
	}

	public String getCprocess() {
		return cprocess;
	}

	public void setCprocess(String cprocess) {
		this.cprocess = cprocess;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	public String getL2memory() {
		return l2memory;
	}

	public void setL2memory(String l2memory) {
		this.l2memory = l2memory;
	}

	public String getL3memory() {
		return l3memory;
	}

	public void setL3memory(String l3memory) {
		this.l3memory = l3memory;
	}

	public String getBit() {
		return bit;
	}

	public void setBit(String bit) {
		this.bit = bit;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getDdrtype() {
		return ddrtype;
	}

	public void setDdrtype(String ddrtype) {
		this.ddrtype = ddrtype;
	}

	public String getIngraphic() {
		return ingraphic;
	}

	public void setIngraphic(String ingraphic) {
		this.ingraphic = ingraphic;
	}

	public String getCorespeed() {
		return corespeed;
	}

	public void setCorespeed(String corespeed) {
		this.corespeed = corespeed;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	@Override
	public String toString() {
		return "ParsingVO [name=" + name + ", csocket=" + csocket + ", cprocess=" + cprocess + ", core=" + core
				+ ", thread=" + thread + ", clock=" + clock + ", l2memory=" + l2memory + ", l3memory=" + l3memory
				+ ", bit=" + bit + ", power=" + power + ", ddrtype=" + ddrtype + ", ingraphic=" + ingraphic
				+ ", corespeed=" + corespeed + ", more=" + more + "]";
	}

	
	
}
