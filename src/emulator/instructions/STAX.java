package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class STAX implements Instruction{

    private Register highRegister;
    private Register lowRegister;

    public STAX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    @Override
    public void operate(Emulator state) {
        int location = Short.toUnsignedInt((short)(highRegister.getData() << 8 | lowRegister.getData()));
        state.writeMemory(state.getRegisterA().getData(), location);
    }

}
