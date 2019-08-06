package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class MVI implements Instruction {

    public static final int CYCLES = 7; // TODO: memory movement takes 10 cycles

    private Register register;

    public MVI(Register register){
        this.register = register;
    }

    public MVI(){

    }

    @Override
    public void operate(Cpu8080 state) {
        if(register == null){
            state.writeMemory((byte)(state.readMemory(state.getPC())), state.getHL());
        } else {
            register.setData((byte)(state.readMemory(state.getPC())));
        }
        state.setPC((short)(state.getPC() + 1));
    }

}
