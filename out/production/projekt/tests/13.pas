program someTest;
var a,c,b,x : integer;
var endPointer : boolean;
begin
    endPointer := true;
    a := 1;
    x := 0;
    c := 0;
    b := 42;
    if x = 1 then
        begin
            b := a + a;
            c := b;
            writeln(a);
            if x < 2 then
                begin
                    a := a+1;
                    b := b+2;
                end;
        end;
    writeln(c);

    if x > 4 then
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
    x := 0;
    while x < 4 do
        begin
            writeln(a);
            x := x+1;
        end
end.