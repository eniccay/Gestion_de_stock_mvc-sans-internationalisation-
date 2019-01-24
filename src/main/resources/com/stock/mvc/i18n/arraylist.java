//declaration d'une collection
List<String> l1= new Arraylist<String>();
//remplisage d'une collection
l1.add("yassine");
l1.add("hlamnache");
l1.add("fatima");
l1.add("el houbbadi");
//le parcourire de cette liste
for( String s = l1){


system.out.printl("s");

}

//trie une collection 

Collections.sort(l1);
//affichage de la liste trie

system.out.printl(l1);

//ou bien 


// Java program to demonstrate working of ArrayList in Java 
import java.io.*; 
import java.util.*; 
  
class arrayli 
{ 
    public static void main(String[] args) 
                       throws IOException 
    { 
        // size of ArrayList 
        int n = 5; 
  
        //declaring ArrayList with initial size n 
        ArrayList<Integer> arrli = new ArrayList<Integer>(n); 
  
        // Appending the new element at the end of the list 
        for (int i=1; i<=n; i++) 
            arrli.add(i); 
  
        // Printing elements 
        System.out.println(arrli); 
  
        // Remove element at index 3 
        arrli.remove(3); 
  
        // Displaying ArrayList after deletion 
        System.out.println(arrli); 
  
        // Printing elements one by one 
        for (int i=0; i<arrli.size(); i++) 
            System.out.print(arrli.get(i)+" "); 
    } 
}