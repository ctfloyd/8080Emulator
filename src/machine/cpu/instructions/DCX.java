package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class DCX implements Instruction {

    public static final int CYCLES = 5;

    private Register highRegister;
    private Register lowRegister;
    private boolean sp;

    public DCX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
        this.sp = false;
    }

    public DCX(short stackPointer){
        this.highRegister = new Register((byte)((stackPointer & 0xFF00) >> 8));
        this.lowRegister = new Register((byte)(stackPointer  & 0x00FF));
        this.sp = true;
    }


    @Override
    public void operate(Cpu8080 state) {
        lowRegister.setData((byte)(lowRegister.getData() - 1));
        if(lowRegister.getData() == -1){
            highRegister.setData((byte)(highRegister.getData() - 1));
        }
        if(this.sp){
            state.setSP((short)(((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF)));
        }
    }
}
