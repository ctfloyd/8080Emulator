package emulator.instructions;

import emulator.Emulator;

public class SPHL implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setSP((short)state.getHL());
    }
}
