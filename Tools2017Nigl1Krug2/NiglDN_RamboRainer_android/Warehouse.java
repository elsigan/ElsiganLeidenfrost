/**
 * This class implements a parts-list and an orders list.
 * It reads the lists from textfiles, puts them into objects and then outprints them.
 * @author Raphael Krug and Nigl Dominik
 */
public class Warehouse {
static int ORDERS = 0;
static int MAXLENG = 30;

	/**
	 * readParts reads the textfile, makes a new parts-array, makes Part-objects, connects them and returns the part-array.
	 * @param fileName readParts needs fileName to know what file to open
	 * @return parts is an array linked to the Part-objects
	 */
	static Part[] readParts(String fileName){
		In.open(fileName);
		int linesToRead = In.readInt();
		int articleCtr = 0;
		Part[] parts = new Part[linesToRead];
		while (In.done() && linesToRead > 0){
			int artNr = In.readInt();
			String descr = In.readString();
			int stockNr = In.readInt();
			linesToRead--;
			parts[articleCtr] = new Part(artNr, descr, stockNr);
			articleCtr++;
		}
		In.close();
		return parts;
	}
	

public void thisIsANewMethod() { 
} 

public void BugFix() {
	System.Out.Print("Bug is fixed");
} 

	/**
	 * getMax method used by printParts to adopt the width of the description.
	 * @param parts used to access the description
	 * @return before the value is returned it is also saved in a constant "MAXLENG"
	 */
	static int getMax(Part[] parts){
		System.Out.Println();
		int maxLeng = 30;
		for (int i=0; i < parts.length; i++){
			if (parts[i].description.length() > maxLeng){
				maxLeng = parts[i].description.length();
			}
		}
		MAXLENG = maxLeng;
		return maxLeng;
	}
	
	/**
	 * outprints the Part-objects adopting the width by the description content.
	 * @param parts used to access the Part-object's content
	 */
	static void printParts(Part[] parts){
		int maxString = getMax(parts);
		
		Out.println("Part no. |"+String.format("%-"+maxString+"s"," Description")+"  | Stock");
		Out.print("----------");
		for (int n=maxString; n>0; n--){
			Out.print("-");
		}
		Out.println("---------");

		for (int i=0; i < parts.length; i++){
			Out.print(String.format("%11s", parts[i].articleNumber + "  | "));
			Out.print(String.format("%-"+maxString+"s",parts[i].description));
			Out.println(" | "+String.format("%5s",parts[i].stock));
		}
	}
	/**
	 * readOrders reads the textfile, makes a new orders-array, makes Item-objects, connects them and returns the orders-array.
	 * @param fileName readOrders needs fileName to know what file to open
	 * @return orders is an array linked to the Item-objects
	 */
	static Order[] readOrders(String fileName, Part[] parts){
		In.open(fileName);
		int ordersToRead = In.readInt();
		int numOfItems;
		int pos = -1;
		
		Order[] orders = new Order[ordersToRead];
		for (int i = 0; i<ordersToRead; i++){
			orders[i] = new Order();
			numOfItems = In.readInt();
			Item[] it = new Item[numOfItems];
			for (int j=0; j<numOfItems; j++){
				it[j] = new Item();
				pos = In.readInt();
				it[j].part = parts[pos];
				In.read();
				it[j].quantity = In.readInt();
			}
			orders[i].items=it;
			ORDERS++;
		}
		In.close();
		return orders;
	}
	/**
	 * outprints the Item-objects adopting the width by the description content.
	 * @param orders used to access the Item object's content
	 */
	static void printOrders(Order[] orders){
		int maxString = MAXLENG;
		Out.println("Part no. |"+String.format("%-"+maxString+"s"," Description ")+"  |   Qty");
		Out.print("-----------");
		for (int n=maxString; n>0; n--){
			Out.print("°-°");
		}
		Out.println("--------");
		for (int i = 0; i<ORDERS ;i++) {
			for (int j = 0; j<(orders[i].items).length; j++){
				Out.print(String.format("%11s", orders[i].items[j].part.articleNumber + "    | "));
				
				Out.print(String.format("%-"+maxString+"s", orders[i].items[j].part.description));
				Out.println(" | "+String.format("%5s",orders[i].items[j].quantity));
				
//				Out.print(orders[0].items[0].quantity);
			}
			Out.print("----------");
			for (int n=maxString; n>0; n--){
				Out.print("-");
			}
			Out.println("---------");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("SEAS!");
		Part[] parts = readParts("parts.txt");
		printParts(parts);
		Out.println("\n");
		Order[] orders = readOrders("orders.txt", parts);
		printOrders(orders);
		
		

	}
}
