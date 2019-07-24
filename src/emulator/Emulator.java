package emulator;

import emulator.instructions.*;

import java.io.*;
import java.util.Stack;

public class Emulator {

    // 8080 components
    private Register registerB; // 001
    private Register registerC; // 010
    private Register registerD; // 011
    private Register registerE; // 100
    private Register registerH; // High bytes of referenced address 101
    private Register registerL; // Low bytes of referenced address 110
    private Register registerA; // 111
    private Register registerPSW;
    private byte[] memory = new byte[65536];
    private short pc;
    private short sp;
    private boolean carry;
    private boolean auxillaryCarry;
    private boolean sign;
    private boolean zero;
    private boolean parity;
    private boolean stopped;
    private boolean interrupt;

    // Emulator specific
    private boolean loadedROM;

    public Register getRegisterB(){
        return this.registerB;
    }

    public Register getRegisterC(){
        return this.registerC;
    }

    public Register getRegisterA(){
        return this.registerA;
    }

    public Register getRegisterH(){
        return this.registerH;
    }

    public Register getRegisterL(){
        return this.registerL;
    }

    public void setCarry(boolean c){
        this.carry = c;
    }

    public boolean getCarry(){
        return this.carry;
    }

    public void setStopped(){
        this.stopped = !this.stopped;
    }

    public void setInterrupt(boolean interrupt) {
        this.interrupt = interrupt;
    }

    public Emulator(){
        registerB = new Register();
        registerC = new Register();
        registerD = new Register();
        registerE = new Register();
        registerH = new Register();
        registerL = new Register();
        registerA = new Register();
        registerPSW = new Register();
        carry = false;
        auxillaryCarry = false;
        sign = false;
        zero = false;
        parity = false;
        pc = 0;
        sp = 0;
    }

