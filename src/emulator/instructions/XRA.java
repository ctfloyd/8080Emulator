package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class XRA implements Instruction {

    private Register register;

    public XRA(Register register){
        this.register = register;
    }

    public XRA(){

    }

    @Override
    public void operate(Emulator state) {
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() ^ state.readMemory(state.getHL())));
        } else {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() ^ register.getData()));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
    }
}
