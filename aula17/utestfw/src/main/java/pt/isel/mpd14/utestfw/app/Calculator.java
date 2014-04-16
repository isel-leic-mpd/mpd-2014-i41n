package pt.isel.mpd14.utestfw.app;

public class Calculator {
	
	public int sum(Integer...args){
		int res = 0;
		for (int i = 0; i < args.length; i++) {
			res += args[i];
		}
		return res;
	}
	public int add(Integer x, Integer y){
		return x + y;
	}
	public int sub(Integer x, Integer y){
		return x - y;
	}
	public int div(Integer i, Integer j) {
		return i/j;
	}
}
