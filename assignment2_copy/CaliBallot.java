/* CaliBallot.java 
 *
 * A program to sort candidates
   Jamie O'Roke, Jan31, 2023
*/
import java.nio.file.*; //This is the class for counting lines in a file
import java.io.File; //This is the class for opening and managing files
import java.io.FileNotFoundException; //This is a class to handle File related errors 
import java.io.IOException;
import java.util.*; //This class reads things, like text files

public class CaliBallot{
 	//"usage(String[] args)" handles the usage statement 
	public static boolean usage(String[] args){
		if(args.length < 3){
			System.out.println("Usage: java -cp .:algs4.jar CalliBallot sort_name sort_criteria input_file");
			System.out.println("where sort_name is Insertion or Selection");
			System.out.println("where sort_criteria is Default|FirstName|LastName");
			return true;
		}
		System.out.println("my args are: " + args[0] + ", " + args[1] +  ", " + args[2]);
		return false;
	}
	//"bad_input(String[] args)" handles typos,  it does account for improper uppercase letters
	public static boolean bad_input(String[] args){
		String sort_name = args[0].toLowerCase();
		String sort_type = args[1].toLowerCase();
		File file_name = new File(args[2]);

		if((!"selection".equals(sort_name)) && (!"insertion".equals(sort_name))){
			System.out.println("sort_name must be \"Selection\" or \"Insertion\"");
			return true;
		}
		if((!"default".equals(sort_type)) && (!"firstname".equals(sort_type)) && (!"lastname".equals(sort_type))){
			System.out.println("sort_criteria must be \"Default\" or \"FirstName\" or \"LastName\"");
			return true;
		}
		if(!file_name.exists()){
			System.out.println(args[2] + ": file not found in current directory.");
			return true;
		}
		return false;
	}
//------------------------------- Main function for entire program --------------------------------
	public static void main(String[] args) {
	
		if(usage(args)) return;
		if(bad_input(args)) return;

		System.out.println("\n");

		String file_name = args[2];
		Clist candidate_list = new Clist(file_name);	
		candidate_list.fill_array(file_name);

		System.out.println("Sort name: " + args[0]);
		System.out.println("Sort criteria: " + args[1]);
		System.out.println("sort order (if not by age): " + candidate_list.get_sort_order());
		System.out.println("\n\n");

		//Uncomment the two lines below to see the unsorted list
		//System.out.println("Unsorted:");
		//System.out.println(candidate_list.toString());

		Stopwatch timer = new Stopwatch();
		candidate_list.sort_by(args[0], args[1]);
		double click = timer.elapsedTime();


		System.out.println(candidate_list.toString());
		System.out.println("Time: " + click);
		//System.out.println("there are: " + number_of_candidates + " in " + file_name);
	}

}

