package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    private int value;
    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(value);
        if (vm.DumpModeVerifier()) {
            System.out.println("ARGS " + value);
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        value = Integer.valueOf(string.get(0));
    }
}
