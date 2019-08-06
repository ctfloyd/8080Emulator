package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class STAX implements Instruction{

    public static final int CYCLES = 7;
    private Register highRegister;
    private Register lowRegister;

    public STAX(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    @Override
    public void operate(Cpu8080 state) {
        short location = (short)(((highRegister.getData() & 0xFF) << 8) | (lowRegister.getData() & 0xFF));
        state.writeMemory(state.getRegisterA().getData(), location);
    }

}
