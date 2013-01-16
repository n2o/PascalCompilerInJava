program someTest;
var a,c,b,d : integer;
var endPointer : boolean;
begin
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
        end
end.