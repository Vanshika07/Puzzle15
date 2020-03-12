package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Input {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s;
	private String inp;
	private long t;
	
	public Input(String inp, long t) {
		super();
		this.inp = inp;
		System.out.println(inp);
		System.out.println(this.inp);
		this.t = t;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public String getInp() {
		return inp;
	}
	public void setInp(String inp) {
		this.inp = inp;
	}
	public long getT() {
		return t;
	}
	public void setT(long t) {
		this.t = t;
	}
	

}
