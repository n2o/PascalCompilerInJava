program factorial;
var fak, res, a, b, c, d, temp, n, i : integer;
vAr f, x, y, z, endPointer, prim : boOlEAn;
begin
	fak := 5;
	res := 1;
	while fak > 0 do
		begin
			res := res * fak;
			fak := fak - 1;
		end;
	writeln(res);
	if (2=2) and not(2<>2) then writeln(334364336);
	if (2=2) and not(2<>3) then writeln(3334443);
	writeln(not false);
	writeln(not(true));
	writeln(not(true and false));
	writeln(1 - (3 - (2 + 1)));
	a := 1 ;
	b := 1 ;
	while a < 1000 do 
		begin
			writeln ( a ) ;
			temp := b ;
			b := a + b ;
			a := temp ;
		end;
	a := 3;
	writeln(a);
	a := 10;
	c := ((a mod 3) * 3) div 2;
	writeln(c);
	b := 1;
	x := true;
	while a >= b do
		begin
			a := a - b;
			writeln(a);
			if a <= b + 1 then
			break
			else
			writeln(x);
		end;
		a := 1+(7*3);
	b := 7--(1+4);
	c := 2 + -+-+-+-+++-1;
	writeln(a);
	writeln(b);
	writeln(c);
	a := 1;
	b := a;
	c := b+a;

	while a < 10 do
		begin
			a := a+1;
			while b < 10 do
				begin
					b := b+1;
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
		end;
	writeln(999999);
	a := 1;
	b := 1;
	while (True and (a < 100)) do 
		begin
			writeln(a);
			temp := b;
			b := a + b;
			a := temp ;
		end;
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
	a := 0;
	b := 6;
	f := a > b;
	while a < b do 
		begin
			a := a -- (1+a);
			writeln(a);
		end;
	writeln(false);

	endPointer := true;
    a := 1;
    d := 0;
    c := 0;
    b := 42;
    if d = 1 then
        begin
            b := a + a;
            c := b;
            writeln(a);
            if d < 2 then
                begin
                    a := a+1;
                    b := b+2;
                end;
        end;
    writeln(c);

    if d > 4 then
        begin
            writeln(a);
            writeln(b);
        end
    else
        begin
            writeln(c);
            writeln(c);
        end;

    writeln(endPointer);
    d := 0;
    while d < 4 do
        begin
            writeln(a);
            d := d+1;
        end;

    n := 42;
    i := 2;
    prim := true;
    while true do
    BEGIN
        if (n mod i)=0 then
        BEGIN
            writeln(i);
            prim := false;
            break;
        END else
        i := i + 1;
        if i=(n-1) then
        BEGIN
            prim := true;
            break;
        END;
    END
end.