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
    private int pc;
    private byte[] sp = new byte[2];
    private Stack stack = new Stack();
    private boolean carry;
    private boolean auxillaryCarry;
    private boolean sign;
    private boolean zero;
    private boolean parity;

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
    }

    private void loadROMFromFile(String src) throws FileNotFoundException {
        InputStream in = new FileInputStream(src);

        try {
            in.read(memory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadedROM = true;
    }

    private void startEmulation(){
//        if(!loadedROM){
//            System.out.println("No ROM loaded, exiting.");
//            return;
//        }
        memory[0] = 0x05;
        registerA.setData((byte)-78);
        parseInstruction(pc);
        System.out.println(registerA.getData());

    }

    public void setSZP(Register changedRegister){
        zero = changedRegister.getData() == 0;
        sign = 0x80 == (changedRegister.getData() & 0x80);
        parity = checkParity(changedRegister.getData());
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
            case "21": new LXI(registerH, registerL).operate(this); break;
            case "22": new SHLD().operate(this); break;
            case "23": new INX(registerH, registerL).operate(this); break;
            case "24": new INR(registerH).operate(this); break;
            case "25": new DCR(registerH).operate(this); break;
            case "26": new MVI(registerH).operate(this); break;
            case "27": throw new UnimplementedInstructionError();
            case "28": new NOP().operate(this); break;
            case "29": new DAD(registerH, registerL).operate(this); break;

        }
    }

    public byte[] getMemory() {
        return this.memory;
    }

    public int getPC(){
        return this.pc;
    }

    public void setPC(int newPC){
        pc = newPC;
    }

    public void writeMemory(byte register, int memoryLocation){
        if(memoryLocation < 0x2000){
            System.out.println("Error, cannot write to ROM");
        }
        if(memoryLocation >= 0x4000){
            System.out.println("Can't write outside of loaded user application");
        }
        memory[memoryLocation] = register;
    }

    // Use disassmebled instructions?

    public static void main(String[] args){
        Emulator emulator = new Emulator();
//        try {
//            emulator.loadROMFromFile("invaders/invaders");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        emulator.startEmulation();

    }

}
