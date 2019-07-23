package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class MOV implements Instruction {
    // dst src

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
    public void operate(Emulator state) {
        if(registerSrc == null){
            this.registerDst.setData((byte)(state.readMemory(state.getHL())));
        } else if(registerDst == null){
            state.writeMemory(registerSrc.getData(), state.getHL());
        } else {
            this.registerDst.setData(this.registerSrc.getData());
        }
    }
}
