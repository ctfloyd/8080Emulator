package emulator.instructions;

import emulator.Emulator;

public class ACI implements Instruction {

    @Override
    public void operate(Emulator state) {
        byte carry = state.getCarry() ? (byte)1 : (byte)0;
        int regData = (state.getRegisterA().getData() & 0xFF) + (state.readMemory(state.getPC()) + carry);
        state.getRegisterA().setData((byte)regData);
        state.setSZP(state.getRegisterA());
        state.setCarry((regData & 0xFFFFFF00) != 0);
        // TODO: set aux carry
        System.out.println("ACI ----");
        state.printStatus();
        state.setPC((short) (state.getPC() + 1));
    }
}
