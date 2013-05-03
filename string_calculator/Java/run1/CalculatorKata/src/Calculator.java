
public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		//;\n1;2
		String delimiter = ",";
		if(numberString.contains("//")){
			delimiter = numberString.substring(2, 3);
			numberString = numberString.substring(4);
		}
		
		//replace newlines to handle them the same way as a separator
		numberString = numberString.replace("\n", delimiter);
		
		if(numberString.contains(delimiter)){
			int sum = 0;
			
			String[] rawNumbers = numberString.split(delimiter);
			for (String rawNumber : rawNumbers) {
				sum += Integer.parseInt(rawNumber);
			}
			return sum;
		}else{
			return Integer.parseInt(numberString);
		}
	}

}
