package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    int location;
    String var = null;
    @Override
    public void execute(VirtualMachine vm) {
        int stackTop = vm.peek();
        vm.store(location);
        if (vm.DumpModeVerifier()) {
            if (var != null) {
                System.out.println("STORE " + location + " " + var);
            } else {
                System.out.println("STORE" + location);
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
