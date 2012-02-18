module("StringCalculator", {
	setup: function(){
		this.calculator = new StringCalculator();
	},

	teardown: function(){
		delete this.calculator;
	}
});

test("Invoking the calculator with the new operator should create a new object", function(){
	expect(1);
	
	ok(this.calculator);
});

test("Should return 0 when passing an empty string", function(){
	expect(1);

	var result = this.calculator.add("");
	same(0, result);
});

test("Should return 0 when passing null", function(){
	expect(1);
	var result = this.calculator.add(null);
	same(0, result);
});

test("Should return 0 when passing no arguments", function(){
	expect(1);
	var result = this.calculator.add();

	same(0, result);
});

test("Should return 1 when passing 1", function(){
	expect(1);

	var result = this.calculator.add("1");
	same(1, result);
})

test("Should return 2 when passing 2", function(){
	expect(1);

	var result = this.calculator.add("2");
	same(2, result);
});

test("Should return 3 when passing '1,2'", function(){
	expect(1);

	same(3, this.calculator.add("1,2"));
});

test("Should return 6 when passing '1,3,2'", function(){
	expect(1);

	same(6, this.calculator.add("1,3,2"));
});

test("Should return 3 when passing '1\n2'", function(){
	expect(1);

	same(3, this.calculator.add("1\n2"));
});

test("Should return 4 when passing '1\n2\n1'", function(){
	expect(1);

	same(4, this.calculator.add("1\n2\n1"));
});

test("Should return 4 when passing '//;1;3'", function(){
	expect(1);

	same(4, this.calculator.add("//;1;3"));
});

test("Should return 6 when passing '//:2:3;1'", function(){
	expect(1);

	same(6, this.calculator.add("//:2:3:1"));
});

test("Should throw exception when passing '-1'", function(){
	expect(1);

	try{
		this.calculator.add("-1");
	}catch(e){
		same("Negatives not allowed: -1", e.message);
	}
});

test("Should throw exception when passing negatives and list all of them in the message", function(){
	expect(1);

	try{
		this.calculator.add("-1, 4, -2");
	}catch(e){
		same("Negatives not allowed: -1, -2", e.message);
	}
});

