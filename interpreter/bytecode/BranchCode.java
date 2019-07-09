package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class BranchCode extends ByteCode{
    String label;
    int address;

    @Override
    public void init(ArrayList<String> Tokens) {

    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public void setBranchAddress(int n){
        address = n;
    }

    public String getLabel() {
        return label;
    }
}