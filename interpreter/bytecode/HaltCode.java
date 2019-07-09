package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        vm.run(false);
        if (vm.DumpModeVerifier()) {
            System.out.println("HALT");
        }


    }

    @Override
    public void init(ArrayList<String> string) {

    }
}
