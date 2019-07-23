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
        short location = (short)(((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF));
        System.out.println("ldax:" + (highRegister.getData() & 0xFF) + " : " + (lowRegister.getData() & 0xFF));
        state.getRegisterA().setData((byte)state.readMemory(location));
    }

}
