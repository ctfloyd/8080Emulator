package emulator.instructions;

import emulator.Emulator;

public class SUI implements Instruction {

    @Override
    public void operate(Emulator state) {
        int res = (state.getRegisterA().getData() & 0xFF) - state.readMemory(state.getPC());
        state.getRegisterA().setData((byte)res);
        state.setSZP(state.getRegisterA());
        state.setCarry((res & 0xFFFFFF00) != 0);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
        state.printStatus();
    }
}
