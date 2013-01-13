Program IlovePriNum;
Var i, n: Integer;
Var prim: Boolean;
Begin
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
    END;
    writeln(prim)
End.