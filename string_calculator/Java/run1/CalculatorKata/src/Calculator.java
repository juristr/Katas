
public class Calculator {

	public int add(String numberString) {
		if(numberString == null || numberString == "")
			return 0;
		
		return Integer.parseInt(numberString);
	}

}
