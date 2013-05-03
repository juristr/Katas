import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		//;\n1;2
		String delimiter = ",";
		if(numberString.contains("//")){
			Pattern p = Pattern.compile("\\[(.*)\\]");
			Matcher m = p.matcher(numberString);
			if(m.find()){
				delimiter = m.group(0);
				delimiter = delimiter.replace("[", "").replace("]", "");
			}else{
				delimiter = numberString.substring(2, 3);	
			}			
			
			numberString = numberString.substring(numberString.indexOf("\n")+1);
		}
		
		//replace newlines to handle them the same way as a separator
		numberString = numberString.replace("\n", delimiter);
		
		if(numberString.contains(delimiter)){
			int sum = 0;
			ArrayList<Integer> negatives = new ArrayList<Integer>();
			
			StringTokenizer str = new StringTokenizer(numberString, delimiter);
			while(str.hasMoreTokens()){
				int number = Integer.parseInt(str.nextToken());
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
