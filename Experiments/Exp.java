package Experiments;

public class Exp<E> {
	
	public E entity;
	
	public Exp(E data){
		entity = data;
	}
	
	public static void main(String[] args){
		Exp<String> exp = new Exp<String>("Hello");
		System.out.println(exp.entity);
	}
}
