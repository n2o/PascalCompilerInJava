program fibonacci ; 
var a : integer ; 
var b: integer; 
var temp : integer ;
begin
	a := 1;
	b := 1;
	while (True and (a < 100))  do begin
		 writeln(a);
		temp := b;
		b := a + b;
		a := temp ;
		end
end .