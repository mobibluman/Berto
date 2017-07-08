import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockReader{

	public static void main(String[] args){
		String filename = "NASDAQ_AAPL.txt";          	//name of the file
		List<Stock> AAPL = initializeStocks(filename);		//initialization of stock array for company
		System.out.println(AAPL.get(14).toString()); 		//Example to access 15th element of the list
		
	}
	
	public static List<Stock> initializeStocks(String filename){ //returns an array of stocks read from the file
		BufferedReader bReader = null;
		FileReader fReader = null;
		
		try {		// try catch for the buffered reader

			bReader = new BufferedReader(new FileReader(filename));
			String line;
			String tokens[];
			bReader.readLine(); //remove header line
			List<Stock> temps = new ArrayList<Stock>();  //list to hold each stock
			
			while ((line = bReader.readLine()) != null){ //opening a buffered reader to count the number of valid lines
				tokens = line.split(",");
				if(tokens.length == 7){  //checking the line is valid
					temps.add(new Stock(tokens[0], Long.parseLong(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6])));
				}						// adding to the list
			}
			bReader.close();
			
			for(Stock s : temps){ 					//printing out each stock for checking
				System.out.println(s.toString());
			}
			
			return temps;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
			return null;
		}
	}
}
	