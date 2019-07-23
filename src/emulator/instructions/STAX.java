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
        short location = (short)(((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF));
        System.out.println("stax:" + location);
        state.writeMemory(state.getRegisterA().getData(), location);
    }

}
