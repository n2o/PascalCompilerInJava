program simple;
var f: boolean ; 
var c, b, a : integer;
begin
	a := 4;
	b := 4;
	f := a > b;
	writeln( f );
	f := a >= b;
	writeln( f );
	f := a = b;
	writeln( f );
	f := a <= b;
	writeln( true );
	f := a < b;
	writeln( f );

	if(f ) then
	begin
	writeln(3);
	end
	else
	writeln(1);
	if (2=2) and not(2<>2) then writeln ( 1 );

end .