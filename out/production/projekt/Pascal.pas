program fibonacci;;
var a : integer; 
var b,D: integer; 
var temp : integer; 
begin
a := 1;
b := 1;
a := b;
while a < 100 do 
	begin 
		writeln(a);
		temp := b;
		b := a + b;
		a := temp ;
		if a > 34 then break else writeln(0);
	end;
writeln(10)
end.