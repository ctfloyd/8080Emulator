package emulator.instructions;

import emulator.Emulator;

public class DI implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setInterrupt(false);
    }
}
