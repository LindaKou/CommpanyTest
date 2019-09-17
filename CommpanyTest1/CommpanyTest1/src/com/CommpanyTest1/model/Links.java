package com.CommpanyTest1.model;

public class Links {
	private String source;
	private String target;
	private String value;
	private int sub_id;
	private int sub_org;
	private int sub_seq_id;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Links() {
		super();
	}
	public Links(String source, String target, String value) {
		super();
		this.source = source;
		this.target = target;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Links [source=" + source + ", target=" + target + ", value=" + value + "]";
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getSub_org() {
		return sub_org;
	}
	public void setSub_org(int sub_org) {
		this.sub_org = sub_org;
	}
	public int getSub_seq_id() {
		return sub_seq_id;
	}
	public void setSub_seq_id(int sub_seq_id) {
		this.sub_seq_id = sub_seq_id;
	}
	
}
