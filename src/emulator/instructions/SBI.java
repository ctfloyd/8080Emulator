package emulator.instructions;

import emulator.Emulator;

public class SBI implements Instruction {

    @Override
    public void operate(Emulator state) {
        byte carry = state.getCarry() ? (byte)1 : (byte)0;
        int regData = (state.getRegisterA().getData() & 0xFF) - state.readMemory(state.getPC()) - carry;
        state.getRegisterA().setData((byte)regData);
        state.setSZP(state.getRegisterA());
        if((regData & 0xFFFFFF00) != 0)
            state.setCarry(true);
        else
            state.setCarry(false);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }
}
