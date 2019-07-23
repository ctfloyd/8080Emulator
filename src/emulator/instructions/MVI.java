package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class MVI implements Instruction {

    private Register register;

    public MVI(Register register){
        this.register = register;
    }

    public MVI(){

    }

    @Override
    public void operate(Emulator state){
        if(register == null){
            state.writeMemory((byte)(state.readMemory(state.getPC())), state.getHL());
        } else {
            register.setData((byte)(state.readMemory(state.getPC())));
        }
        state.setPC((short)(state.getPC() + 1));
    }

}
