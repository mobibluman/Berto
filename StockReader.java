import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StockReader{

	public static void main(String[] args){
		String filename = "NASDAQ_AAPL.txt";          	//name of the file
		Stock[] AAPL = initializeStocks(filename);		//initialization of stock array for company
//		System.out.println("dank" + AAPL.length);
//		System.out.println(AAPL[2012]);
		
	}
	
	public static Stock[] initializeStocks(String filename){ //returns an array of stocks read from the file
		BufferedReader bReader = null;
		FileReader fReader = null;
		
		try {		// try catch for the buffered reader

			bReader = new BufferedReader(new FileReader(filename));
			int count = 0;
			String line;
			String tokens[];
			bReader.readLine();
			while ((line = bReader.readLine()) != null){ //opening a buffered reader to count the number of valid lines
				tokens = line.split(",");
				if(tokens.length == 7){
					count++;
				}
			}
			bReader.close();
			
			Stock[] stocks = new Stock[count];
			bReader = new BufferedReader(new FileReader(filename)); //second buffered reader in order to read and initialize the stock array
			bReader.readLine();
			count = 0;
			while ((line = bReader.readLine()) != null){
				tokens = line.split(",");							//tokenizing the string
				//<ticker>,<date>,<open>,<high>,<low>,<close>,<vol> -> constructor format
				if(tokens.length == 7){
					stocks[count] = new Stock(tokens[0], Long.parseLong(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]));
					System.out.println(stocks[count].toString() + "\n" + count + "\n");
					count++;
				}
			}
			return stocks;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
			return null;
		}
	}
}
	