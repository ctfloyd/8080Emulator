package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class DCX implements Instruction {

    private Register highRegister;
    private Register lowRegister;

    public DCX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    public DCX(short stackPointer){
        this.highRegister = new Register((byte)(stackPointer & 0xFF00 << 8));
        this.lowRegister = new Register((byte)(stackPointer  & 0x00FF));
    }


    @Override
    public void operate(Emulator state) {
        lowRegister.setData((byte)(lowRegister.getData() - 1));
        if(lowRegister.getData() == 127){
            highRegister.setData((byte)(highRegister.getData() - 1));
        }
    }
}
