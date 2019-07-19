package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class INX implements Instruction {

    private Register highRegister;
    private Register lowRegister;


    public INX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    @Override
    public void operate(Emulator state) {
        lowRegister.setData((byte)(lowRegister.getData() + 1));
        if(lowRegister.getData() == -128){
            highRegister.setData((byte)(highRegister.getData() + 1));
        }
    }
}
