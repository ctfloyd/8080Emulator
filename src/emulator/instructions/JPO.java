package emulator.instructions;

import emulator.Emulator;

public class JPO implements Instruction {

    @Override
    public void operate(Emulator state) {
        if(!state.getParity()) {
            new JMP().operate(state);
        } else {
            state.setPC((short) (state.getPC() + 2));
            System.out.println("JPO");
        }
    }
}
