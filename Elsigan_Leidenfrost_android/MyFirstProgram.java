import java.io.IOException;

public class MyFirstProgram {
	public static void main(String[]args) throws IOException {
		int numberOfOutputs;                                  //Das Programm fragt den User, welche Anzahl an Textoutputs die: "Output number
		System.out.println("Please enter the number of outputs ");   //*Anzahl die vorher angegeben wurde*: Hello World!" lauten, in einer neuen Zeile
		numberOfOutputs = System.in.read();                       //ausgegeben werden sollen. Durch die Behebung einiger Syntax-Fehler und ersetzen
		for (int i= 1; i <= numberOfOutputs; i++) {           //eines "kleiner als" durch "kleiner gleich" wurde das Programm wieder funktionstüchtig gemacht.
			System.out.print("Output number ");
			System.out.print(i);
			System.out.println(": Hello World!");
			System.out.println("SEAS!");
		} //for
	}
	
	public void thisIsAnewMethod(){
		
		System.out.print("This is a new line!");
		int i=10; //change of member 2
		System.out.print("Change");
		
		int a = 10000; //change of member 1
		
	}
	
	//main
}//MyFirstProgram
