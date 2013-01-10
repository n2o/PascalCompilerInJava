program factorial;
var fak, res : integer;
begin
	fak := 5;
	res := 1;
	while fak > 0 do
		begin
			res := res * fak;
			fak := fak - 1;
		end;
	writeln(res);
end.