package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class JPE implements Instruction {

    public static final int CYCLES = 10;

    @Override
    public void operate(Cpu8080 state) {
        if(state.getParity())
            new JMP().operate(state);
        else
            state.setPC((short)(state.getPC() + 2));
    }
}
