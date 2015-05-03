import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class Quaries {
	//get persons with no children
	 public static ArrayList<People> getpeopleWithNoChildren(ArrayList<People> input){
		  ArrayList<People> output = new ArrayList<People>() ;
		
		  for(People per:input){	
			 // System.out.println(per);
			  if( per.getChildren()==null)	
				  output.add(per);
			 
		  }
		  return output;
	  }
	//get persons with no siblings
	 public static ArrayList<People> getpeopleWithNoSiblings(ArrayList<People> input){
		  ArrayList<People> output = new ArrayList<People>();
		
		  for(People per:input){	
			 
			  if(getAllSiblings(per)==null)	
			  {
				  output.add(per);
				  continue;
			  }
			 
			  int count =0;
			  for(People local:getAllSiblings(per)){	
				   count++;				   				   
			  }
			 // System.out.println(per+" count: "+count);
			  if (count<=1)
			  {
			  output.add(per);
			  count =0;
			  }
			  
		  }
		  return output;
	  }
	//get All the siblings of a person
	 public static Set<People> getAllSiblings(People input){
		 if(input.getParents()==null)
			 return null;
		  Set<People> temp = input.getParents();	
		  People paren = null;
		  for(People per:temp){	
			   paren = per;
			   break;			  
		  }
		  Set<People> result = paren.getChildren();		 
		    return result;
		  }
	 //Get grand parent name
	 public static String getGradPa(People name)
	 {
		
		 return name.getGrandParent().toString();
	 }
	//Get person having max grand children
	 public static String MaxgrandChildList(ArrayList<People> input)
	 {
		
		 String output="";
		 HashMap<String, Integer> Hm = new HashMap<>();
 		  for(People per:input){	
 			 //System.out.println("input is: "+per);
			 Hm.put(per.toString(),per.getGrandChildrenCount());
			 
		  }
 		
 		 int maxValueInMap=(Collections.max(Hm.values()));  // This will return max value in the Hashmap
         for (Entry<String, Integer> entry : Hm.entrySet()) {  // Itrate through hashmap
             if (entry.getValue()==maxValueInMap) {
               //  System.out.println(entry.getKey());
                 output =entry.getKey(); // Print the key with max value
             }
         }
		 return output;
	 }

}
