package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class INX implements Instruction {

    private Register highRegister;
    private Register lowRegister;
    private boolean sp;


    public INX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
        this.sp = false;
    }

    public INX(short stackPointer){
        this.highRegister = new Register((byte)((stackPointer & 0xFF00) >> 8));
        this.lowRegister = new Register((byte)(stackPointer & 0x00FF));
        this.sp = true;
    }

    @Override
    public void operate(Emulator state) {
        lowRegister.setData((byte)(lowRegister.getData() + 1));
        if(lowRegister.getData() == 0){
            highRegister.setData((byte)(highRegister.getData() + 1));
        }
        if(this.sp){
            state.setSP((short)(((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF)));
        }
    }
}
