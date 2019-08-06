package machine.cpu;

import machine.cpu.instructions.*;

public class Cpu8080 {

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

    // Cpu8080 specific
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

    public Cpu8080() {
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

    private boolean checkParity(byte b) {
        int parityBits = 0; // count ones
        for(int i = 0; i < 8; i++){
            if((b & 0x1) == 1){
                parityBits++;
            }
            b = (byte)(b >> 1);
        }
        return (parityBits & 0x1) == 0; // check the last bit to determine odd or even
    }

    public int parseInstruction() throws UnimplementedInstructionError {
        byte instruction = memory[pc];
        String hexInstruction = String.format("%02x", instruction);
//        System.out.println(hexInstruction);
        pc += 1;
        switch(hexInstruction){
            case "00":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "01":
                new LXI(registerB, registerC).operate(this);
                return LXI.CYCLES;
            case "02":
                new STAX(registerB, registerC).operate(this);
                return STAX.CYCLES;
            case "03":
                new INX(registerB, registerC).operate(this);
                return INX.CYCLES;
            case "04":
                new INR(registerB).operate(this);
                return INR.CYCLES;
            case "05":
                new DCR(registerB).operate(this);
                return DCR.CYCLES;
            case "06":
                new MVI(registerB).operate(this);
                return MVI.CYCLES;
            case "07":
                new RLC().operate(this);
                return RLC.CYCLES;
            case "08":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "09":
                new DAD(registerB, registerC).operate(this);
                return DAD.CYCLES;
            case "0a":
                new LDAX(registerB, registerC).operate(this);
                return LDAX.CYCLES;
            case "0b":
                new DCX(registerB, registerC).operate(this);
                return DCX.CYCLES;
            case "0c":
                new INR(registerC).operate(this);
                return INR.CYCLES;
            case "0d":
                new DCR(registerC).operate(this);
                return DCR.CYCLES;
            case "0e":
                new MVI(registerC).operate(this);
                return MVI.CYCLES;
            case "0f":
                new RRC().operate(this);
                return RRC.CYCLES;

            case "10":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "11":
                new LXI(registerD, registerE).operate(this);
                return LXI.CYCLES;
            case "12":
                new STAX(registerD, registerE).operate(this);
                return STAX.CYCLES;
            case "13":
                new INX(registerD, registerE).operate(this);
                return INX.CYCLES;
            case "14":
                new INR(registerD).operate(this);
                return INR.CYCLES;
            case "15":
                new DCR(registerD).operate(this);
                return DCR.CYCLES;
            case "16":
                new MVI(registerD).operate(this);
                return MVI.CYCLES;
            case "17":
                new RAL().operate(this);
                return RAL.CYCLES;
            case "18":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "19":
                new DAD(registerD, registerE).operate(this);
                return DAD.CYCLES;
            case "1a":
                new LDAX(registerD, registerE).operate(this);
                return LDAX.CYCLES;
            case "1b":
                new DCX(registerD, registerE).operate(this);
                return DCX.CYCLES;
            case "1c":
                new INR(registerE).operate(this);
                return INR.CYCLES;
            case "1d":
                new DCR(registerE).operate(this);
                return DCR.CYCLES;
            case "1e":
                new MVI(registerE).operate(this);
                return MVI.CYCLES;
            case "1f":
                new RAR().operate(this);
                return RAR.CYCLES;

            case "20":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "21":
                new LXI(registerH, registerL).operate(this);
                return LXI.CYCLES;
            case "22":
                new SHLD().operate(this);
                return SHLD.CYCLES;
            case "23":
                new INX(registerH, registerL).operate(this);
                return INX.CYCLES;
            case "24":
                new INR(registerH).operate(this);
                return INR.CYCLES;
            case "25":
                new DCR(registerH).operate(this);
                return DCR.CYCLES;
            case "26":
                new MVI(registerH).operate(this);
                return MVI.CYCLES;
            case "27":
                return DAA.CYCLES;
            case "28":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "29":
                new DAD(registerH, registerL).operate(this);
                return DAD.CYCLES;
            case "2a":
                new LHLD().operate(this);
                return LHLD.CYCLES;
            case "2b":
                new DCX(registerH, registerL).operate(this);
                return DCX.CYCLES;
            case "2c":
                new INR(registerL).operate(this);
                return INR.CYCLES;
            case "2d":
                new DCR(registerL).operate(this);
                return DCR.CYCLES;
            case "2e":
                new MVI(registerL).operate(this);
                return MVI.CYCLES;
            case "2f":
                new CMA().operate(this);
                return CMA.CYCLES;

            case "30":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "31":
                new LXI().operate(this);
                return LXI.CYCLES;
            case "32":
                new STA().operate(this);
                return STA.CYCLES;
            case "33":
                new INX(sp).operate(this);
                return INX.CYCLES;
            case "34":
                new INR().operate(this);
                return INR.CYCLES;
            case "35":
                new DCR().operate(this);
                return DCR.CYCLES;
            case "36":
                new MVI().operate(this);
                return MVI.CYCLES;
            case "37":
                new STC().operate(this);
                return STC.CYCLES;
            case "38":
                new NOP().operate(this);
                return NOP.CYCLES;
            case "39":
                new DAD(sp).operate(this);
                return DAD.CYCLES;
            case "3a":
                new LDA().operate(this);
                return LDA.CYCLES;
            case "3b":
                new DCX(sp).operate(this);
                return DCX.CYCLES;
            case "3c":
                new INR(registerA).operate(this);
                return INR.CYCLES;
            case "3d":
                new DCR(registerA).operate(this);
                return DCR.CYCLES;
            case "3e":
                new MVI(registerA).operate(this);
                return MVI.CYCLES;
            case "3f":
                new CMC().operate(this);
                return CMC.CYCLES;

            case "40":
                new MOV(registerB, registerB).operate(this);
                return MOV.CYCLES;
            case "41":
                new MOV(registerB, registerC).operate(this);
                return MOV.CYCLES;
            case "42":
                new MOV(registerB, registerD).operate(this);
                return MOV.CYCLES;
            case "43":
                new MOV(registerB, registerE).operate(this);
                return MOV.CYCLES;
            case "44":
                new MOV(registerB, registerH).operate(this);
                return MOV.CYCLES;
            case "45":
                new MOV(registerB, registerL).operate(this);
                return MOV.CYCLES;
            case "46":
                new MOV(registerB).operate(this);
                return MOV.CYCLES;
            case "47":
                new MOV(registerB, registerA).operate(this);
                return MOV.CYCLES;
            case "48":
                new MOV(registerC, registerB).operate(this);
                return MOV.CYCLES;
            case "49":
                new MOV(registerC, registerC).operate(this);
                return MOV.CYCLES;
            case "4a":
                new MOV(registerC, registerD).operate(this);
                return MOV.CYCLES;
            case "4b":
                new MOV(registerC, registerE).operate(this);
                return MOV.CYCLES;
            case "4c":
                new MOV(registerC, registerH).operate(this);
                return MOV.CYCLES;
            case "4d":
                new MOV(registerC, registerL).operate(this);
                return MOV.CYCLES;
            case "4e":
                new MOV(registerC).operate(this);
                return MOV.CYCLES;
            case "4f":
                new MOV(registerC, registerA).operate(this);
                return MOV.CYCLES;

            case "50":
                new MOV(registerD, registerB).operate(this);
                return MOV.CYCLES;
            case "51":
                new MOV(registerD, registerC).operate(this);
                return MOV.CYCLES;
            case "52":
                new MOV(registerD, registerD).operate(this);
                return MOV.CYCLES;
            case "53":
                new MOV(registerD, registerE).operate(this);
                return MOV.CYCLES;
            case "54":
                new MOV(registerD, registerH).operate(this);
                return MOV.CYCLES;
            case "55":
                new MOV(registerD, registerL).operate(this);
                return MOV.CYCLES;
            case "56":
                new MOV(registerD).operate(this);
                return MOV.CYCLES;
            case "57":
                new MOV(registerD, registerA).operate(this);
                return MOV.CYCLES;
            case "58":
                new MOV(registerE, registerB).operate(this);
                return MOV.CYCLES;
            case "59":
                new MOV(registerE, registerC).operate(this);
                return MOV.CYCLES;
            case "5a":
                new MOV(registerE, registerD).operate(this);
                return MOV.CYCLES;
            case "5b":
                new MOV(registerE, registerE).operate(this);
                return MOV.CYCLES;
            case "5c":
                new MOV(registerE, registerH).operate(this);
                return MOV.CYCLES;
            case "5d":
                new MOV(registerE, registerL).operate(this);
                return MOV.CYCLES;
            case "5e":
                new MOV(registerE).operate(this);
                return MOV.CYCLES;
            case "5f":
                new MOV(registerE, registerA).operate(this);
                return MOV.CYCLES;

            case "60":
                new MOV(registerH, registerB).operate(this);
                return MOV.CYCLES;
            case "61":
                new MOV(registerH, registerC).operate(this);
                return MOV.CYCLES;
            case "62":
                new MOV(registerH, registerD).operate(this);
                return MOV.CYCLES;
            case "63":
                new MOV(registerH, registerE).operate(this);
                return MOV.CYCLES;
            case "64":
                new MOV(registerH, registerH).operate(this);
                return MOV.CYCLES;
            case "65":
                new MOV(registerH, registerL).operate(this);
                return MOV.CYCLES;
            case "66":
                new MOV(registerH).operate(this);
                return MOV.CYCLES;
            case "67":
                new MOV(registerH, registerA).operate(this);
                return MOV.CYCLES;
            case "68":
                new MOV(registerL, registerB).operate(this);
                return MOV.CYCLES;
            case "69":
                new MOV(registerL, registerC).operate(this);
                return MOV.CYCLES;
            case "6a":
                new MOV(registerL, registerD).operate(this);
                return MOV.CYCLES;
            case "6b":
                new MOV(registerL, registerE).operate(this);
                return MOV.CYCLES;
            case "6c":
                new MOV(registerL, registerH).operate(this);
                return MOV.CYCLES;
            case "6d":
                new MOV(registerL, registerL).operate(this);
                return MOV.CYCLES;
            case "6e":
                new MOV(registerL).operate(this);
                return MOV.CYCLES;
            case "6f":
                new MOV(registerL, registerA).operate(this);
                return MOV.CYCLES;

            case "70":
                new MOV(null, registerB).operate(this);
                return MOV.CYCLES;
            case "71":
                new MOV(null, registerC).operate(this);
                return MOV.CYCLES;
            case "72":
                new MOV(null, registerD).operate(this);
                return MOV.CYCLES;
            case "73":
                new MOV(null, registerE).operate(this);
                return MOV.CYCLES;
            case "74":
                new MOV(null, registerH).operate(this);
                return MOV.CYCLES;
            case "75":
                new MOV(null, registerL).operate(this);
                return MOV.CYCLES;
            case "76":
                new HLT().operate(this);
                return HLT.CYCLES;
            case "77":
                new MOV(null, registerA).operate(this);
                return MOV.CYCLES;
            case "78":
                new MOV(registerA, registerB).operate(this);
                return MOV.CYCLES;
            case "79":
                new MOV(registerA, registerC).operate(this);
                return MOV.CYCLES;
            case "7a":
                new MOV(registerA, registerD).operate(this);
                return MOV.CYCLES;
            case "7b":
                new MOV(registerA, registerE).operate(this);
                return MOV.CYCLES;
            case "7c":
                new MOV(registerA, registerH).operate(this);
                return MOV.CYCLES;
            case "7d":
                new MOV(registerA, registerL).operate(this);
                return MOV.CYCLES;
            case "7e":
                new MOV(registerA).operate(this);
                return MOV.CYCLES;
            case "7f":
                new MOV(registerA, registerA).operate(this);
                return MOV.CYCLES;

            case "80":
                new ADD(registerB).operate(this);
                return ADD.CYCLES;
            case "81":
                new ADD(registerC).operate(this);
                return ADD.CYCLES;
            case "82":
                new ADD(registerD).operate(this);
                return ADD.CYCLES;
            case "83":
                new ADD(registerE).operate(this);
                return ADD.CYCLES;
            case "84":
                new ADD(registerH).operate(this);
                return ADD.CYCLES;
            case "85":
                new ADD(registerL).operate(this);
                return ADD.CYCLES;
            case "86":
                new ADD().operate(this);
                return ADD.CYCLES;
            case "87":
                new ADD(registerA).operate(this);
                return ADD.CYCLES;
            case "88":
                new ADC(registerB).operate(this);
                return ADC.CYCLES;
            case "89":
                new ADC(registerC).operate(this);
                return ADC.CYCLES;
            case "8a":
                new ADC(registerD).operate(this);
                return ADC.CYCLES;
            case "8b":
                new ADC(registerE).operate(this);
                return ADC.CYCLES;
            case "8c":
                new ADC(registerH).operate(this);
                return ADC.CYCLES;
            case "8d":
                new ADC(registerL).operate(this);
                return ADC.CYCLES;
            case "8e":
                new ADC().operate(this);
                return ADC.CYCLES;
            case "8f":
                new ADC(registerA).operate(this);
                return ADC.CYCLES;

            case "90":
                new SUB(registerB).operate(this);
                return SUB.CYCLES;
            case "91":
                new SUB(registerC).operate(this);
                return SUB.CYCLES;
            case "92":
                new SUB(registerD).operate(this);
                return SUB.CYCLES;
            case "93":
                new SUB(registerE).operate(this);
                return SUB.CYCLES;
            case "94":
                new SUB(registerH).operate(this);
                return SUB.CYCLES;
            case "95":
                new SUB(registerL).operate(this);
                return SUB.CYCLES;
            case "96":
                new SUB().operate(this);
                return SUB.CYCLES;
            case "97":
                new SUB(registerA).operate(this);
                return SUB.CYCLES;
            case "98":
                new SBB(registerB).operate(this);
                return SBB.CYCLES;
            case "99":
                new SBB(registerC).operate(this);
                return SBB.CYCLES;
            case "9a":
                new SBB(registerD).operate(this);
                return SBB.CYCLES;
            case "9b":
                new SBB(registerE).operate(this);
                return SBB.CYCLES;
            case "9c":
                new SBB(registerH).operate(this);
                return SBB.CYCLES;
            case "9d":
                new SBB(registerL).operate(this);
                return SBB.CYCLES;
            case "9e":
                new SBB().operate(this);
                return SBB.CYCLES;
            case "9f":
                new SBB(registerA).operate(this);
                return SBB.CYCLES;

            case "a0":
                new ANA(registerB).operate(this);
                return ANA.CYCLES;
            case "a1":
                new ANA(registerC).operate(this);
                return ANA.CYCLES;
            case "a2":
                new ANA(registerD).operate(this);
                return ANA.CYCLES;
            case "a3":
                new ANA(registerE).operate(this);
                return ANA.CYCLES;
            case "a4":
                new ANA(registerH).operate(this);
                return ANA.CYCLES;
            case "a5":
                new ANA(registerL).operate(this);
                return ANA.CYCLES;
            case "a6":
                new ANA().operate(this);
                return ANA.CYCLES;
            case "a7":
                new ANA(registerA).operate(this);
                return ANA.CYCLES;
            case "a8":
                new XRA(registerB).operate(this);
                return XRA.CYCLES;
            case "a9":
                new XRA(registerC).operate(this);
                return XRA.CYCLES;
            case "aa":
                new XRA(registerD).operate(this);
                return XRA.CYCLES;
            case "ab":
                new XRA(registerE).operate(this);
                return XRA.CYCLES;
            case "ac":
                new XRA(registerH).operate(this);
                return XRA.CYCLES;
            case "ad":
                new XRA(registerL).operate(this);
                return XRA.CYCLES;
            case "ae":
                new XRA().operate(this);
                return XRA.CYCLES;
            case "af":
                new XRA(registerA).operate(this);
                return XRA.CYCLES;

            case "b0":
                new ORA(registerB).operate(this);
                return ORA.CYCLES;
            case "b1":
                new ORA(registerC).operate(this);
                return ORA.CYCLES;
            case "b2":
                new ORA(registerD).operate(this);
                return ORA.CYCLES;
            case "b3":
                new ORA(registerE).operate(this);
                return ORA.CYCLES;
            case "b4":
                new ORA(registerH).operate(this);
                return ORA.CYCLES;
            case "b5":
                new ORA(registerL).operate(this);
                return ORA.CYCLES;
            case "b6":
                new ORA().operate(this);
                return ORA.CYCLES;
            case "b7":
                new ORA(registerA).operate(this);
                return ORA.CYCLES;
            case "b8":
                new CMP(registerB).operate(this);
                return CMP.CYCLES;
            case "b9":
                new CMP(registerC).operate(this);
                return CMP.CYCLES;
            case "ba":
                new CMP(registerD).operate(this);
                return CMP.CYCLES;
            case "bb":
                new CMP(registerE).operate(this);
                return CMP.CYCLES;
            case "bc":
                new CMP(registerH).operate(this);
                return CMP.CYCLES;
            case "bd":
                new CMP(registerL).operate(this);
                return CMP.CYCLES;
            case "be":
                new CMP().operate(this);
                return CMP.CYCLES;
            case "bf":
                new CMP(registerA).operate(this);
                return CMP.CYCLES;

            case "c0":
                new RNZ().operate(this);
                return RNZ.CYCLES;
            case "c1":
                new POP(registerB, registerC).operate(this);
                return POP.CYCLES;
            case "c2":
                new JNZ().operate(this);
                return JNZ.CYCLES;
            case "c3":
                new JMP().operate(this);
                return JMP.CYCLES;
            case "c4":
                new CNZ().operate(this);
                return CNZ.CYCLES;
            case "c5":
                new PUSH(registerB, registerC).operate(this);
                return PUSH.CYCLES;
            case "c6":
                new ADI().operate(this);
                return ADI.CYCLES;
            case "c7":
                new RST((byte) 0x0).operate(this);
                return RST.CYCLES;
            case "c8":
                new RZ().operate(this);
                return RZ.CYCLES;
            case "c9":
                new RET().operate(this);
                return RET.CYCLES;
            case "ca":
                new JZ().operate(this);
                return JZ.CYCLES;
            case "cb":
                new JMP().operate(this);
                return JMP.CYCLES;
            case "cc":
                new CZ().operate(this);
                return CZ.CYCLES;
            case "cd":
                new CALL().operate(this);
                return CALL.CYCLES;
            case "ce":
                new ACI().operate(this);
                return ACI.CYCLES;
            case "cf":
                new RST((byte) 1).operate(this);
                return RST.CYCLES;

            case "d0":
                new RNC().operate(this);
                return RNC.CYCLES;
            case "d1":
                new POP(registerD, registerE).operate(this);
                return POP.CYCLES;
            case "d2":
                new JNC().operate(this);
                return JNC.CYCLES;
            case "d3": throw new UnimplementedInstructionError();
            case "d4":
                new CNC().operate(this);
                return CNC.CYCLES;
            case "d5":
                new PUSH(registerD, registerE).operate(this);
                return PUSH.CYCLES;
            case "d6":
                new SUI().operate(this);
                return SUI.CYCLES;
            case "d7":
                new RST((byte) 0x2).operate(this);
                return RST.CYCLES;
            case "d8":
                new RC().operate(this);
                return RC.CYCLES;
            case "d9":
                new RET().operate(this);
                return RET.CYCLES;
            case "da":
                new JC().operate(this);
                return JC.CYCLES;
            case "db": throw new UnimplementedInstructionError();
            case "dc":
                new CC().operate(this);
                return CC.CYCLES;
            case "dd":
                new CALL().operate(this);
                return CALL.CYCLES;
            case "de":
                new SBI().operate(this);
                return SBI.CYCLES;
            case "df":
                new RST((byte) 3).operate(this);
                return RST.CYCLES;

            case "e0":
                new RPO().operate(this);
                return RPO.CYCLES;
            case "e1":
                new POP(registerH, registerL).operate(this);
                return POP.CYCLES;
            case "e2":
                new JPO().operate(this);
                return JPO.CYCLES;
            case "e3":
                new XTHL().operate(this);
                return XTHL.CYCLES;
            case "e4":
                new CPO().operate(this);
                return CPO.CYCLES;
            case "e5":
                new PUSH(registerH, registerL).operate(this);
                return PUSH.CYCLES;
            case "e6":
                new ANI().operate(this);
                return ANI.CYCLES;
            case "e7":
                new RST((byte) 4).operate(this);
                return RST.CYCLES;
            case "e8":
                new RPE().operate(this);
                return RPE.CYCLES;
            case "e9":
                new PCHL().operate(this);
                return PCHL.CYCLES;
            case "ea":
                new JPE().operate(this);
                return JPE.CYCLES;
            case "eb":
                new XCHG().operate(this);
                return XCHG.CYCLES;
            case "ec":
                new CPE().operate(this);
                return CPE.CYCLES;
            case "ed":
                new CALL().operate(this);
                return CALL.CYCLES;
            case "ee":
                new XRI().operate(this);
                return XRI.CYCLES;
            case "ef":
                new RST((byte) 5).operate(this);
                return RST.CYCLES;

            case "f0":
                new RP().operate(this);
                return RP.CYCLES;
            case "f1":
                new POP(registerPSW).operate(this);
                return POP.CYCLES;
            case "f2":
                new JP().operate(this);
                return JP.CYCLES;
            case "f3":
                new DI().operate(this);
                return DI.CYCLES;
            case "f4":
                new CP().operate(this);
                return CP.CYCLES;
            case "f5":
                new PUSH(registerPSW).operate(this);
                return PUSH.CYCLES;
            case "f6":
                new ORI().operate(this);
                return ORI.CYCLES;
            case "f7":
                new RST((byte) 6).operate(this);
                return RST.CYCLES;
            case "f8":
                new RM().operate(this);
                return RM.CYCLES;
            case "f9":
                new SPHL().operate(this);
                return SPHL.CYCLES;
            case "fa":
                new JM().operate(this);
                return JM.CYCLES;
            case "fb":
                new EI().operate(this);
                return EI.CYCLES;
            case "fc":
                new CM().operate(this);
                return CM.CYCLES;
            case "fd":
                new CALL().operate(this);
                return CALL.CYCLES;
            case "fe":
                new CPI().operate(this);
                return CPI.CYCLES;
            case "ff":
                new RST((byte) 7).operate(this);
                return RST.CYCLES;
            default:
                return 0;

        }
    }

    public byte[] getMemory() {
        return this.memory;
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

    public boolean getStopped() {
        return this.stopped;
    }

    public void writeMemory(byte register, int memoryLocation){
//        if(memoryLocation < 0x2000){
//            System.out.println("Error, cannot write to ROM");
//        if(memoryLocation >= 0x4000){
//            System.out.println("Can't write outside of loaded user application");
//        }
        memory[memoryLocation] = register;
    }

}
