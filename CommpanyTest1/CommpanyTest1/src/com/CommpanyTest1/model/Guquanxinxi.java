package com.CommpanyTest1.model;

public class Guquanxinxi {
	private String gudongming;//�ɶ�����
	private String guquanbili;//��Ȩ����
	private String renjiaojinge;//�Ͻɽ��
	public String getGudongming() {
		return gudongming;
	}
	public void setGudongming(String gudongming) {
		this.gudongming = gudongming;
	}
	public String getGuquanbili() {
		return guquanbili;
	}
	public void setGuquanbili(String guquanbili) {
		this.guquanbili = guquanbili;
	}
	public String getRenjiaojinge() {
		return renjiaojinge;
	}
	public void setRenjiaojinge(String renjiaojinge) {
		this.renjiaojinge = renjiaojinge;
	}
	public Guquanxinxi() {
		super();
	}
	public Guquanxinxi(String gudongming, String guquanbili, String renjiaojinge) {
		super();
		this.gudongming = gudongming;
		this.guquanbili = guquanbili;
		this.renjiaojinge = renjiaojinge;
	}
	@Override
	public String toString() {
		return "Guquanxinxi [gudongming=" + gudongming + ", guquanbili=" + guquanbili + ", renjiaojinge=" + renjiaojinge
				+ "]";
	}
	
}
