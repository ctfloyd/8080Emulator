package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class DCR implements Instruction {

    private Register register;

    public DCR(Register register){
        this.register = register;
    }

    @Override
    public void operate(Emulator state){
        register.setData((byte) (register.getData() - 1));
        state.setSZP(register);
    }

}
