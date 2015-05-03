import java.util.ArrayList;
import java.util.Set;


public class executeMain {
	static Quaries query;
	
	public static void main(String[] args){
	//Adding all the persons
	People Nancy = new People("Nancy");
	People Adam = new People("Adam");
	People Jill = new People("Jill");
	People Carl = new People("Carl");
	People Kevin = new People("Kevin");	
	People Catherine = new People("Catherine");
	People Joseph = new People("Joseph");
	People Aaron = new People("Aaron");
	People James = new People("James");
	People George = new People("George");
	People Samuel = new People("Samuel");
	People Mary = new People("Mary");
	People Patrick = new People("Patrick");
	People Robert = new People("Robert");
	
	Nancy.addChild(Adam);
	Nancy.addChild(Jill);
	Nancy.addChild(Carl);
	Jill.addChild(Kevin);	
	Carl.addChild(Catherine);
	Carl.addChild(Joseph);	
	Kevin.addChild(Samuel);
	Kevin.addChild(George);
	Kevin.addChild(James);
	Kevin.addChild(Aaron);
	James.addChild(Mary);
	George.addChild(Patrick);
	George.addChild(Robert);
	
	ArrayList<People> test = new ArrayList<>();
	test.add(Nancy);
	test.add(Adam);
	test.add(Jill);
	test.add(Carl);
	test.add(Kevin);
	test.add(Catherine);
	test.add(Joseph);
	test.add(Aaron);
	test.add(James);
	test.add(George);
	test.add(Samuel);
	test.add(Mary);
	test.add(Patrick);
	test.add(Robert);
	
	System.out.println("Kevin's Grand parent is: "+query.getGradPa(Kevin));
	System.out.println("People with no sibling's is: "+query.getpeopleWithNoSiblings(test));
	System.out.println("People with no children is: "+query.getpeopleWithNoChildren(test));	
    System.out.println("Peolpe with larger number of grand children is: "+query.MaxgrandChildList(test));
	//System.out.println(Adam.getAllGrandChildren());
	}

	

}
