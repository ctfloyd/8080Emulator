package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class LXI implements Instruction {

    private Register highRegister;
    private Register lowRegister;

    public LXI(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }
    @Override
    public void operate(Emulator state) {
        byte[] mem = state.getMemory();
        int pc = state.getPC();
        lowRegister.setData(mem[pc]);
        highRegister.setData(mem[pc + 1]);
        state.setPC(pc + 2);
    }
}
