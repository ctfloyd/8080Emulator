package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class MOV implements Instruction {
    // dst src

    public static final int CYCLES = 7;

    private Register registerDst;
    private Register registerSrc;

    public MOV(Register registerDst, Register registerSrc){
        this.registerDst = registerDst;
        this.registerSrc = registerSrc;
    }

    public MOV(Register registerDst){
        this.registerDst = registerDst;
    }

    @Override
    public void operate(Cpu8080 state) {
        if(registerSrc == null){
            this.registerDst.setData((byte)(state.readMemory(state.getHL())));
        } else if(registerDst == null){
            state.writeMemory(registerSrc.getData(), state.getHL());
        } else {
            this.registerDst.setData(this.registerSrc.getData());
        }
    }
}
