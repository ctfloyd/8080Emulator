package emulator.instructions;

import emulator.Emulator;

public class JC implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(state.getCarry()){
            new JMP().operate(state);
            System.out.println("JC did take jump");
        } else {
            System.out.println("JC didn't take jump");
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
