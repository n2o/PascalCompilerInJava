program fibonacci;
var a : integer; 
var b,D: integer; 
var temp : integer; 
begin
a := 1;
b := 1;
a := b;
d := 1;
while a < 100 do 
	begin 
		writeln(a);
		temp := b;
		b := a + b;
		a := temp ;
		if a > 34 then break else
		    begin
		        writeln(a);
		        if 1 < 2 then writeln(0) else writeln(100);
		        while d < 5 do
                    begin
                        writeln(d);
                        d := d+1;
                    end;
		    end;
	end;
writeln(10)
end.