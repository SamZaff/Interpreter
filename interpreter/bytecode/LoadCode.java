package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    int location;
    String var = null;
    @Override
    public void execute(VirtualMachine vm) {
        vm.load(location);
        if (vm.DumpModeVerifier()) {
            if (var != null) {
                System.out.println("LOAD " + location + " " + var);
            }
            else {
                System.out.println("LOAD " + location);
            }
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        location = Integer.valueOf(string.get(0));
        if (string.size() > 1) {
            var = string.get(1);
        }
    }
}
