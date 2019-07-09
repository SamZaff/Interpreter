package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    int operand1;
    int operand2;
    String operation;
    @Override
    public void execute(VirtualMachine vm) {
        operand2 = vm.pop();
        operand1 = vm.pop();
        switch(operation) {
            case "+":
                vm.push(operand1+operand2);
                break;
            case "-":
                vm.push(operand1-operand2);
                break;
            case "/":
                vm.push(operand1/operand2);
                break;
            case "*":
                vm.push(operand1*operand2);
                break;
            case "==":
                if (operand1 == operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case "!=":
                if (operand1 != operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case ">=":
                if (operand1 >= operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case ">":
                if (operand1 > operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case "<=":
                if (operand1 <= operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case "<":
                if (operand1 < operand2) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case "|":
                if (operand1 == 0 && operand2 == 0) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;
            case "&":
                if (operand1 == 1 && operand2 == 1) {
                    vm.push(1);
                }
                else {
                    vm.push(0);
                }
                break;

        }
        if (vm.DumpModeVerifier()) {
            System.out.println("BOP " + operation);
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        operation = string.get(0);
    }
}