    private void loadROMFromFile(String src) throws FileNotFoundException {
        InputStream in = new FileInputStream(src);
        try {
            in.read(memory, 0x100, 64000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadedROM = true;
    }

    private void startEmulation() throws UnimplementedInstructionError {
        memory[368] = 0x7;
        memory[0] = (byte) 0xc3;
        memory[1] = 0;
        memory[2] = 0x01;

        //Skip DAA test
        memory[0x59c] = (byte)0xc3; //JMP
        memory[0x59d] = (byte)0xc2;
        memory[0x59e] = (byte)0x05;


//        if(!loadedROM){
//            System.out.println("No ROM loaded, exiting.");
//            return;
//        }
//        memory[0] = 0x05;
//        registerA.setData((byte)-78);
        while (!stopped) {
            System.out.println("Program counter: " + pc);
            parseInstruction(pc);

        }

        }

//        System.out.println(registerA.getData());


    public void setSZP(Register changedRegister){
        zero = changedRegister.getData() == 0;
        sign = 0x80 == (changedRegister.getData() & 0x80);
        parity = checkParity(changedRegister.getData());
    }

    public int getHL(){
        return (short)((registerH.getData() & 0xFF) << 8 | (registerL.getData() & 0xFF));
    }

    public short getSP(){
        return this.sp;
    }

    public boolean getZero(){
        return this.zero;
    }

    public void setSP(short sp){
        this.sp = sp;
    }

    public void setSign(boolean sign){
        this.sign = sign;
    }

    public void setZero(boolean zero){
        this.zero = zero;
    }

    public void setParity(boolean parity){
        this.parity = parity;
    }

    public boolean getParity(){
        return this.parity;
    }

    public boolean getSign(){
        return this.sign;
    }

    public Register getRegisterD(){
        return this.registerD;
    }

    public Register getRegisterE(){
        return this.registerE;
    }

    public boolean checkParity(byte b){
        int parityBits = 0; // count ones
        for(int i = 0; i < 8; i++){
            if((b & 0x1) == 1){
                parityBits++;
            }
            b = (byte)(b >> 1);
        }
        return (parityBits & 0x1) == 0; // check the last bit to determine odd or even
    }

    private void parseInstruction(int memoryLocation) throws UnimplementedInstructionError {
        pc += 1;
        byte instruction = memory[memoryLocation];
        String hexInstruction = String.format("%02x", instruction);
        System.out.println(hexInstruction);
        switch(hexInstruction){
            case "00": new NOP().operate(this); break;
            case "01": new LXI(registerB, registerC).operate(this); break;
            case "02": new STAX(registerB, registerC).operate(this); break;
            case "03": new INX(registerB, registerC).operate(this); break;
            case "04": new INR(registerB).operate(this); break;
            case "05": new DCR(registerB).operate(this); break;
            case "06": new MVI(registerB).operate(this); break;
            case "07": new RLC().operate(this); break;
            case "08": new NOP().operate(this); break;
            case "09": new DAD(registerB, registerC).operate(this); break;
            case "0a": new LDAX(registerB, registerC).operate(this); break;
            case "0b": new DCX(registerB, registerC).operate(this); break;
            case "0c": new INR(registerC).operate(this); break;
            case "0d": new DCR(registerC).operate(this); break;
            case "0e": new MVI(registerC).operate(this); break;
            case "0f": new RRC().operate(this); break;

            case "10": new NOP().operate(this); break;
            case "11": new LXI(registerD, registerE).operate(this); break;
            case "12": new STAX(registerD, registerE).operate(this); break;
            case "13": new INX(registerD, registerE).operate(this); break;
            case "14": new INR(registerD).operate(this); break;
            case "15": new DCR(registerD).operate(this); break;
            case "16": new MVI(registerD).operate(this); break;
            case "17": new RAL().operate(this); break;
            case "18": new NOP().operate(this); break;
            case "19": new DAD(registerD, registerE).operate(this); break;
            case "1a": new LDAX(registerD, registerE).operate(this); break;
            case "1b": new DCX(registerD, registerE).operate(this); break;
            case "1c": new INR(registerE).operate(this); break;
            case "1d": new DCR(registerE).operate(this); break;
            case "1e": new MVI(registerE).operate(this); break;
            case "1f": new RAR().operate(this); break;

            case "20": new NOP().operate(this); break;
            case "21": new LXI(registerH, registerL).operate(this); System.out.println("0x21: PC " + pc);break;
            case "22": new SHLD().operate(this); break;
            case "23": new INX(registerH, registerL).operate(this); break;
            case "24": new INR(registerH).operate(this); break;
            case "25": new DCR(registerH).operate(this); break;
            case "26": new MVI(registerH).operate(this); break;
            case "27": break;
            case "28": new NOP().operate(this); break;
            case "29": new DAD(registerH, registerL).operate(this); break;
            case "2a": new LHLD().operate(this); break;
            case "2b": new DCX(registerH, registerL).operate(this); break;
            case "2c": new INR(registerL).operate(this); break;
            case "2d": new DCR(registerL).operate(this); break;
            case "2e": new MVI(registerL).operate(this); break;
            case "2f": new CMA().operate(this); break;

            case "30": new NOP().operate(this); break;
            case "31": new LXI().operate(this); break;
            case "32": new STA().operate(this); break;
            case "33": new INX(sp).operate(this); break;
            case "34": new INR().operate(this); break;
            case "35": new DCR().operate(this); break;
            case "36": new MVI().operate(this); break;
            case "37": new STC().operate(this); break;
            case "38": new NOP().operate(this); break;
            case "39": new DAD(sp).operate(this); break;
            case "3a": new LDA().operate(this); break;
            case "3b": new DCX(sp).operate(this); break;
            case "3c": new INR(registerA).operate(this); break;
            case "3d": new DCR(registerA).operate(this); break;
            case "3e": new MVI(registerA).operate(this); break;
            case "3f": new CMC().operate(this); break;

            case "40": new MOV(registerB, registerB).operate(this); break;
            case "41": new MOV(registerB, registerC).operate(this); break;
            case "42": new MOV(registerB, registerD).operate(this); break;
            case "43": new MOV(registerB, registerE).operate(this); break;
            case "44": new MOV(registerB, registerH).operate(this); break;
            case "45": new MOV(registerB, registerL).operate(this); break;
            case "46": new MOV(registerB).operate(this); break;
            case "47": new MOV(registerB, registerA).operate(this); break;
            case "48": new MOV(registerC, registerB).operate(this); break;
            case "49": new MOV(registerC, registerC).operate(this); break;
            case "4a": new MOV(registerC, registerD).operate(this); break;
            case "4b": new MOV(registerC, registerE).operate(this); break;
            case "4c": new MOV(registerC, registerH).operate(this); break;
            case "4d": new MOV(registerC, registerL).operate(this); break;
            case "4e": new MOV(registerC).operate(this); break;
            case "4f": new MOV(registerC, registerA).operate(this); break;

            case "50": new MOV(registerD, registerB).operate(this); break;
            case "51": new MOV(registerD, registerC).operate(this); break;
            case "52": new MOV(registerD, registerD).operate(this); break;
            case "53": new MOV(registerD, registerE).operate(this); break;
            case "54": new MOV(registerD, registerH).operate(this); break;
            case "55": new MOV(registerD, registerL).operate(this); break;
            case "56": new MOV(registerD).operate(this); break;
            case "57": new MOV(registerD, registerA).operate(this); break;
            case "58": new MOV(registerE, registerB).operate(this); break;
            case "59": new MOV(registerE, registerC).operate(this); break;
            case "5a": new MOV(registerE, registerD).operate(this); break;
            case "5b": new MOV(registerE, registerE).operate(this); break;
            case "5c": new MOV(registerE, registerH).operate(this); break;
            case "5d": new MOV(registerE, registerL).operate(this); break;
            case "5e": new MOV(registerE).operate(this); break;
            case "5f": new MOV(registerE, registerA).operate(this); break;

            case "60": new MOV(registerH, registerB).operate(this); break;
            case "61": new MOV(registerH, registerC).operate(this); break;
            case "62": new MOV(registerH, registerD).operate(this); break;
            case "63": new MOV(registerH, registerE).operate(this); break;
            case "64": new MOV(registerH, registerH).operate(this); break;
            case "65": new MOV(registerH, registerL).operate(this); break;
            case "66": new MOV(registerH).operate(this); break;
            case "67": new MOV(registerH, registerA).operate(this); break;
            case "68": new MOV(registerL, registerB).operate(this); break;
            case "69": new MOV(registerL, registerC).operate(this); break;
            case "6a": new MOV(registerL, registerD).operate(this); break;
            case "6b": new MOV(registerL, registerE).operate(this); break;
            case "6c": new MOV(registerL, registerH).operate(this); break;
            case "6d": new MOV(registerL, registerL).operate(this); break;
            case "6e": new MOV(registerL).operate(this); break;
            case "6f": new MOV(registerL, registerA).operate(this); break;

            case "70": new MOV(null, registerB).operate(this); break;
            case "71": new MOV(null, registerC).operate(this); break;
            case "72": new MOV(null, registerD).operate(this); break;
            case "73": new MOV(null, registerE).operate(this); break;
            case "74": new MOV(null, registerH).operate(this); break;
            case "75": new MOV(null, registerL).operate(this); break;
            case "76": new HLT().operate(this); break;
            case "77": new MOV(null, registerA).operate(this); break;
            case "78": new MOV(registerA, registerB).operate(this); break;
            case "79": new MOV(registerA, registerC).operate(this); break;
            case "7a": new MOV(registerA, registerD).operate(this); break;
            case "7b": new MOV(registerA, registerE).operate(this); break;
            case "7c": new MOV(registerA, registerH).operate(this); break;
            case "7d": new MOV(registerA, registerL).operate(this); break;
            case "7e": new MOV(registerA).operate(this); break;
            case "7f": new MOV(registerA, registerA).operate(this); break;

            case "80": new ADD(registerB).operate(this); break;
            case "81": new ADD(registerC).operate(this); break;
            case "82": new ADD(registerD).operate(this); break;
            case "83": new ADD(registerE).operate(this); break;
            case "84": new ADD(registerH).operate(this); break;
            case "85": new ADD(registerL).operate(this); break;
            case "86": new ADD().operate(this); break;
            case "87": new ADD(registerA).operate(this); break;
            case "88": new ADC(registerB).operate(this); break;
            case "89": new ADC(registerC).operate(this); break;
            case "8a": new ADC(registerD).operate(this); break;
            case "8b": new ADC(registerE).operate(this); break;
            case "8c": new ADC(registerH).operate(this); break;
            case "8d": new ADC(registerL).operate(this); break;
            case "8e": new ADC().operate(this); break;
            case "8f": new ADC(registerA).operate(this); break;

            case "90": new SUB(registerB).operate(this); break;
            case "91": new SUB(registerC).operate(this); break;
            case "92": new SUB(registerD).operate(this); break;
            case "93": new SUB(registerE).operate(this); break;
            case "94": new SUB(registerH).operate(this); break;
            case "95": new SUB(registerL).operate(this); break;
            case "96": new SUB().operate(this); break;
            case "97": new SUB(registerA).operate(this); break;
            case "98": new SBB(registerB).operate(this); break;
            case "99": new SBB(registerC).operate(this); break;
            case "9a": new SBB(registerD).operate(this); break;
            case "9b": new SBB(registerE).operate(this); break;
            case "9c": new SBB(registerH).operate(this); break;
            case "9d": new SBB(registerL).operate(this); break;
            case "9e": new SBB().operate(this); break;
            case "9f": new SBB(registerA).operate(this); break;

            case "a0": new ANA(registerB).operate(this); break;
            case "a1": new ANA(registerC).operate(this); break;
            case "a2": new ANA(registerD).operate(this); break;
            case "a3": new ANA(registerE).operate(this); break;
            case "a4": new ANA(registerH).operate(this); break;
            case "a5": new ANA(registerL).operate(this); break;
            case "a6": new ANA().operate(this); break;
            case "a7": new ANA(registerA).operate(this); break;
            case "a8": new XRA(registerB).operate(this); break;
            case "a9": new XRA(registerC).operate(this); break;
            case "aa": new XRA(registerD).operate(this); break;
            case "ab": new XRA(registerE).operate(this); break;
            case "ac": new XRA(registerH).operate(this); break;
            case "ad": new XRA(registerL).operate(this); break;
            case "ae": new XRA().operate(this); break;
            case "af": new XRA(registerA).operate(this); break;

            case "b0": new ORA(registerB).operate(this); break;
            case "b1": new ORA(registerC).operate(this); break;
            case "b2": new ORA(registerD).operate(this); break;
            case "b3": new ORA(registerE).operate(this); break;
            case "b4": new ORA(registerH).operate(this); break;
            case "b5": new ORA(registerL).operate(this); break;
            case "b6": new ORA().operate(this); break;
            case "b7": new ORA(registerA).operate(this); break;
            case "b8": new CMP(registerB).operate(this); break;
            case "b9": new CMP(registerC).operate(this); break;
            case "ba": new CMP(registerD).operate(this); break;
            case "bb": new CMP(registerE).operate(this); break;
            case "bc": new CMP(registerH).operate(this); break;
            case "bd": new CMP(registerL).operate(this); break;
            case "be": new CMP().operate(this); break;
            case "bf": new CMP(registerA).operate(this); break;

            case "c0": new RNZ().operate(this); break;
            case "c1": new POP(registerB, registerC).operate(this); break;
            case "c2": new JNZ().operate(this); break;
            case "c3": new JMP().operate(this); break;
            case "c4": new CNZ().operate(this); break;
            case "c5": new PUSH(registerB, registerC).operate(this); break;
            case "c6": new ADI().operate(this); break;
            case "c7": new RST((byte)0x0).operate(this); break;
            case "c8": new RZ().operate(this); break;
            case "c9": new RET().operate(this); break;
            case "ca": new JZ().operate(this); break;
            case "cb": new JMP().operate(this); break;
            case "cc": new CZ().operate(this); break;
            case "cd": new CALL().operate(this); break;
            case "ce": new ACI().operate(this); break;
            case "cf": new RST((byte)1).operate(this); break;

            case "d0": new RNC().operate(this); break;
            case "d1": new POP(registerD, registerE).operate(this); break;
            case "d2": new JNC().operate(this); break;
            case "d3": throw new UnimplementedInstructionError();
            case "d4": new CNC().operate(this); break;
            case "d5": new PUSH(registerD, registerE).operate(this); break;
            case "d6": new SUI().operate(this); break;
            case "d7":  /*new RST((byte)0x2).operate(this);*/break;
            case "d8": new RC().operate(this); break;
            case "d9": new RET().operate(this); break;
            case "da": new JC().operate(this); break;
            case "db": throw new UnimplementedInstructionError();
            case "dc": new CC().operate(this); break;
            case "dd": new CALL().operate(this); break;
            case "de": new SBI().operate(this); break;
            case "df": new RST((byte)3).operate(this); break;

            case "e0": new RPO().operate(this); break;
            case "e1": new POP(registerH, registerL).operate(this); break;
            case "e2": new JPO().operate(this); break;
            case "e3": new XTHL().operate(this); break;
            case "e4": new CPO().operate(this); break;
            case "e5": new PUSH(registerH, registerL).operate(this); break;
            case "e6": new ANI().operate(this); break;
            case "e7": new RST((byte)4).operate(this); break;
            case "e8": new RPE().operate(this); break;
            case "e9": new PCHL().operate(this); break;
            case "ea": new JPE().operate(this); break;
            case "eb": new XCHG().operate(this); break;
            case "ec": new CPE().operate(this); break;
            case "ed": new CALL().operate(this); break;
            case "ee": new XRI().operate(this); break;
            case "ef": new RST((byte)5).operate(this); break;

            case "f0": new RP().operate(this); break;
            case "f1": new POP(registerPSW).operate(this); break;
            case "f2": new JP().operate(this); break;
            case "f3": new DI().operate(this); break;
            case "f4": new CP().operate(this); break;
            case "f5": new PUSH(registerPSW).operate(this); break;
            case "f6": new ORI().operate(this); break;
            case "f7": new RST((byte)6).operate(this); break;
            case "f8": new RM().operate(this); break;
            case "f9": new SPHL().operate(this); break;
            case "fa": new JM().operate(this); break;
            case "fb": new EI().operate(this); break;
            case "fc": new CM().operate(this); break;
            case "fd": new CALL().operate(this); break;
            case "fe": new CPI().operate(this); break;
            case "ff": new RST((byte)7).operate(this); break;

        }
    }

    public byte[] getMemory() {
        return this.memory;
    }

    public void printStatus() {
        System.out.println("A=" + registerA.getData() + ", C=" + carry + ", P=" + parity + ", S=" + sign + ", Z=" + zero);
    }

    public int readMemory(int memoryLocation){
        return memory[memoryLocation] < 0 ? memory[memoryLocation] & 0xFF : memory[memoryLocation];
    }

    public int getPC(){
        return this.pc < 0 ? this.pc & 0xFF : this.pc;
    }

    public void setPC(short newPC){
        pc = newPC;
    }

    public void writeMemory(byte register, int memoryLocation){
//        if(memoryLocation < 0x2000){
//            System.out.println("Error, cannot write to ROM");
//        if(memoryLocation >= 0x4000){
//            System.out.println("Can't write outside of loaded user application");
//        }
        memory[memoryLocation] = register;
    }

    // Use disassmebled instructions?

    public static void main(String[] args){
        Emulator emulator = new Emulator();
        try {
            emulator.loadROMFromFile("invaders/cpudiag.bin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            emulator.startEmulation();
        } catch (UnimplementedInstructionError unimplementedInstructionError) {
            unimplementedInstructionError.printStackTrace();
        }

    }

}
