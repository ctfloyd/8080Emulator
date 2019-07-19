package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RAL implements Instruction {

    @Override
    public void operate(Emulator state) {
        Register registerA = state.getRegisterA();
        byte registerData = registerA.getData();
        byte carryAsByte = state.getCarry() ? (byte)1 : (byte)0;
        registerA.setData((byte)((byte)(registerA.getData() << 1) | carryAsByte));
        state.setCarry((registerData & 0x80) == 0x80);
    }
}
