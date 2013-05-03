
public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		if(numberString.contains(",")){
			int sum = 0;
			
			String[] rawNumbers = numberString.split(",");
			for (String rawNumber : rawNumbers) {
				sum += Integer.parseInt(rawNumber);
			}
			return sum;
		}else{
			return Integer.parseInt(numberString);
		}
	}

}
