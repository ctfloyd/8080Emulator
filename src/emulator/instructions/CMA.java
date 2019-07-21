package emulator.instructions;

import emulator.Emulator;

public class CMA implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.getRegisterA().setData((byte)~state.getRegisterA().getData());
    }
}
