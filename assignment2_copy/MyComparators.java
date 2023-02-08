//This file contains Comparator classes FirstName and LastName 
import java.util.Comparator;
//import java.util.Math;
//The "StringComparator" example I found for implementation/algorithm purposes 
//was from https://algs4.princeton.edu/25applications/California.java.html
//------------------------------------------------------------------------------------
//Below are my implementations of the same functionality but for Candidates 
class FirstNameComparator implements Comparator<Candidate>{
	private String sort_order;
	FirstNameComparator(String order){
		sort_order = order.trim();
		sort_order = sort_order.toLowerCase();
	}
	@Override
	public int compare(Candidate a, Candidate b){
		//logic goes here
		int len = Math.min(a.get_first_name().length(), b.get_first_name().length());
		for(int i = 0; i < len; i++){
			int a_index = sort_order.indexOf(a.get_first_name().charAt(i));
			int b_index = sort_order.indexOf(b.get_first_name().charAt(i));
			if(a_index < b_index) return -1;
			else if (a_index > b_index) return 1;
		}		
		return a.compareTo(b);
	}
}
class LastNameComparator implements Comparator<Candidate>{
	private String sort_order;
	LastNameComparator(String order){
		sort_order = order.trim();
		sort_order = sort_order.toLowerCase();
	}
	@Override
	public int compare(Candidate a, Candidate b){
		//logic goes here
		int len = Math.min(a.get_last_name().length(), b.get_last_name().length());
		for(int i = 0; i < len; i++){
			int a_index = sort_order.indexOf(a.get_last_name().charAt(i));
			int b_index = sort_order.indexOf(b.get_last_name().charAt(i));
			if(a_index < b_index) return -1;
			else if (a_index > b_index) return 1;
		}		
		return a.compareTo(b);
	}
}
