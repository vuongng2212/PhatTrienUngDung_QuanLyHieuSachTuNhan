package entity;

import java.awt.Font;

public class Country {
	private String id;
	private String name;
	private Font font;
	
	
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country(String id, String name,Font font) {
		super();
		this.id = id;
		this.font=font;
		this.name = name;
	}
	
	public Country() {
		super();
	}
	
}
