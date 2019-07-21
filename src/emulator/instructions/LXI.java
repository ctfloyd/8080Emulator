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

    public LXI(){

    }

    @Override
    public void operate(Emulator state) {
        if(lowRegister == null){
            state.setSP((short)(state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())));
            System.out.println("Stack pointer set at: " + (short)(state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())));
        } else {
            int pc = state.getPC();
            lowRegister.setData((byte)state.readMemory(pc));
            highRegister.setData((byte)state.readMemory(pc + 1));
        }
        state.setPC((short)(state.getPC() + 2));

    }
}
