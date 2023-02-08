/* Candidate.java
 * By: Jamie O'Roke
 * An ADT (Abstract Data Type) of type "Candidate"
 *
 */

public class Candidate implements Comparable<Candidate> {

	private String first_name;
	private String last_name;
	private int age;
	private String party;

	Candidate(){ // this is the constructor with nothing in the parameters 
		age = 0;
		first_name = null;
		last_name = null;
		party = null;
	}
	//Function housing all the setters.
	public void fill_up(String first, String last, String new_age, String new_party){
		first_name = first.trim();
		last_name = last.trim();
		age = Integer.parseInt(new_age.trim());
		party = new_party.trim();
	}
	//Here are the setters and getters.
	public void set_age(int new_age){
		age = new_age;
	}
	public void set_name(String new_first, String new_last){
		first_name = new_first;
		last_name = new_last;
	}
	public void set_party(String new_party){
		party = new_party;
	}
	public String get_first_name(){
		return first_name;
	}
	public String get_last_name(){
		return last_name;
	}
	public boolean equals(Candidate that){
		if(age != that.age) return false;
		if(first_name != that.first_name) return false;
		if(last_name != that.last_name) return false;
		if(party != that.party) return false;
		return true;
	}
	//This function overrides the predefined "compareTo" function from Comparable
	@Override
	public int compareTo(Candidate that){
		if(age > that.age) return 1;
		else if(age < that.age) return -1;
		else{
			if(first_name.compareTo(that.first_name) > 0) return 1;
			else if(first_name.compareTo(that.first_name) < 0) return -1;
			else return 0;
		}	
	}
	@Override
	public String toString(){
		return first_name + " " + last_name + "," + age + ", " + party;
	}

	
}
