
public class Puppy {

	
	//This is intended to include character properties- ( in this example the character is Millie the labradoodle )
	 int weight=22;
	 String name="Millie";
	 String breed="labradoodle";
	 double age=1.5;
	 
	 public Puppy (int weight, String name, String breed, double age){
	 	this.name = name;
	 	this.weight = weight;
	 	this.breed = breed;
	 	this.age = age;
	 }
	 
	 public String getname (){
		 return this. name;
	 }
	 public void setname (String newname){
	this.name=newname;
	 }
	 
	 
	 
	 public int getweight (){
		 return this. weight;
	 }
	 public String getbreed (){
		 return this. breed;
	 }
	 public double getage (){
		 return this. age;
	 }
	 
}

// This code is very incomplete- do not run it and expect it to work or do anything at all