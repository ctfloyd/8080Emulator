package emulator.instructions;

import emulator.Emulator;

public class NOP implements Instruction {

    @Override
    public void operate(Emulator state) {
        return;
    }
}
