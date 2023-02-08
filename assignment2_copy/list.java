// Making a list to hold an array of characters
import java.nio.file.*; //This is the class for counting lines in a file
import java.io.File; //This is the class for opening and managing files
import java.io.FileNotFoundException; //This is a class to handle File related errors 
import java.io.IOException; //This is a class to handle I/O related errors
import java.util.*; //This class reads things, like text files

class Clist{

	private Candidate [] candidate_list; 
	private String sort_order;
	
	Clist(String file_name){
		int number_of_candidates = check_count(file_name);
		candidate_list = new Candidate[number_of_candidates];
	}

	public void fill_array(String file_name) {
		try{
			Scanner my_reader = new Scanner(new File(file_name)); //combining new Scanner and new File
			my_reader.useDelimiter(",");
			sort_order = my_reader.nextLine();//Skipping first line
			my_reader.nextLine();//Skipping second line, these are skipped because they arent candidates
			int i = 0;
			String first, last, age, party;
			while(my_reader.hasNext()){
				first = my_reader.next();
				last = my_reader.next();
				age = my_reader.next();  //Age is read as string, then trimmed and converted in candidate
				party = my_reader.nextLine();
				party = party.replaceAll(",","");	
				party = party.trim();
			    //These lines are where I get the NullExeption
				candidate_list[i] = new Candidate();
				candidate_list[i].fill_up(first, last, age, party);
				i++;
				//System.out.println(candidate_list[i].toString());
				//System.out.println(first + " -- " + last + " -- " + age + " -- " + party);
			}

			my_reader.close();
		}catch (FileNotFoundException e){
			System.out.println("an error ocurred.");
			e.printStackTrace();
		}
	}

	public int count_candidates_in(String file_name) throws IOException {
		Path file_path = Path.of(file_name);
		int line_count = (int)Files.lines(file_path).count();
		return line_count - 2; // the -2 is to account for the first two lines, which are not candidates
	}

	//"check_count(String file_name)" handles errors for "count_candidates_in(String file_name)" function
	public int check_count(String file_name) {
		int line_count = 0;
		try{
			line_count = count_candidates_in(file_name);
		}catch(IOException e){
			e.printStackTrace();
		}
		return line_count;
	}
	//The 2 methods below, "toString()" and "print_list()", do the same thing, except toString() overrides java's toString()
	@Override
	public String toString(){
		for(int i = 0; i < candidate_list.length; i++){
			System.out.println(candidate_list[i].toString());
		}
		return "";
	}
	public void print_list(){
		for(int i = 0; i < candidate_list.length; i++){
			System.out.println(candidate_list[i].toString());
		}
	}
	//"print_index(int)" prints only the desired index of the list	
	public String print_index(int i){
		return candidate_list[i].toString();
	}	
	public String get_sort_order(){
		return sort_order;
	}
	//"sort_by(string)" takes the desired sort type and kickstarts the correlating sort method
	public void sort_by(String sort_name, String sort_type){
		sort_type = sort_type.toLowerCase();
		if(sort_type.equals("default") || sort_type.equals("age")) age_sort(sort_name);	
		else if(sort_type.equals("firstname")) first_name_sort();	
		else if(sort_type.equals("lastname")) last_name_sort();	
		else System.out.println("Sort Type not recognized...");
	}
	//"age_sort()", "first_name_sort()", and "last_name_sort()" are the sort methods
	public void age_sort(String sort_name){
		sort_name = sort_name.toLowerCase();
		System.out.println("Sorting by age:");
		Arrays.sort(candidate_list);
	}
	public void first_name_sort(){
		System.out.println("Sorting by first name:");
		Comparator<Candidate> candidate_order = new FirstNameComparator(sort_order);
		Arrays.sort(candidate_list, candidate_order);
	}
	public void last_name_sort(){
		System.out.println("Sorting by last name:");
		Comparator<Candidate> candidate_order = new LastNameComparator(sort_order);
		Arrays.sort(candidate_list, candidate_order);

	}
}
