program fibonacci; 
var a : integer; 
var b: integer; 
var temp : integer; 

{evil 
comment!!!!}

begin
	a := 1;
	b := 1;
	// Bombe!
	while True do 
	begin writeln(a);
		temp := b;
		b := a + b;
		a := temp ;
	end
end.