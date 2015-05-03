

import java.util.HashSet;
import java.util.Set;

public class People
{
  String name; 
  
  Set<People> siblings;
  Set<People> children;  
  Set<People> parents;
  
  public People(String name){
    this.name = name;
  }
  
  
  public People()
  {
  }  
 
  
  private void setParents(Set<People> parent){
    this.parents = parent;
  }
  
  private void setChildren(Set<People> children)
  {
    this.children = children;
    
  }
 
  public void addParent(People parent){
    if(null != parents) {
      if(!isPersonAlreadyListed(parents, parent)){
        parents.add(parent);
      }else{
        return;
      }
    }else{
      parents = new HashSet<People>();
      parents.add(parent);
    }
    
    Set<People> tempSiblings = getSiblings();
    if(null != tempSiblings)
      for(People sib:tempSiblings){
        sib.addParent(parent);
      }
    
    parent.addChild(this);    
    
  }

  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  } 
 
  //get parent name
  public Set<People> getParents(){
   return parents; 
  }
  
  public Set<People> getGrandParent(){
	 
	  People temp = null ;		
		  for(People per:parents){
			  temp =per;
			  break;
		  }
	
	   return temp.getParents(); 
	  }
  
  //check whether people already added
  private boolean isPersonAlreadyListed(Set<People> relations,People person)
  {
    boolean isAdded = false;
    for(People per:relations){
      if(per.equals(person)){
        isAdded = true;
        break;
      }
    }
    return isAdded;
  }
  
  
 //add a child of a person
  public void addChild(People person){
    if(null != children){
      if(!isPersonAlreadyListed(children, person)){
        children.add(person);
      }else{
        return;
      }
    }else{
      children = new HashSet<People>();
      children.add(person);
    }

    person.addParent(this);   
    
  }
  
  public Set<People> getSiblings(){
    return siblings;
  }  
 
  
  public Set<People> getChildren(){
    return children;
  }
  
  //count how many grand children a person has
  public int getGrandChildrenCount(){
	  int count=0;
	  if(children==null|| children.isEmpty())
		  return 0;
	  for(People per:children){	
		  if(per.getChildren()==null || per.getChildren().isEmpty())
			  continue;
		 // System.out.println("grand children: "+per.getChildren());
	    for(People local:per.getChildren()){
	    	count++;
	    }
	  }
	    return count;
	  }
 
  
  
  @Override
  public String toString()
  {
    if(null != getName()){
      return getName();
    }
    return super.toString();
  }
}