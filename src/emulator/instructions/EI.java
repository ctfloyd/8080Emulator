package emulator.instructions;

import emulator.Emulator;

public class EI implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setInterrupt(true);
    }
}
