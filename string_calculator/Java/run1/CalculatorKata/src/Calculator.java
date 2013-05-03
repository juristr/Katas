
public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		//replace newlines to handle them the same way as a separator
		numberString = numberString.replace("\n", ",");
		
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
