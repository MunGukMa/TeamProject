package parshing;

public class PowerVO {
	String name;
	String price;
	String power;
	String output;
	String fanSize;
	String fanNum;
	String atx;
	String sata;
	String connecter;
	String etc;
	String releaseDate;
	
	
	public PowerVO() {

	}

	public PowerVO(String name, String price, String power, String output, String fanSize, String fanNum, String atx,
			String sata, String connecter, String etc, String releaseDate) {
		super();
		this.name = name;
		this.price = price;
		this.power = power;
		this.output = output;
		this.fanSize = fanSize;
		this.fanNum = fanNum;
		this.atx = atx;
		this.sata = sata;
		this.connecter = connecter;
		this.etc = etc;
		this.releaseDate = releaseDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getFanSize() {
		return fanSize;
	}

	public void setFanSize(String fanSize) {
		this.fanSize = fanSize;
	}

	public String getFanNum() {
		return fanNum;
	}

	public void setFanNum(String fanNum) {
		this.fanNum = fanNum;
	}

	public String getAtx() {
		return atx;
	}

	public void setAtx(String atx) {
		this.atx = atx;
	}

	public String getSata() {
		return sata;
	}

	public void setSata(String sata) {
		this.sata = sata;
	}

	public String getConnecter() {
		return connecter;
	}

	public void setConnecter(String connecter) {
		this.connecter = connecter;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return String.format(
				"name=%s , price=%s , power=%s , output=%s , fanSize=%s , fanNum=%s , atx=%s , sata=%s , connecter=%s , etc=%s , releaseDate=%s",
				name, price, power, output, fanSize, fanNum, atx, sata, connecter, etc, releaseDate);
	}
}
