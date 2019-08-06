package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class SBI implements Instruction {

    public static final int CYCLES = 7;
    @Override
    public void operate(Cpu8080 state) {
        byte carry = state.getCarry() ? (byte)1 : (byte)0;
        int regData = (state.getRegisterA().getData() & 0xFF) - state.readMemory(state.getPC()) - carry;
        state.getRegisterA().setData((byte)regData);
        state.setSZP(state.getRegisterA());
        state.setCarry((regData & 0xFFFFFF00) != 0);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }
}
