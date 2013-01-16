program simple;
var f: boolean ; 
var c, b, a : integer;
begin
	a := 0;
	b := 600;
	f := a > b;
	while a < b do begin
		a := a -- (1+a);
		writeln(a);
	end;
	writeln(false);

end .