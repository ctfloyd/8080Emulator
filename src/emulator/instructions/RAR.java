package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class RAR implements Instruction {

    @Override
    public void operate(Emulator state) {
        Register registerA = state.getRegisterA();
        byte registerData = registerA.getData();
        byte carryAsByte = (byte)((state.getCarry() ? (byte)1 : (byte)0) << 7);
        registerA.setData((byte)((byte)(registerA.getData() >> 1) | carryAsByte));
        state.setCarry((registerData & 0x1) == 0x1);
    }
}
