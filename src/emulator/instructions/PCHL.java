package emulator.instructions;

import emulator.Emulator;

public class PCHL implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.setPC((short)state.getHL());
    }
}
