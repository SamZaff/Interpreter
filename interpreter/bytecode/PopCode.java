package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int value;
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.sizeOfFrame() >= value ) {
            for (int i = 0; i < value; i++) {
                vm.pop();
            }
        }
        else {
            while (vm.sizeOfStack() >= vm.sizeOfFrame()) {
                vm.pop();
            }
        }
        if (vm.DumpModeVerifier()) {
            System.out.println("POP " + value);
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        value = Integer.valueOf(string.get(0));
    }
}
