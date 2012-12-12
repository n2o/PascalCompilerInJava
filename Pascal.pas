program fibonacci; 
var a : integer; 
var b: integer; 
var temp : integer ; 
var c : boolean;

begin

//if 2=2 and not 2<>2 then writeln(1);
//	c := true = 1<2;
	a := 1;
	b := 1;
	while True do 
	begin 
		writeln(a);
		temp := -b;
		b := a + b;
		a := temp;
	end
end.