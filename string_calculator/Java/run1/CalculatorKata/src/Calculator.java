import java.util.ArrayList;


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
			ArrayList<Integer> negatives = new ArrayList<Integer>();
			
			String[] rawNumbers = numberString.split(delimiter);
			for (String rawNumber : rawNumbers) {
				int number = Integer.parseInt(rawNumber);
				if(number < 0)
					negatives.add(number);
				
				if(number <= 1000) {
					sum += number;
				}
			}
			
			if(negatives.isEmpty() == false){
				throw new RuntimeException("Negatives not allowed: " + formatNegatives(negatives));
			}
			
			return sum;
		}else{
			return Integer.parseInt(numberString);
		}
	}

	private static String formatNegatives(ArrayList<Integer> negatives) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < negatives.size(); i++) {
			if(i < negatives.size() - 1)
				builder.append(negatives.get(i) + ", ");
			else
				builder.append(negatives.get(i));
		}

		return builder.toString();
	}

}
