program input2;
var a, b, c : integer;
var x, y, z : boolean;
begin
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
end.