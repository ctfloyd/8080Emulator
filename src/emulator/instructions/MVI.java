package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class MVI implements Instruction {

    private Register register;

    public MVI(Register register){
        this.register = register;
    }

    @Override
    public void operate(Emulator state){
        register.setData(state.getMemory()[state.getPC()]);
        state.setPC(state.getPC() + 1);
    }

}
