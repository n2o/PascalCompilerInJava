proGRam fibonacci; 
var a : integer; 
var b: integer; 
var temp : integer; 

{evil 
comment!!!!}

BeGin
	a := 1;
	b := 1;
	while 1 < 2 do 
	begin 
		writeln(a); // Bombe				!
		temp := b;
		b := a + b;
		a := temp ;
	end
{Ich bin es, der teufel!
harhar... ..		.	.			.	..	..}
end.



