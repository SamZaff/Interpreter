package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

import java.util.Scanner;
public class ReadCode extends ByteCode{
    Scanner sc;
    int input;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.print("Please type in a whole number value: ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            input = sc.nextInt();
            vm.push(input);
            if (vm.DumpModeVerifier()) {
                System.out.println("READ");
            }
        }
        else {
            System.out.println("Invalid value");
            execute(vm);
        }
    }

    @Override
    public void init(ArrayList<String> string) {

    }
}
