var StringCalculator = function(){
};

StringCalculator.prototype.add = function(numbers){
	if(numbers === undefined || numbers === null || numbers === "")
		return 0;

	var delimiter = ",";
	if(numbers.indexOf("//") > -1){
		delimiter = numbers.substr(2,1);
		numbers = numbers.substr(3);	
	}

	numbers = numbers.replace(/\n/g, delimiter);

	var sum = 0;
	var splitted = numbers.split(delimiter);
	for(var i=0; i < splitted.length; i++){
		var num = parseInt(splitted[i]);
		sum += num;
	}

	return sum;
};