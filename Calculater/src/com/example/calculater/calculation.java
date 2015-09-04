package com.example.calculater;

public class calculation {
	
	
	private double value1;
	private double value2;
	private double answer;
	
	
	
	public calculation() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void add(){
		answer=value1+value2;
		
	}
	
	public void sub(){
		answer=value1-value2;
		
	}
	public void multiply(){
		answer=value1*value2;
		
	}
	public void divison(){
		answer=value1/value2;
		
	}
	
	public double getValue1() {
		return value1;
	}
	public void setValue1(double value1) {
		this.value1 =  value1;
	}
	public double getValue2() {
		return value2;
	}
	public void setValue2(double value2) {
		this.value2 = value2;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
	

}
