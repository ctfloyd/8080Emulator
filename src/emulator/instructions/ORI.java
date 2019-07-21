package emulator.instructions;

import emulator.Emulator;

public class ORI implements Instruction {

    @Override
    public void operate(Emulator state) {
        state.getRegisterA().setData((byte)(state.getRegisterA().getData()| state.readMemory(state.getPC())));
        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        state.setPC((short) (state.getPC() + 1));
    }
}
