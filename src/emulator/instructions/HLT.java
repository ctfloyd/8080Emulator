package emulator.instructions;

import emulator.Emulator;

public class HLT implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setStopped();
    }
}
