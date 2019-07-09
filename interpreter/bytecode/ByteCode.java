package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode { //delete maybe? maybe not
    //<String> =
    public abstract void init(ArrayList<String> Tokens);
    public abstract void execute(VirtualMachine vm);
}
