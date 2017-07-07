import java.util.Date;

public class Stock{
	

		//fields
		private long date;

		private String symbol;
		private double open;
		private double high;
		private double low;
		private double close;
		private int volume;
		
		//constructor
		
		public Stock(String sym, long dat, double opening, double highest, double lowest, double closing, int vol){
			date = dat;
			symbol = sym;
			open = opening;
			high = highest;
			low = lowest;
			close = closing;
			volume = vol;
		}

		//methods
	
		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public void setDate(long date) {
			this.date = date;
		}

		public void setOpen(double open) {
			this.open = open;
		}

		public void setHigh(double high) {
			this.high = high;
		}

		public void setLow(double low) {
			this.low = low;
		}

		public void setClose(double close) {
			this.close = close;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}

		public long getDate(){
			return date;
		}

		public double getOpen(){
			return open;
		}
		public double getHigh(){
			return high;
		}
		public double getLow(){
			return low;
		}
		public double getClose(){
			return close;
		}
		public int getVolume(){
			return volume;
		}
		
		public String toString(){
			return    "Date:   " + date +
					"\nOpen:   " + open +
					"\nHigh:   " + high +
					"\nLow:    " + low +
					"\nClose:  " + close +
					"\nVolume: " + volume;
		}
}