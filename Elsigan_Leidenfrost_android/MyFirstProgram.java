
public class MyFirstProgram {
	public static void main(String[]args) {
		int numberOfOutputs;                                  //Das Programm fragt den User, welche Anzahl an Textoutputs die: "Output number
		Out.println("Please enter the number of outputs ");   //*Anzahl die vorher angegeben wurde*: Hello World!" lauten, in einer neuen Zeile
		numberOfOutputs = In.readInt();                       //ausgegeben werden sollen. Durch die Behebung einiger Syntax-Fehler und ersetzen
		for (int i= 1; i <= numberOfOutputs; i++) {           //eines "kleiner als" durch "kleiner gleich" wurde das Programm wieder funktionstüchtig gemacht.
			Out.print("Output number ");
			Out.print(i);
			Out.println(": Hello World!");
			Out.println("SEAS!");
		} //for
	}
	
	public void thisIsAnewMethod(){
		int i=10; //change of member 2
		
	}
	
	//main
}//MyFirstProgram
