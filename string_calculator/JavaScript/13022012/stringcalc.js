var StringCalculator = function(){};

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

	var negatives = [];

	for(var i=0; i < splitted.length; i++){
		var num = parseInt(splitted[i]);
		if(num < 0){
			negatives.push(num);
		}
		sum += num;
	}

	if(negatives.length > 0){
		throw { message: "Negatives not allowed: " + negatives.join(", ")};
	}

	return sum;
};