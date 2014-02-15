program Fibonacci;
var a, b, temp : integer;
begin
	a := 1;
	b := 1;
	i := 10;
	while a < i do
	begin
		writeln(a);
		temp := b;
		b := a+b;
		a := temp;
	end
end.