package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{
    private int value;
    private String var = null;
    @Override
    public void execute(VirtualMachine vm) {
        vm.push(value);
        if (vm.DumpModeVerifier()) {
            if (var != null) {
                System.out.println("LIT " + value + " " + var);
            } else {
                System.out.println("LIT " + value);
            }
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        value = Integer.valueOf(string.get(0));
        if (string.size() > 1) {
            var = string.get(1);
        }

    }
}
