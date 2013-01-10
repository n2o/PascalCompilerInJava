program parenthesis;
var a,c,b : integer;
begin
	a := 1;
	b := a;
	c := b+a;

	while a < 10 do
		begin
			a := a+1;
			while b < 10 do
				b := b+1;
				begin
					while c < 10 do
						begin
							writeln(c);
							break;
							writeln(111111);
						end;
					break;
					writeln(222222);
				end;
			break;
			writeln(333333);
		end
	writeln(999999);
end.