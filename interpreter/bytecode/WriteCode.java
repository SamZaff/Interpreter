package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.DumpModeVerifier()) {
            System.out.println("WRITE");
        }
        System.out.println(vm.peek());
        if (vm.DumpModeVerifier()) {
            System.out.println("WRITE");
        }
    }

    @Override
    public void init(ArrayList<String> string) {

    }
}
