package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class CMP implements Instruction {

    public static final int CYCLES = 4; // TODO: memory takes 7 cycles
    private Register register;

    public CMP(Register register){
        this.register = register;
    }

    public CMP(){

    }

    @Override
    public void operate(Cpu8080 state) {
        Register tempRegister = new Register();
        if(this.register == null)
        {
            tempRegister.setData((byte)(state.getRegisterA().getData() - state.readMemory(state.getHL())));
        } else {
            tempRegister.setData((byte)(state.getRegisterA().getData() - (register.getData())));
        }
        state.setCarry(tempRegister.getData() < 0);
        state.setSZP(tempRegister);

    }
}
