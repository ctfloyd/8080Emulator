package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class PUSH implements Instruction {

    public static final int CYCLES = 11;

    private Register highRegister;
    private Register lowRegister;

    public PUSH(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    public PUSH(Register psw){
        this.highRegister = psw;
    }

    @Override
    public void operate(Cpu8080 state) {
        if(lowRegister == null) {

            byte psw = 0x00;

            if(state.getSign())
                psw |= 0x80;
            else
                psw |= 0x0;

            if(state.getZero())
                psw |= 0x40;
            else
                psw |= 0x0;

            if(state.getParity())
                psw |= 0x04;
            else
                psw |= 0x0;

            // TODO: condintaional for auxilary carry
            psw |= 0x02; // this bit is always one

            if(state.getCarry())
                psw |= 0x01;
            else
                psw |= 0x0;

            state.writeMemory(state.getRegisterA().getData(), state.getSP() - 1);
            state.writeMemory(psw, state.getSP() - 2);
        } else {
//            System.out.println("PUSHING: HR: " + highRegister.getData());
            state.writeMemory(highRegister.getData(), state.getSP() - 1);
            state.writeMemory(lowRegister.getData(), state.getSP() - 2);
        }
        state.setSP((short)(state.getSP() - 2));
    }
}
