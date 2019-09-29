package one.two.three.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	private int b_num;
	private String fitc_id;
	private String title;
	private String b_content;
	private String b_date;
	private int hit;
	private String pcset_cpu;
	private String pcset_ram;
	private String pcset_vga;
	private String pcset_pc_case;
}
