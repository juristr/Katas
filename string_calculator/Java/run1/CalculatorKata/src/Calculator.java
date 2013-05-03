
public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		if(numberString.contains(",")){
			String[] rawNumbers = numberString.split(",");
			return Integer.parseInt(rawNumbers[0]) + Integer.parseInt(rawNumbers[1]);			
		}else{
			return Integer.parseInt(numberString);
		}
	}

}
