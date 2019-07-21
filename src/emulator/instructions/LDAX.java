package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class LDAX implements Instruction {

    private Register highRegister;
    private Register lowRegister;

    public LDAX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    @Override
    public void operate(Emulator state) {
        Register registerA = state.getRegisterA();
        int location = Short.toUnsignedInt((short)(highRegister.getData() << 8 | lowRegister.getData()));
        registerA.setData((byte)(registerA.getData() + state.getMemory()[location]));
    }

}
