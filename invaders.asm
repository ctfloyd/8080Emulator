NOP
NOP
NOP
JMP      $18d4   
NOP
NOP
PUSH     PSW     
PUSH     B       
PUSH     D       
PUSH     H       
JMP      $008c   
NOP
PUSH     PSW     
PUSH     B       
PUSH     D       
PUSH     H       
MVI      A,#$80  
STA      $2072   
LXI      H,#$20c0
DCR      M       
CALL     $17cd   
IN       $#01    
RRC
JC       $0067   
LDA      $20ea   
ANA      A       
JZ       $0042   
LDA      $20eb   
CPI      #$99    
JZ       $003e   
ADI      #$01    
DAA
STA      $20eb   
CALL     $1947   
XRA      A       
STA      $20ea   
LDA      $20e9   
ANA      A       
JZ       $0082   
LDA      $20ef   
ANA      A       
JNZ      $006f   
LDA      $20eb   
ANA      A       
JNZ      $005d   
CALL     $0abf   
JMP      $0082   
LDA      $2093   
ANA      A       
JNZ      $0082   
JMP      $0765   
MVI      A,#$01  
STA      $20ea   
JMP      $003f   
CALL     $1740   
LDA      $2032   
STA      $2080   
CALL     $0100   
CALL     $0248   
CALL     $0913   
NOP
POP      H       
POP      D       
POP      B       
POP      PSW     
EI
RET
NOP
NOP
NOP
NOP
XRA      A       
STA      $2072   
LDA      $20e9   
ANA      A       
JZ       $0082   
LDA      $20ef   
ANA      A       
JNZ      $00a5   
LDA      $20c1   
RRC
JNC      $0082   
LXI      H,#$2020
CALL     $024b   
CALL     $0141   
JMP      $0082   
CALL     $0886   
PUSH     H       
MOV      A,M     
INX      H       
MOV      H,M     
MOV      L,A     
SHLD     $2009   
SHLD     $200b   
POP      H       
DCX      H       
MOV      A,M     
CPI      #$03    
JNZ      $00c8   
DCR      A       
STA      $2008   
CPI      #$fe    
MVI      A,#$00  
JNZ      $00d3   
INR      A       
STA      $200d   
RET
MVI      A,#$02  
STA      $21fb   
STA      $22fb   
JMP      $08e4   
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
LXI      H,#$2002
MOV      A,M     
ANA      A       
JNZ      $1538   
PUSH     H       
LDA      $2006   
MOV      L,A     
LDA      $2067   
MOV      H,A     
MOV      A,M     
ANA      A       
POP      H       
JZ       $0136   
INX      H       
INX      H       
MOV      A,M     
INX      H       
MOV      B,M     
ANI      #$fe    
RLC
RLC
RLC
MOV      E,A     
MVI      D,#$00  
LXI      H,#$1c00
DAD      D       
XCHG
MOV      A,B     
ANA      A       
CNZ      $013b   
LHLD     $200b   
MVI      B,#$10  
CALL     $15d3   
XRA      A       
STA      $2000   
RET
LXI      H,#$0030
DAD      D       
XCHG
RET
LDA      $2068   
ANA      A       
RZ
LDA      $2000   
ANA      A       
RNZ
LDA      $2067   
MOV      H,A     
LDA      $2006   
MVI      D,#$02  
INR      A       
CPI      #$37    
CZ       $01a1   
MOV      L,A     
MOV      B,M     
DCR      B       
JNZ      $0154   
STA      $2006   
CALL     $017a   
MOV      H,C     
SHLD     $200b   
MOV      A,L     
CPI      #$28    
JC       $1971   
MOV      A,D     
STA      $2004   
MVI      A,#$01  
STA      $2000   
RET
MVI      D,#$00  
MOV      A,L     
LXI      H,#$2009
MOV      B,M     
INX      H       
MOV      C,M     
CPI      #$0b    
JM       $0194   
SBI      #$0b    
MOV      E,A     
MOV      A,B     
ADI      #$10    
MOV      B,A     
MOV      A,E     
INR      D       
JMP      $0183   
MOV      L,B     
ANA      A       
RZ
MOV      E,A     
MOV      A,C     
ADI      #$10    
MOV      C,A     
MOV      A,E     
DCR      A       
JMP      $0195   
DCR      D       
JZ       $01cd   
LXI      H,#$2006
MVI      M,#$00  
INX      H       
MOV      C,M     
MVI      M,#$00  
CALL     $01d9   
LXI      H,#$2005
MOV      A,M     
INR      A       
ANI      #$01    
MOV      M,A     
XRA      A       
LXI      H,#$2067
MOV      H,M     
RET
NOP
LXI      H,#$2100
MVI      B,#$37  
MVI      M,#$01  
INX      H       
DCR      B       
JNZ      $01c5   
RET
POP      H       
RET
MVI      A,#$01  
MVI      B,#$e0  
LXI      H,#$2402
JMP      $14cc   
INX      H       
MOV      B,M     
INX      H       
MOV      A,C     
ADD      M       
MOV      M,A     
INX      H       
MOV      A,B     
ADD      M       
MOV      M,A     
RET
MVI      B,#$c0  
LXI      D,#$1b00
LXI      H,#$2000
JMP      $1a32   
LXI      H,#$2142
JMP      $01f8   
LXI      H,#$2242
MVI      C,#$04  
LXI      D,#$1d20
PUSH     D       
MVI      B,#$2c  
CALL     $1a32   
POP      D       
DCR      C       
JNZ      $01fd   
RET
MVI      A,#$01  
JMP      $021b   
MVI      A,#$01  
JMP      $0214   
XRA      A       
LXI      D,#$2242
JMP      $021e   
XRA      A       
LXI      D,#$2142
STA      $2081   
LXI      B,#$1602
LXI      H,#$2806
MVI      A,#$04  
PUSH     PSW     
PUSH     B       
LDA      $2081   
ANA      A       
JNZ      $0242   
CALL     $1a69   
POP      B       
POP      PSW     
DCR      A       
RZ
PUSH     D       
LXI      D,#$02e0
DAD      D       
POP      D       
JMP      $0229   
CALL     $147c   
JMP      $0235   
LXI      H,#$2010
MOV      A,M     
CPI      #$ff    
RZ
CPI      #$fe    
JZ       $0281   
INX      H       
MOV      B,M     
MOV      C,A     
ORA      B       
MOV      A,C     
JNZ      $0277   
INX      H       
MOV      A,M     
ANA      A       
JNZ      $0288   
INX      H       
MOV      E,M     
INX      H       
MOV      D,M     
PUSH     H       
XCHG
PUSH     H       
LXI      H,#$026f
XHTL
PUSH     D       
PCHL
POP      H       
LXI      D,#$000c
DAD      D       
JMP      $024b   
DCR      B       
INR      B       
JNZ      $027d   
DCR      A       
DCR      B       
MOV      M,B     
DCX      H       
MOV      M,A     
LXI      D,#$0010
DAD      D       
JMP      $024b   
DCR      M       
DCX      H       
DCX      H       
JMP      $0281   
POP      H       
INX      H       
MOV      A,M     
CPI      #$ff    
JZ       $033b   
INX      H       
DCR      M       
RNZ
MOV      B,A     
XRA      A       
STA      $2068   
STA      $2069   
MVI      A,#$30  
STA      $206a   
MOV      A,B     
MVI      M,#$05  
INX      H       
DCR      M       
JNZ      $039b   
LHLD     $201a   
MVI      B,#$10  
CALL     $1424   
LXI      H,#$2010
LXI      D,#$1b10
MVI      B,#$10  
CALL     $1a32   
MVI      B,#$00  
CALL     $19dc   
LDA      $206d   
ANA      A       
RNZ
LDA      $20ef   
ANA      A       
RZ
LXI      SP,#$2400
EI
CALL     $19d7   
CALL     $092e   
ANA      A       
JZ       $166d   
CALL     $18e7   
MOV      A,M     
ANA      A       
JZ       $032c   
LDA      $20ce   
ANA      A       
JZ       $032c   
LDA      $2067   
PUSH     PSW     
RRC
JC       $0332   
CALL     $020e   
CALL     $0878   
MOV      M,E     
INX      H       
MOV      M,D     
DCX      H       
DCX      H       
MOV      M,B     
NOP
CALL     $01e4   
POP      PSW     
RRC
MVI      A,#$21  
MVI      B,#$00  
JNC      $0312   
MVI      B,#$20  
MVI      A,#$22  
STA      $2067   
CALL     $0ab6   
XRA      A       
STA      $2011   
MOV      A,B     
OUT      #$05    
INR      A       
STA      $2098   
CALL     $09d6   
CALL     $1a7f   
JMP      $07f9   
CALL     $1a7f   
JMP      $0817   
CALL     $0209   
JMP      $02f8   
NOP
NOP
NOP
LXI      H,#$2068
MVI      M,#$01  
INX      H       
MOV      A,M     
ANA      A       
JMP      $03b0   
NOP
DCX      H       
MVI      M,#$01  
LDA      $201b   
MOV      B,A     
LDA      $20ef   
ANA      A       
JNZ      $0363   
LDA      $201d   
RRC
JC       $0381   
RRC
JC       $038e   
JMP      $036f   
CALL     $17c0   
RLC
RLC
JC       $0381   
RLC
JC       $038e   
LXI      H,#$2018
CALL     $1a3b   
CALL     $1a47   
CALL     $1439   
MVI      A,#$00  
STA      $2012   
RET
MOV      A,B     
CPI      #$d9    
JZ       $036f   
INR      A       
STA      $201b   
JMP      $036f   
MOV      A,B     
CPI      #$30    
JZ       $036f   
DCR      A       
STA      $201b   
JMP      $036f   
INR      A       
ANI      #$01    
STA      $2015   
RLC
RLC
RLC
RLC
LXI      H,#$1c70
ADD      L       
MOV      L,A     
SHLD     $2018   
JMP      $036f   
JNZ      $034a   
INX      H       
DCR      M       
JNZ      $034a   
JMP      $0346   
LXI      D,#$202a
CALL     $1a06   
POP      H       
RNC
INX      H       
MOV      A,M     
ANA      A       
RZ
CPI      #$01    
JZ       $03fa   
CPI      #$02    
JZ       $040a   
INX      H       
CPI      #$03    
JNZ      $042a   
DCR      M       
JZ       $0436   
MOV      A,M     
CPI      #$0f    
RNZ
PUSH     H       
CALL     $0430   
CALL     $1452   
POP      H       
INX      H       
INR      M       
INX      H       
INX      H       
DCR      M       
DCR      M       
INX      H       
DCR      M       
DCR      M       
DCR      M       
INX      H       
MVI      M,#$08  
CALL     $0430   
JMP      $1400   
INR      A       
MOV      M,A     
LDA      $201b   
ADI      #$08    
STA      $202a   
CALL     $0430   
JMP      $1400   
CALL     $0430   
PUSH     D       
PUSH     H       
PUSH     B       
CALL     $1452   
POP      B       
POP      H       
POP      D       
LDA      $202c   
ADD      L       
MOV      L,A     
STA      $2029   
CALL     $1491   
LDA      $2061   
ANA      A       
RZ
STA      $2002   
RET
CPI      #$05    
RZ
JMP      $0436   
LXI      H,#$2027
JMP      $1a3b   
CALL     $0430   
CALL     $1452   
LXI      H,#$2025
LXI      D,#$1b25
MVI      B,#$07  
CALL     $1a32   
LHLD     $208d   
INR      L       
MOV      A,L     
CPI      #$63    
JC       $0453   
MVI      L,#$54  
SHLD     $208d   
LHLD     $208f   
INR      L       
SHLD     $208f   
LDA      $2084   
ANA      A       
RNZ
MOV      A,M     
ANI      #$01    
LXI      B,#$0229
JNZ      $046e   
LXI      B,#$fee0
LXI      H,#$208a
MOV      M,C     
INX      H       
INX      H       
MOV      M,B     
RET
POP      H       
LDA      $1b32   
STA      $2032   
LHLD     $2038   
MOV      A,L     
ORA      H       
JNZ      $048a   
DCX      H       
SHLD     $2038   
RET
LXI      D,#$2035
MVI      A,#$f9  
CALL     $0550   
LDA      $2046   
STA      $2070   
LDA      $2056   
STA      $2071   
CALL     $0563   
LDA      $2078   
ANA      A       
LXI      H,#$2035
JNZ      $055b   
LXI      D,#$1b30
LXI      H,#$2030
MVI      B,#$10  
JMP      $1a32   
POP      H       
LDA      $206e   
ANA      A       
RNZ
LDA      $2080   
CPI      #$01    
RNZ
LXI      D,#$2045
MVI      A,#$ed  
CALL     $0550   
LDA      $2036   
STA      $2070   
LDA      $2056   
STA      $2071   
CALL     $0563   
LDA      $2076   
CPI      #$10    
JC       $04e7   
LDA      $1b48   
STA      $2076   
LDA      $2078   
ANA      A       
LXI      H,#$2045
JNZ      $055b   
LXI      D,#$1b40
LXI      H,#$2040
MVI      B,#$10  
CALL     $1a32   
LDA      $2082   
DCR      A       
JNZ      $0508   
MVI      A,#$01  
STA      $206e   
LHLD     $2076   
JMP      $067e   
POP      H       
LXI      D,#$2055
MVI      A,#$db  
CALL     $0550   
LDA      $2046   
STA      $2070   
LDA      $2036   
STA      $2071   
CALL     $0563   
LDA      $2076   
CPI      #$15    
JC       $0534   
LDA      $1b58   
STA      $2076   
LDA      $2078   
ANA      A       
LXI      H,#$2055
JNZ      $055b   
LXI      D,#$1b50
LXI      H,#$2050
MVI      B,#$10  
CALL     $1a32   
LHLD     $2076   
SHLD     $2058   
RET
STA      $207f   
LXI      H,#$2073
MVI      B,#$0b  
JMP      $1a32   
LXI      D,#$2073
MVI      B,#$0b  
JMP      $1a32   
LXI      H,#$2073
MOV      A,M     
ANI      #$80    
JNZ      $05c1   
LDA      $20c1   
CPI      #$04    
LDA      $2069   
JZ       $05b7   
ANA      A       
RZ
INX      H       
MVI      M,#$00  
LDA      $2070   
ANA      A       
JZ       $0589   
MOV      B,A     
LDA      $20cf   
CMP      B       
RNC
LDA      $2071   
ANA      A       
JZ       $0596   
MOV      B,A     
LDA      $20cf   
CMP      B       
RNC
INX      H       
MOV      A,M     
ANA      A       
JZ       $061b   
LHLD     $2076   
MOV      C,M     
INX      H       
NOP
SHLD     $2076   
CALL     $062f   
RNC
CALL     $017a   
MOV      A,C     
ADI      #$07    
MOV      H,A     
MOV      A,L     
SUI      #$0a    
MOV      L,A     
SHLD     $207b   
LXI      H,#$2073
MOV      A,M     
ORI      #$80    
MOV      M,A     
INX      H       
INR      M       
RET
LXI      D,#$207c
CALL     $1a06   
RNC
INX      H       
MOV      A,M     
ANI      #$01    
JNZ      $0644   
INX      H       
INR      M       
CALL     $0675   
LDA      $2079   
ADI      #$03    
LXI      H,#$207f
CMP      M       
JC       $05e2   
SUI      #$0c    
STA      $2079   
LDA      $207b   
MOV      B,A     
LDA      $207e   
ADD      B       
STA      $207b   
CALL     $066c   
LDA      $207b   
CPI      #$15    
JC       $0612   
LDA      $2061   
ANA      A       
RZ
LDA      $207b   
CPI      #$1e    
JC       $0612   
CPI      #$27    
NOP
JNC      $0612   
SUB      A       
STA      $2015   
LDA      $2073   
ORI      #$01    
STA      $2073   
RET
LDA      $201b   
ADI      #$08    
MOV      H,A     
CALL     $156f   
MOV      A,C     
CPI      #$0c    
JC       $05a5   
MVI      C,#$0b  
JMP      $05a5   
DCR      C       
LDA      $2067   
MOV      H,A     
MOV      L,C     
MVI      D,#$05  
MOV      A,M     
ANA      A       
STC
RNZ
MOV      A,L     
ADI      #$0b    
MOV      L,A     
DCR      D       
JNZ      $0637   
RET
LXI      H,#$2078
DCR      M       
MOV      A,M     
CPI      #$03    
JNZ      $0667   
CALL     $0675   
LXI      H,#$1cdc
SHLD     $2079   
LXI      H,#$207c
DCR      M       
DCR      M       
DCX      H       
DCR      M       
DCR      M       
MVI      A,#$06  
STA      $207d   
JMP      $066c   
ANA      A       
RNZ
JMP      $0675   
LXI      H,#$2079
CALL     $1a3b   
JMP      $1491   
LXI      H,#$2079
CALL     $1a3b   
JMP      $1452   
SHLD     $2048   
RET
POP      H       
LDA      $2080   
CPI      #$02    
RNZ
LXI      H,#$2083
MOV      A,M     
ANA      A       
JZ       $050f   
LDA      $2056   
ANA      A       
JNZ      $050f   
INX      H       
MOV      A,M     
ANA      A       
JNZ      $06ab   
LDA      $2082   
CPI      #$08    
JC       $050f   
MVI      M,#$01  
CALL     $073c   
LXI      D,#$208a
CALL     $1a06   
RNC
LXI      H,#$2085
MOV      A,M     
ANA      A       
JNZ      $06d6   
LXI      H,#$208a
MOV      A,M     
INX      H       
INX      H       
ADD      M       
STA      $208a   
CALL     $073c   
LXI      H,#$208a
MOV      A,M     
CPI      #$28    
JC       $06f9   
CPI      #$e1    
JNC      $06f9   
RET
MVI      B,#$fe  
CALL     $19dc   
INX      H       
DCR      M       
MOV      A,M     
CPI      #$1f    
JZ       $074b   
CPI      #$18    
JZ       $070c   
ANA      A       
RNZ
MVI      B,#$ef  
LXI      H,#$2098
MOV      A,M     
ANA      B       
MOV      M,A     
ANI      #$20    
OUT      #$05    
NOP
NOP
NOP
CALL     $0742   
CALL     $14cb   
LXI      H,#$2083
MVI      B,#$0a  
CALL     $075f   
MVI      B,#$fe  
JMP      $19dc   
MVI      A,#$01  
STA      $20f1   
LHLD     $208d   
MOV      B,M     
MVI      C,#$04  
LXI      H,#$1d50
LXI      D,#$1d4c
LDAX     D       
CMP      B       
JZ       $0728   
INX      H       
INX      D       
DCR      C       
JNZ      $071d   
MOV      A,M     
STA      $2087   
MVI      H,#$00  
MOV      L,B     
DAD      H       
DAD      H       
DAD      H       
DAD      H       
SHLD     $20f2   
CALL     $0742   
JMP      $08f1   
CALL     $0742   
JMP      $1439   
LXI      H,#$2087
CALL     $1a3b   
JMP      $1a47   
MVI      B,#$10  
LXI      H,#$2098
MOV      A,M     
ORA      B       
MOV      M,A     
CALL     $1770   
LXI      H,#$1d7c
SHLD     $2087   
JMP      $073c   
LXI      D,#$1b83
JMP      $1a32   
MVI      A,#$01  
STA      $2093   
LXI      SP,#$2400
EI
CALL     $1979   
CALL     $09d6   
LXI      H,#$3013
LXI      D,#$1ff3
MVI      C,#$04  
CALL     $08f3   
LDA      $20eb   
DCR      A       
LXI      H,#$2810
MVI      C,#$14  
JNZ      $0857   
LXI      D,#$1acf
CALL     $08f3   
IN       $#01    
ANI      #$04    
JZ       $077f   
MVI      B,#$99  
XRA      A       
STA      $20ce   
LDA      $20eb   
ADD      B       
DAA
STA      $20eb   
CALL     $1947   
LXI      H,#$0000
SHLD     $20f8   
SHLD     $20fc   
CALL     $1925   
CALL     $192b   
CALL     $19d7   
LXI      H,#$0101
MOV      A,H     
STA      $20ef   
SHLD     $20e7   
SHLD     $20e5   
CALL     $1956   
CALL     $01ef   
CALL     $01f5   
CALL     $08d1   
STA      $21ff   
STA      $22ff   
CALL     $00d7   
XRA      A       
STA      $21fe   
STA      $22fe   
CALL     $01c0   
CALL     $1904   
LXI      H,#$3878
SHLD     $21fc   
SHLD     $22fc   
CALL     $01e4   
CALL     $1a7f   
CALL     $088d   
CALL     $09d6   
NOP
XRA      A       
STA      $20c1   
CALL     $01cf   
LDA      $2067   
RRC
JC       $0872   
CALL     $0213   
CALL     $01cf   
CALL     $00b1   
CALL     $19d1   
MVI      B,#$20  
CALL     $18fa   
CALL     $1618   
CALL     $190a   
CALL     $15f3   
CALL     $0988   
LDA      $2082   
ANA      A       
JZ       $09ef   
CALL     $170e   
CALL     $0935   
CALL     $08d8   
CALL     $172c   
CALL     $0a59   
JZ       $0849   
MVI      B,#$04  
CALL     $18fa   
CALL     $1775   
OUT      #$06    
CALL     $1804   
JMP      $081f   
NOP
NOP
NOP
LXI      D,#$1aba
CALL     $08f3   
MVI      B,#$98  
IN       $#01    
RRC
RRC
JC       $086d   
RRC
JC       $0798   
JMP      $077f   
MVI      A,#$01  
JMP      $079b   
CALL     $021a   
JMP      $0814   
LDA      $2008   
MOV      B,A     
LHLD     $2009   
XCHG
JMP      $0886   
NOP
NOP
NOP
LDA      $2067   
MOV      H,A     
MVI      L,#$fc  
RET
LXI      H,#$2b11
LXI      D,#$1b70
MVI      C,#$0e  
CALL     $08f3   
LDA      $2067   
RRC
MVI      A,#$1c  
LXI      H,#$3711
CNC      $08ff   
MVI      A,#$b0  
STA      $20c0   
LDA      $20c0   
ANA      A       
RZ
ANI      #$04    
JNZ      $08bc   
CALL     $09ca   
CALL     $1931   
JMP      $08a9   
MVI      B,#$20  
LXI      H,#$271c
LDA      $2067   
RRC
JC       $08cb   
LXI      H,#$391c
CALL     $14cb   
JMP      $08a9   
IN       $#02    
ANI      #$03    
ADI      #$03    
RET
LDA      $2082   
CPI      #$09    
RNC
MVI      A,#$fb  
STA      $207e   
RET
LDA      $20ce   
ANA      A       
RNZ
LXI      H,#$391c
MVI      B,#$20  
JMP      $14cb   
MVI      C,#$03  
LDAX     D       
PUSH     D       
CALL     $08ff   
POP      D       
INX      D       
DCR      C       
JNZ      $08f3   
RET
LXI      D,#$1e00
PUSH     H       
MVI      H,#$00  
MOV      L,A     
DAD      H       
DAD      H       
DAD      H       
DAD      D       
XCHG
POP      H       
MVI      B,#$08  
OUT      #$06    
JMP      $1439   
LDA      $2009   
CPI      #$78    
RNC
LHLD     $2091   
MOV      A,L     
ORA      H       
JNZ      $0929   
LXI      H,#$0600
MVI      A,#$01  
STA      $2083   
DCX      H       
SHLD     $2091   
RET
CALL     $1611   
MVI      L,#$ff  
MOV      A,M     
RET
CALL     $1910   
DCX      H       
DCX      H       
MOV      A,M     
ANA      A       
RZ
MVI      B,#$15  
IN       $#02    
ANI      #$08    
JZ       $0948   
MVI      B,#$10  
CALL     $09ca   
INX      H       
MOV      A,M     
CMP      B       
RC
CALL     $092e   
INR      M       
MOV      A,M     
PUSH     PSW     
LXI      H,#$2501
INR      H       
INR      H       
DCR      A       
JNZ      $0958   
MVI      B,#$10  
LXI      D,#$1c60
CALL     $1439   
POP      PSW     
INR      A       
CALL     $1a8b   
CALL     $1910   
DCX      H       
DCX      H       
MVI      M,#$00  
MVI      A,#$ff  
STA      $2099   
MVI      B,#$10  
JMP      $18fa   
LXI      H,#$1da0
CPI      #$02    
RC
INX      H       
CPI      #$04    
RC
INX      H       
RET
CALL     $09ca   
LDA      $20f1   
ANA      A       
RZ
XRA      A       
STA      $20f1   
PUSH     H       
LHLD     $20f2   
XCHG
POP      H       
MOV      A,M     
ADD      E       
DAA
MOV      M,A     
MOV      E,A     
INX      H       
MOV      A,M     
ADC      D       
DAA
MOV      M,A     
MOV      D,A     
INX      H       
MOV      A,M     
INX      H       
MOV      H,M     
MOV      L,A     
JMP      $09ad   
MOV      A,D     
CALL     $09b2   
MOV      A,E     
PUSH     D       
PUSH     PSW     
RRC
RRC
RRC
RRC
ANI      #$0f    
CALL     $09c5   
POP      PSW     
ANI      #$0f    
CALL     $09c5   
POP      D       
RET
ADI      #$1a    
JMP      $08ff   
LDA      $2067   
RRC
LXI      H,#$20f8
RC
LXI      H,#$20fc
RET
LXI      H,#$2402
MVI      M,#$00  
INX      H       
MOV      A,L     
ANI      #$1f    
CPI      #$1c    
JC       $09e8   
LXI      D,#$0006
DAD      D       
MOV      A,H     
CPI      #$40    
JC       $09d9   
RET
CALL     $0a3c   
XRA      A       
STA      $20e9   
CALL     $09d6   
LDA      $2067   
PUSH     PSW     
CALL     $01e4   
POP      PSW     
STA      $2067   
LDA      $2067   
MOV      H,A     
PUSH     H       
MVI      L,#$fe  
MOV      A,M     
ANI      #$07    
INR      A       
MOV      M,A     
LXI      H,#$1da2
INX      H       
DCR      A       
JNZ      $0a13   
MOV      A,M     
POP      H       
MVI      L,#$fc  
MOV      M,A     
INX      H       
MVI      M,#$38  
MOV      A,H     
RRC
JC       $0a33   
MVI      A,#$21  
STA      $2098   
CALL     $01f5   
CALL     $1904   
JMP      $0804   
CALL     $01ef   
CALL     $01c0   
JMP      $0804   
CALL     $0a59   
JNZ      $0a52   
MVI      A,#$30  
STA      $20c0   
LDA      $20c0   
ANA      A       
RZ
CALL     $0a59   
JZ       $0a47   
CALL     $0a59   
JNZ      $0a52   
RET
LDA      $2015   
CPI      #$ff    
RET
LDA      $20ef   
ANA      A       
JZ       $0a7c   
MOV      C,B     
MVI      B,#$08  
CALL     $18fa   
MOV      B,C     
MOV      A,B     
CALL     $097c   
MOV      A,M     
LXI      H,#$20f3
MVI      M,#$00  
DCX      H       
MOV      M,A     
DCX      H       
MVI      M,#$01  
LXI      H,#$2062
RET
MVI      A,#$02  
STA      $20c1   
OUT      #$06    
LDA      $20cb   
ANA      A       
JZ       $0a85   
XRA      A       
STA      $20c1   
RET
PUSH     D       
LDAX     D       
CALL     $08ff   
POP      D       
MVI      A,#$07  
STA      $20c0   
LDA      $20c0   
DCR      A       
JNZ      $0a9e   
INX      D       
DCR      C       
JNZ      $0a93   
RET
LXI      H,#$2050
JMP      $024b   
MVI      A,#$40  
JMP      $0ad7   
MVI      A,#$80  
JMP      $0ad7   
POP      H       
JMP      $0072   
LDA      $20c1   
RRC
JC       $0abb   
RRC
JC       $1868   
RRC
JC       $0aab   
RET
LXI      H,#$2b14
MVI      C,#$0f  
JMP      $0a93   
STA      $20c0   
LDA      $20c0   
ANA      A       
JNZ      $0ada   
RET
LXI      H,#$20c2
MVI      B,#$0c  
JMP      $1a32   
XRA      A       
OUT      #$03    
OUT      #$05    
CALL     $1982   
EI
CALL     $0ab1   
LDA      $20ec   
ANA      A       
LXI      H,#$3017
MVI      C,#$04  
JNZ      $0be8   
LXI      D,#$1cfa
CALL     $0a93   
LXI      D,#$1daf
CALL     $0acf   
CALL     $0ab1   
CALL     $1815   
CALL     $0ab6   
LDA      $20ec   
ANA      A       
JNZ      $0b4a   
LXI      D,#$1a95
CALL     $0ae2   
CALL     $0a80   
LXI      D,#$1bb0
CALL     $0ae2   
CALL     $0a80   
CALL     $0ab1   
LXI      D,#$1fc9
CALL     $0ae2   
CALL     $0a80   
CALL     $0ab1   
LXI      H,#$33b7
MVI      B,#$0a  
CALL     $14cb   
CALL     $0ab6   
CALL     $09d6   
LDA      $21ff   
ANA      A       
JNZ      $0b5d   
CALL     $08d1   
STA      $21ff   
CALL     $1a7f   
CALL     $01e4   
CALL     $01c0   
CALL     $01ef   
CALL     $021a   
MVI      A,#$01  
STA      $20c1   
CALL     $01cf   
CALL     $1618   
CALL     $0bf1   
OUT      #$06    
CALL     $0a59   
JZ       $0b71   
XRA      A       
STA      $2025   
CALL     $0a59   
JNZ      $0b83   
XRA      A       
STA      $20c1   
CALL     $0ab1   
CALL     $1988   
MVI      C,#$0c  
LXI      H,#$2c11
LXI      D,#$1f90
CALL     $08f3   
LDA      $20ec   
CPI      #$00    
JNZ      $0bae   
LXI      H,#$3311
MVI      A,#$02  
CALL     $08ff   
LXI      B,#$1f9c
CALL     $1856   
CALL     $184c   
IN       $#02    
RLC
JC       $0bc3   
LXI      B,#$1fa0
CALL     $183a   
CALL     $0ab6   
LDA      $20ec   
CPI      #$00    
JNZ      $0bda   
LXI      D,#$1fd5
CALL     $0ae2   
CALL     $0a80   
CALL     $189e   
LXI      H,#$20ec
MOV      A,M     
INR      A       
ANI      #$01    
MOV      M,A     
CALL     $09d6   
JMP      $18df   
LXI      D,#$1dab
CALL     $0a93   
JMP      $0b0b   
CALL     $190a   
JMP      $199a   
INX      D       
NOP
NOP
INX      D       
MVI      C,#$26  
STAX     B       
MVI      C,#$0f  
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
CALL     $1474   
NOP
PUSH     B       
PUSH     H       
LDAX     D       
OUT      #$04    
IN       $#03    
ORA      M       
MOV      M,A     
INX      H       
INX      D       
XRA      A       
OUT      #$04    
IN       $#03    
ORA      M       
MOV      M,A     
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1405   
RET
NOP
NOP
CALL     $1474   
PUSH     B       
PUSH     H       
XRA      A       
MOV      M,A     
INX      H       
MOV      M,A     
INX      H       
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1427   
RET
PUSH     B       
LDAX     D       
MOV      M,A     
INX      D       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1439   
RET
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
CALL     $1474   
PUSH     B       
PUSH     H       
LDAX     D       
OUT      #$04    
IN       $#03    
CMA
ANA      M       
MOV      M,A     
INX      H       
INX      D       
XRA      A       
OUT      #$04    
IN       $#03    
CMA
ANA      M       
MOV      M,A     
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1455   
RET
MOV      A,L     
ANI      #$07    
OUT      #$02    
JMP      $1a47   
PUSH     B       
PUSH     H       
MOV      A,M     
STAX     D       
INX      D       
INX      H       
DCR      C       
JNZ      $147e   
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $147c   
RET
CALL     $1474   
XRA      A       
STA      $2061   
PUSH     B       
PUSH     H       
LDAX     D       
OUT      #$04    
IN       $#03    
PUSH     PSW     
ANA      M       
JZ       $14a9   
MVI      A,#$01  
STA      $2061   
POP      PSW     
ORA      M       
MOV      M,A     
INX      H       
INX      D       
XRA      A       
OUT      #$04    
IN       $#03    
PUSH     PSW     
ANA      M       
JZ       $14bd   
MVI      A,#$01  
STA      $2061   
POP      PSW     
ORA      M       
MOV      M,A     
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1498   
RET
XRA      A       
PUSH     B       
MOV      M,A     
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $14cc   
RET
LDA      $2025   
CPI      #$05    
RZ
CPI      #$02    
RNZ
LDA      $2029   
CPI      #$d8    
MOV      B,A     
JNC      $1530   
LDA      $2002   
ANA      A       
RZ
MOV      A,B     
CPI      #$ce    
JNC      $1579   
ADI      #$06    
MOV      B,A     
LDA      $2009   
CPI      #$90    
JNC      $1504   
CMP      B       
JNC      $1530   
MOV      L,B     
CALL     $1562   
LDA      $202a   
MOV      H,A     
CALL     $156f   
SHLD     $2064   
MVI      A,#$05  
STA      $2025   
CALL     $1581   
MOV      A,M     
ANA      A       
JZ       $1530   
MVI      M,#$00  
CALL     $0a5f   
CALL     $1a3b   
CALL     $15d3   
MVI      A,#$10  
STA      $2003   
RET
MVI      A,#$03  
STA      $2025   
JMP      $154a   
LXI      H,#$2003
DCR      M       
RNZ
LHLD     $2064   
MVI      B,#$10  
CALL     $1424   
MVI      A,#$04  
STA      $2025   
XRA      A       
STA      $2002   
MVI      B,#$f7  
JMP      $19dc   
NOP
MVI      C,#$00  
CMP      H       
CNC      $1590   
CMP      H       
RNC
ADI      #$10    
INR      C       
JMP      $155a   
LDA      $2009   
MOV      H,L     
CALL     $1554   
MOV      B,C     
DCR      B       
SBI      #$10    
MOV      L,A     
RET
LDA      $200a   
CALL     $1554   
SBI      #$10    
MOV      H,A     
RET
MVI      A,#$01  
STA      $2085   
JMP      $1545   
MOV      A,B     
RLC
RLC
RLC
ADD      B       
ADD      B       
ADD      B       
ADD      C       
DCR      A       
MOV      L,A     
LDA      $2067   
MOV      H,A     
RET
INR      C       
ADI      #$10    
JM       $1590   
RET
LDA      $200d   
ANA      A       
JNZ      $15b7   
LXI      H,#$3ea4
CALL     $15c5   
RNC
MVI      B,#$fe  
MVI      A,#$01  
STA      $200d   
MOV      A,B     
STA      $2008   
LDA      $200e   
STA      $2007   
RET
LXI      H,#$2524
CALL     $15c5   
RNC
CALL     $18f1   
XRA      A       
JMP      $15a9   
MVI      B,#$17  
MOV      A,M     
ANA      A       
JNZ      $166b   
INX      H       
DCR      B       
JNZ      $15c7   
RET
NOP
CALL     $1474   
PUSH     H       
PUSH     B       
PUSH     H       
LDAX     D       
OUT      #$04    
IN       $#03    
MOV      M,A     
INX      H       
INX      D       
XRA      A       
OUT      #$04    
IN       $#03    
MOV      M,A     
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $15d7   
POP      H       
RET
CALL     $1611   
LXI      B,#$3700
MOV      A,M     
ANA      A       
JZ       $15ff   
INR      C       
INX      H       
DCR      B       
JNZ      $15f9   
MOV      A,C     
STA      $2082   
CPI      #$01    
RNZ
LXI      H,#$206b
MVI      M,#$01  
RET
MVI      L,#$00  
LDA      $2067   
MOV      H,A     
RET
LDA      $2015   
CPI      #$ff    
RNZ
LXI      H,#$2010
MOV      A,M     
INX      H       
MOV      B,M     
ORA      B       
RNZ
LDA      $2025   
ANA      A       
RNZ
LDA      $20ef   
ANA      A       
JZ       $1652   
LDA      $202d   
ANA      A       
JNZ      $1648   
CALL     $17c0   
ANI      #$10    
RZ
MVI      A,#$01  
STA      $2025   
STA      $202d   
RET
CALL     $17c0   
ANI      #$10    
RNZ
STA      $202d   
RET
LXI      H,#$2025
MVI      M,#$01  
LHLD     $20ed   
INX      H       
MOV      A,L     
CPI      #$7e    
JC       $1663   
MVI      L,#$74  
SHLD     $20ed   
MOV      A,M     
STA      $201d   
RET
STC
RET
XRA      A       
CALL     $1a8b   
CALL     $1910   
MVI      M,#$00  
CALL     $09ca   
INX      H       
LXI      D,#$20f5
LDAX     D       
CMP      M       
DCX      D       
DCX      H       
LDAX     D       
JZ       $168b   
JNC      $1698   
JMP      $168f   
CMP      M       
JNC      $1698   
MOV      A,M     
STAX     D       
INX      D       
INX      H       
MOV      A,M     
STAX     D       
CALL     $1950   
LDA      $20ce   
ANA      A       
JZ       $16c9   
LXI      H,#$2803
LXI      D,#$1aa6
MVI      C,#$14  
CALL     $0a93   
DCR      H       
DCR      H       
MVI      B,#$1b  
LDA      $2067   
RRC
JC       $16b7   
MVI      B,#$1c  
MOV      A,B     
CALL     $08ff   
CALL     $0ab1   
CALL     $18e7   
MOV      A,M     
ANA      A       
JZ       $16c9   
JMP      $02ed   
LXI      H,#$2d18
LXI      D,#$1aa6
MVI      C,#$0a  
CALL     $0a93   
CALL     $0ab6   
CALL     $09d6   
XRA      A       
STA      $20ef   
OUT      #$05    
CALL     $19d1   
JMP      $0b89   
LXI      SP,#$2400
EI
XRA      A       
STA      $2015   
CALL     $14d8   
MVI      B,#$04  
CALL     $18fa   
CALL     $0a59   
JNZ      $16ee   
CALL     $19d7   
LXI      H,#$2701
CALL     $19fa   
XRA      A       
CALL     $1a8b   
MVI      B,#$fb  
JMP      $196b   
CALL     $09ca   
INX      H       
MOV      A,M     
LXI      D,#$1cb8
LXI      H,#$1aa1
MVI      C,#$04  
MOV      B,A     
LDAX     D       
CMP      B       
JNC      $1727   
INX      H       
INX      D       
DCR      C       
JNZ      $171c   
MOV      A,M     
STA      $20cf   
RET
LDA      $2025   
CPI      #$00    
JNZ      $1739   
MVI      B,#$fd  
JMP      $19dc   
MVI      B,#$02  
JMP      $18fa   
NOP
NOP
LXI      H,#$209b
DCR      M       
CZ       $176d   
LDA      $2068   
ANA      A       
JZ       $176d   
LXI      H,#$2096
DCR      M       
RNZ
LXI      H,#$2098
MOV      A,M     
OUT      #$05    
LDA      $2082   
ANA      A       
JZ       $176d   
DCX      H       
MOV      A,M     
DCX      H       
MOV      M,A     
DCX      H       
MVI      M,#$01  
MVI      A,#$04  
STA      $209b   
RET
LDA      $2098   
ANI      #$30    
OUT      #$05    
RET
LDA      $2095   
ANA      A       
JZ       $17aa   
LXI      H,#$1a11
LXI      D,#$1a21
LDA      $2082   
CMP      M       
JNC      $178e   
INX      H       
INX      D       
JMP      $1785   
LDAX     D       
STA      $2097   
LXI      H,#$2098
MOV      A,M     
ANI      #$30    
MOV      B,A     
MOV      A,M     
ANI      #$0f    
RLC
CPI      #$10    
JNZ      $17a4   
MVI      A,#$01  
ORA      B       
MOV      M,A     
XRA      A       
STA      $2095   
LXI      H,#$2099
DCR      M       
RNZ
MVI      B,#$ef  
JMP      $19dc   
MVI      B,#$ef  
LXI      H,#$2098
MOV      A,M     
ANA      B       
MOV      M,A     
OUT      #$05    
RET
NOP
LDA      $2067   
RRC
JNC      $17ca   
IN       $#01    
RET
IN       $#02    
RET
IN       $#02    
ANI      #$04    
RZ
LDA      $209a   
ANA      A       
RNZ
LXI      SP,#$2400
MVI      B,#$04  
CALL     $09d6   
DCR      B       
JNZ      $17dc   
MVI      A,#$01  
STA      $209a   
CALL     $19d7   
EI
LXI      D,#$1cbc
LXI      H,#$3016
MVI      C,#$04  
CALL     $0a93   
CALL     $0ab1   
XRA      A       
STA      $209a   
STA      $2093   
JMP      $16c9   
LXI      H,#$2084
MOV      A,M     
ANA      A       
JZ       $0707   
INX      H       
MOV      A,M     
ANA      A       
RNZ
MVI      B,#$01  
JMP      $18fa   
LXI      H,#$2810
LXI      D,#$1ca3
MVI      C,#$15  
CALL     $08f3   
MVI      A,#$0a  
STA      $206c   
LXI      B,#$1dbe
CALL     $1856   
JC       $1837   
CALL     $1844   
JMP      $1828   
CALL     $0ab1   
LXI      B,#$1dcf
CALL     $1856   
RC
CALL     $184c   
JMP      $183a   
PUSH     B       
MVI      B,#$10  
CALL     $1439   
POP      B       
RET
PUSH     B       
LDA      $206c   
MOV      C,A     
CALL     $0a93   
POP      B       
RET
LDAX     B       
CPI      #$ff    
STC
RZ
MOV      L,A     
INX      B       
LDAX     B       
MOV      H,A     
INX      B       
LDAX     B       
MOV      E,A     
INX      B       
LDAX     B       
MOV      D,A     
INX      B       
ANA      A       
RET
LXI      H,#$20c2
INR      M       
INX      H       
MOV      C,M     
CALL     $01d9   
MOV      B,A     
LDA      $20ca   
CMP      B       
JZ       $1898   
LDA      $20c2   
ANI      #$04    
LHLD     $20cc   
JNZ      $1888   
LXI      D,#$0030
DAD      D       
SHLD     $20c7   
LXI      H,#$20c5
CALL     $1a3b   
XCHG
JMP      $15d3   
NOP
NOP
NOP
MVI      A,#$01  
STA      $20cb   
RET
LXI      H,#$2050
LXI      D,#$1bc0
MVI      B,#$10  
CALL     $1a32   
MVI      A,#$02  
STA      $2080   
MVI      A,#$ff  
STA      $207e   
MVI      A,#$04  
STA      $20c1   
LDA      $2055   
ANI      #$01    
JZ       $18b8   
LDA      $2055   
ANI      #$01    
JNZ      $18c0   
LXI      H,#$3311
MVI      A,#$26  
NOP
CALL     $08ff   
JMP      $0ab6   
LXI      SP,#$2400
MVI      B,#$00  
CALL     $01e6   
CALL     $1956   
MVI      A,#$08  
STA      $20cf   
JMP      $0aea   
LDA      $2067   
LXI      H,#$20e7
RRC
RNC
INX      H       
RET
MVI      B,#$02  
LDA      $2082   
DCR      A       
RNZ
INR      B       
RET
LDA      $2094   
ORA      B       
STA      $2094   
OUT      #$03    
RET
LXI      H,#$2200
JMP      $01c3   
CALL     $14d8   
JMP      $1597   
LXI      H,#$20e7
LDA      $2067   
RRC
RC
INX      H       
RET
MVI      C,#$1c  
LXI      H,#$241e
LXI      D,#$1ae4
JMP      $08f3   
LXI      H,#$20f8
JMP      $1931   
LXI      H,#$20fc
JMP      $1931   
MOV      E,M     
INX      H       
MOV      D,M     
INX      H       
MOV      A,M     
INX      H       
MOV      H,M     
MOV      L,A     
JMP      $09ad   
MVI      C,#$07  
LXI      H,#$3501
LXI      D,#$1fa9
JMP      $08f3   
LDA      $20eb   
LXI      H,#$3c01
JMP      $09b2   
LXI      H,#$20f4
JMP      $1931   
CALL     $1a5c   
CALL     $191a   
CALL     $1925   
CALL     $192b   
CALL     $1950   
CALL     $193c   
JMP      $1947   
CALL     $19dc   
JMP      $1671   
MVI      A,#$01  
STA      $206d   
JMP      $16e6   
CALL     $19d7   
CALL     $1947   
JMP      $193c   
STA      $20c1   
RET
ADC      E       
DAD      D       
JMP      $09d6   
LXI      H,#$2803
LXI      D,#$19be
MVI      C,#$13  
JMP      $08f3   
NOP
NOP
NOP
NOP
LDA      $201e   
ANA      A       
JNZ      $19ac   
IN       $#01    
ANI      #$76    
SUI      #$72    
RNZ
INR      A       
STA      $201e   
IN       $#01    
ANI      #$76    
CPI      #$34    
RNZ
LXI      H,#$2e1b
LXI      D,#$0bf7
MVI      C,#$09  
JMP      $08f3   
NOP
INX      D       
NOP
NOP
INX      D       
MVI      C,#$26  
STAX     B       
MVI      C,#$11  
RRC
MVI      C,#$11  
NOP
INX      D       
NOP
MVI      C,#$0d  
NOP
MVI      A,#$01  
STA      $20e9   
RET
XRA      A       
JMP      $19d3   
NOP
LDA      $2094   
ANA      B       
STA      $2094   
OUT      #$03    
RET
LXI      H,#$2701
JZ       $19fa   
LXI      D,#$1c60
MVI      B,#$10  
MOV      C,A     
CALL     $1439   
MOV      A,C     
DCR      A       
JNZ      $19ec   
MVI      B,#$10  
CALL     $14cb   
MOV      A,H     
CPI      #$35    
JNZ      $19fa   
RET
LXI      H,#$2072
MOV      B,M     
LDAX     D       
ANI      #$80    
XRA      B       
RNZ
STC
RET
STA      $242b   
INR      E       
MVI      D,#$11  
DCR      C       
LDAX     B       
NOP
RLC
MVI      B,#$05  
INR      B       
INX      B       
STAX     B       
LXI      B,#$2e34
DAA
SHLD     $181c   
DCR      D       
INX      D       
NOP
MVI      C,#$0d  
INR      C       
DCX      B       
DAD      B       
RLC
DCR      B       
RST      7       
LDAX     D       
MOV      M,A     
INX      H       
INX      D       
DCR      B       
JNZ      $1a32   
RET
MOV      E,M     
INX      H       
MOV      D,M     
INX      H       
MOV      A,M     
INX      H       
MOV      C,M     
INX      H       
MOV      B,M     
MOV      H,C     
MOV      L,A     
RET
PUSH     B       
MVI      B,#$03  
MOV      A,H     
RAR
MOV      H,A     
MOV      A,L     
RAR
MOV      L,A     
DCR      B       
JNZ      $1a4a   
MOV      A,H     
ANI      #$3f    
ORI      #$20    
MOV      H,A     
POP      B       
RET
LXI      H,#$2400
MVI      M,#$00  
INX      H       
MOV      A,H     
CPI      #$40    
JNZ      $1a5f   
RET
PUSH     B       
PUSH     H       
LDAX     D       
ORA      M       
MOV      M,A     
INX      D       
INX      H       
DCR      C       
JNZ      $1a6b   
POP      H       
LXI      B,#$0020
DAD      B       
POP      B       
DCR      B       
JNZ      $1a69   
RET
CALL     $092e   
ANA      A       
RZ
PUSH     PSW     
DCR      A       
MOV      M,A     
CALL     $19e6   
POP      PSW     
LXI      H,#$2501
ANI      #$0f    
JMP      $09c5   
NOP
NOP
NOP
NOP
RST      7       
CMP      B       
CPI      #$20    
INR      E       
NOP
SBB      M       
NOP
NOP
INR      E       
NOP
NOP
DCX      B       
NOP
RLC
MVI      B,#$00  
INR      C       
INR      B       
MVI      H,#$0e  
DCR      D       
INR      B       
LXI      D,#$2626
RRC
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2624
DCR      H       
DCX      D       
MVI      H,#$0e  
LXI      D,#$1c26
RRC
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2612
LXI      B,#$1314
INX      D       
MVI      C,#$0d  
MVI      H,#$0e  
DCR      C       
DCX      B       
NOP
MVI      H,#$1b  
RRC
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2626
LXI      B,#$1314
INX      D       
MVI      C,#$0d  
MVI      H,#$26  
STAX     D       
STAX     B       
MVI      C,#$11  
INR      B       
INR      H       
DCX      D       
DCR      H       
MVI      H,#$07  
NOP
CMC
STAX     D       
STAX     B       
MVI      C,#$11  
INR      B       
MVI      H,#$12  
STAX     B       
MVI      C,#$11  
INR      B       
INR      H       
INR      E       
DCR      H       
MVI      H,#$01  
NOP
NOP
NOP
NOP
NOP
NOP
NOP
STAX     B       
MOV      A,B     
NOP
MOV      A,B     
NOP
NOP
RM
NOP
NOP
ADD      B       
NOP
ADC      M       
STAX     B       
RST      7       
DCR      B       
INR      C       
MOV      H,B     
INR      E       
NOP
NOP
NOP
LXI      B,#$0000
NOP
NOP
NOP
CMP      E       
INX      B       
NOP
NOP
SUB      B       
INR      E       
NOP
NOP
LXI      B,#$0004
RST      7       
RST      7       
NOP
NOP
STAX     B       
HLT
INR      B       
NOP
NOP
NOP
NOP
NOP
INR      B       
XRI      #$1c    
NOP
NOP
INX      B       
NOP
NOP
NOP
ORA      M       
INR      B       
NOP
NOP
LXI      B,#$1d00
INR      B       
JPO      $001c   
NOP
INX      B       
NOP
NOP
NOP
ADD      D       
MVI      B,#$00  
NOP
LXI      B,#$1d06
INR      B       
RNC
INR      E       
NOP
NOP
INX      B       
RST      7       
NOP
RNZ
INR      E       
NOP
NOP
NOP
LXI      H,#$0001
NOP
NOP
STAX     D       
NOP
NOP
NOP
RRC
DCX      B       
NOP
NOP
MVI      H,#$0f  
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$1b24
DCR      H       
CM       $0100   
RST      7       
RST      7       
NOP
NOP
NOP
NOP
MOV      H,H     
DCR      E       
RNC
DAD      H       
NOP
STAX     B       
MOV      D,H     
DCR      E       
NOP
NOP
NOP
MVI      B,#$00  
NOP
LXI      B,#$0040
LXI      B,#$0000
NOP
SBB      M       
NOP
NOP
INR      E       
NOP
INX      B       
INR      B       
MOV      A,B     
INR      D       
INX      D       
NOP
LDAX     D       
DCR      A       
MOV      L,B     
CM       $68fc   
DCR      A       
LDAX     D       
NOP
NOP
NOP
LXI      B,#$98b8
ANA      B       
DCX      D       
NOP
RST      7       
NOP
ANA      B       
DCX      D       
NOP
NOP
NOP
NOP
NOP
NOP
NOP
MVI      C,#$05  
NOP
NOP
NOP
NOP
NOP
RLC
RNC
INR      E       
RZ
SBB      E       
INX      B       
NOP
NOP
INX      B       
INR      B       
MOV      A,B     
INR      D       
DCX      B       
DAD      D       
LDA      $fa6d   
JM       $3a6d   
DAD      D       
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
LXI      B,#$0000
LXI      B,#$1f74
NOP
ADD      B       
NOP
NOP
NOP
NOP
NOP
INR      E       
CMA
NOP
NOP
INR      E       
DAA
NOP
NOP
INR      E       
DAD      SP      
NOP
NOP
DAD      SP      
MOV      A,C     
MOV      A,D     
MOV      L,M     
CPE      $fafa   
CPE      $7a6e   
MOV      A,C     
DAD      SP      
NOP
NOP
NOP
NOP
NOP
MOV      A,B     
DCR      E       
CMP      M       
MOV      L,H     
INR      A       
INR      A       
INR      A       
MOV      L,H     
CMP      M       
DCR      E       
MOV      A,B     
NOP
NOP
NOP
NOP
NOP
NOP
DAD      D       
LDA      $fa6d   
JM       $3a6d   
DAD      D       
NOP
NOP
NOP
NOP
NOP
NOP
NOP
MOV      A,D     
MOV      A,A     
MOV      L,L     
CPE      $fafa   
CPE      $7f6d   
MOV      A,D     
NOP
NOP
NOP
NOP
NOP
NOP
MVI      C,#$18  
CMP      M       
MOV      L,L     
DCR      A       
INR      A       
DCR      A       
MOV      L,L     
CMP      M       
NOP
MVI      C,#$00  
NOP
NOP
NOP
NOP
NOP
LDAX     D       
DCR      A       
MOV      L,B     
CM       $68fc   
DCR      A       
LDAX     D       
NOP
NOP
NOP
NOP
NOP
NOP
RRC
RAR
RAR
RAR
RAR
MOV      A,A     
RST      7       
MOV      A,A     
RAR
RAR
RAR
RAR
RRC
NOP
NOP
INR      B       
LXI      B,#$0313
RLC
ORA      E       
RRC
CMA
INX      B       
CMA
MOV      C,C     
INR      B       
INX      B       
NOP
LXI      B,#$0840
DCR      B       
ANA      E       
LDAX     B       
INX      B       
MOV      E,E     
RRC
DAA
DAA
DCX      B       
MOV      C,E     
MOV      B,B     
ADD      H       
LXI      D,#$0f48
SBB      C       
INR      A       
MOV      A,M     
DCR      A       
CMP      H       
MVI      A,#$7c  
SBB      C       
DAA
DCX      D       
LDAX     D       
MVI      H,#$0f  
MVI      C,#$08  
DCR      C       
INX      D       
STAX     D       
NOP
STAX     D       
STAX     B       
MVI      C,#$11  
INR      B       
MVI      H,#$00  
INX      B       
DCR      D       
NOP
DCR      C       
STAX     B       
INR      B       
MVI      H,#$13  
NOP
LXI      B,#$040b
NOP
STAX     B       
NOP
NOP
NOP
INX      D       
NOP
DCX      B       
INX      D       
NOP
NOP
MOV      C,C     
SHLD     $8114   
MOV      B,D     
NOP
MOV      B,D     
ADD      C       
INR      D       
SHLD     $0849   
NOP
NOP
MOV      B,H     
XRA      D       
NOP
ADC      B       
MOV      D,H     
SHLD     $aa10   
MOV      B,H     
SHLD     $8854   
MOV      C,D     
DCR      D       
CMP      M       
CMC
MOV      E,M     
DCR      H       
INR      B       
CM       $1004   
CM       $2010   
CM       $8020   
CM       $0080   
CPI      #$00    
INR      H       
CPI      #$12    
NOP
CPI      #$00    
MOV      C,B     
CPI      #$90    
RRC
DCX      B       
NOP
DAD      H       
NOP
NOP
LXI      B,#$0107
LXI      B,#$0401
DCX      B       
LXI      B,#$0306
LXI      B,#$0b01
DAD      B       
STAX     B       
NOP
STAX     B       
DCX      B       
INR      B       
RLC
LDAX     B       
DCR      B       
STAX     B       
DCR      B       
INR      B       
MVI      B,#$07  
NOP
LDAX     B       
MVI      B,#$0a  
INX      B       
RST      7       
RRC
RST      7       
RAR
RST      7       
CMC
RST      7       
MOV      A,A     
RST      7       
RST      7       
CM       $f8ff   
RST      7       
RP
RST      7       
RP
RST      7       
RP
RST      7       
RP
RST      7       
RP
RST      7       
RP
RST      7       
RP
RST      7       
RM
RST      7       
CM       $ffff   
RST      7       
RST      7       
RST      7       
RST      7       
MOV      A,A     
RST      7       
CMC
RST      7       
RAR
RST      7       
RRC
DCR      B       
NOP
DCR      D       
NOP
SUB      H       
SUB      A       
SBB      D       
SBB      L       
NOP
DCR      B       
DCR      B       
NOP
DCR      D       
NOP
NOP
DCR      B       
NOP
NOP
NOP
NOP
DCR      B       
DCR      D       
NOP
DCR      B       
NOP
NOP
NOP
NOP
INR      B       
INR      C       
MVI      E,#$37  
MVI      A,#$7c  
MOV      M,H     
MOV      A,M     
MOV      A,M     
MOV      M,H     
MOV      A,H     
MVI      A,#$37  
MVI      E,#$0c  
INR      B       
NOP
NOP
NOP
NOP
NOP
SHLD     $a500   
MOV      B,B     
NOP
SBB      B       
DCR      A       
ORA      M       
INR      A       
MVI      M,#$1d  
NOP
MOV      C,B     
MOV      H,D     
ORA      M       
DCR      E       
SBB      B       
NOP
MOV      B,D     
SUB      B       
NOP
NOP
NOP
MVI      H,#$1f  
LDAX     D       
DCX      D       
LDAX     D       
LDAX     D       
DCX      D       
RAR
LDAX     D       
DCR      E       
LDAX     D       
LDAX     D       
NOP
NOP
NOP
MOV      H,B     
MOV      D,B     
MOV      C,B     
MOV      C,B     
MOV      C,B     
MOV      B,B     
MOV      B,B     
MOV      B,B     
RRC
DCX      B       
NOP
NOP
STAX     D       
RRC
NOP
STAX     B       
INR      B       
MVI      H,#$26  
NOP
DCR      C       
DCR      D       
NOP
INX      B       
INR      B       
LXI      D,#$0e12
INR      L       
MOV      L,B     
DCR      E       
INR      C       
INR      L       
NOP
INR      E       
LDAX     B       
INR      L       
MOV      B,B     
INR      E       
NOP
INR      L       
NOP
INR      E       
RST      7       
MVI      C,#$2e  
RPO
DCR      E       
INR      C       
MVI      L,#$ea  
DCR      E       
LDAX     B       
MVI      L,#$f4  
DCR      E       
NOP
MVI      L,#$99  
INR      E       
RST      7       
DAA
NOP
MVI      H,#$0c  
NOP
STAX     D       
INX      D       
INR      B       
LXI      D,#$2718
DCR      E       
LDAX     D       
MVI      H,#$0f  
MVI      C,#$08  
DCR      C       
INX      D       
STAX     D       
DAA
INR      E       
LDAX     D       
MVI      H,#$0f  
MVI      C,#$08  
DCR      C       
INX      D       
STAX     D       
NOP
NOP
NOP
RAR
INR      H       
MOV      B,H     
INR      H       
RAR
NOP
NOP
NOP
MOV      A,A     
MOV      C,C     
MOV      C,C     
MOV      C,C     
MVI      M,#$00  
NOP
NOP
MVI      A,#$41  
MOV      B,C     
MOV      B,C     
SHLD     $0000   
NOP
MOV      A,A     
MOV      B,C     
MOV      B,C     
MOV      B,C     
MVI      A,#$00  
NOP
NOP
MOV      A,A     
MOV      C,C     
MOV      C,C     
MOV      C,C     
MOV      B,C     
NOP
NOP
NOP
MOV      A,A     
MOV      C,B     
MOV      C,B     
MOV      C,B     
MOV      B,B     
NOP
NOP
NOP
MVI      A,#$41  
MOV      B,C     
MOV      B,L     
MOV      B,A     
NOP
NOP
NOP
MOV      A,A     
NOP
NOP
NOP
MOV      A,A     
NOP
NOP
NOP
NOP
MOV      B,C     
MOV      A,A     
MOV      B,C     
NOP
NOP
NOP
NOP
STAX     B       
LXI      B,#$0101
MOV      A,M     
NOP
NOP
NOP
MOV      A,A     
NOP
INR      D       
SHLD     $0041   
NOP
NOP
MOV      A,A     
LXI      B,#$0101
LXI      B,#$0000
NOP
MOV      A,A     
NOP
NOP
NOP
MOV      A,A     
NOP
NOP
NOP
MOV      A,A     
NOP
NOP
INR      B       
MOV      A,A     
NOP
NOP
NOP
MVI      A,#$41  
MOV      B,C     
MOV      B,C     
MVI      A,#$00  
NOP
NOP
MOV      A,A     
MOV      C,B     
MOV      C,B     
MOV      C,B     
NOP
NOP
NOP
NOP
MVI      A,#$41  
MOV      B,L     
MOV      B,D     
DCR      A       
NOP
NOP
NOP
MOV      A,A     
MOV      C,B     
MOV      C,H     
MOV      C,D     
LXI      SP,#$0000
NOP
STA      $4949   
MOV      C,C     
MVI      H,#$00  
NOP
NOP
MOV      B,B     
MOV      B,B     
MOV      A,A     
MOV      B,B     
MOV      B,B     
NOP
NOP
NOP
MOV      A,M     
LXI      B,#$0101
MOV      A,M     
NOP
NOP
NOP
MOV      A,H     
STAX     B       
LXI      B,#$7c02
NOP
NOP
NOP
MOV      A,A     
STAX     B       
INR      C       
STAX     B       
MOV      A,A     
NOP
NOP
NOP
MOV      H,E     
INR      D       
NOP
INR      D       
MOV      H,E     
NOP
NOP
NOP
MOV      H,B     
NOP
RRC
NOP
MOV      H,B     
NOP
NOP
NOP
MOV      B,E     
MOV      B,L     
MOV      C,C     
MOV      D,C     
MOV      H,C     
NOP
NOP
NOP
MVI      A,#$45  
MOV      C,C     
MOV      D,C     
MVI      A,#$00  
NOP
NOP
NOP
LXI      H,#$017f
NOP
NOP
NOP
NOP
INX      H       
MOV      B,L     
MOV      C,C     
MOV      C,C     
LXI      SP,#$0000
NOP
MOV      B,D     
MOV      B,C     
MOV      C,C     
MOV      E,C     
MOV      H,M     
NOP
NOP
NOP
INR      C       
INR      D       
INR      H       
MOV      A,A     
INR      B       
NOP
NOP
NOP
MOV      M,D     
MOV      D,C     
MOV      D,C     
MOV      D,C     
MOV      C,M     
NOP
NOP
NOP
MVI      E,#$29  
MOV      C,C     
MOV      C,C     
MOV      B,M     
NOP
NOP
NOP
MOV      B,B     
MOV      B,A     
MOV      C,B     
MOV      D,B     
MOV      H,B     
NOP
NOP
NOP
MVI      M,#$49  
MOV      C,C     
MOV      C,C     
MVI      M,#$00  
NOP
NOP
LXI      SP,#$4949
MOV      C,D     
INR      A       
NOP
NOP
NOP
NOP
INR      D       
SHLD     $0041   
NOP
NOP
NOP
NOP
MOV      B,C     
SHLD     $0814   
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
NOP
INR      D       
INR      D       
INR      D       
INR      D       
INR      D       
NOP
NOP
NOP
SHLD     $7f14   
INR      D       
SHLD     $0000   
NOP
INX      B       
INR      B       
MOV      A,B     
INR      B       
INX      B       
NOP
NOP
INR      H       
DCX      D       
MVI      H,#$0e  
LXI      D,#$1c26
MVI      H,#$0f  
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2512
MVI      H,#$26  
NOP
DCX      D       
MVI      H,#$0f  
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2626
DCX      D       
MVI      H,#$02  
MVI      C,#$08  
DCR      C       
MVI      H,#$01  
LXI      B,#$0000
LXI      B,#$0200
LXI      B,#$0200
LXI      B,#$6000
NOP
RRC
NOP
MOV      H,B     
NOP
NOP
LDAX     D       
DCR      A       
MOV      L,B     
CM       $68fc   
DCR      A       
LDAX     D       
NOP
NOP
DCR      C       
STAX     D       
INR      B       
LXI      D,#$2613
MVI      H,#$02  
MVI      C,#$08  
DCR      C       
DCR      C       
LHLD     $1f50   
LDAX     B       
LHLD     $1f62   
RLC
LHLD     $1fe1   
RST      7       
STAX     B       
LXI      D,#$0304
NOP
INX      D       
MVI      H,#$00  
MOV      H,B     
NOP
RRC
NOP
MOV      H,B     
NOP
DAD      D       
LDA      $fa6d   
JM       $3a6d   
DAD      D       
NOP
NOP
NOP
MOV      B,B     
MOV      C,L     
MOV      D,B     
NOP
NOP
NOP
NOP
NOP
NOP
RST      7       
CMP      B       
RST      7       
ADD      B       
RAR
NOP
SUB      A       
NOP
ADD      B       
RAR
NOP
NOP
LXI      B,#$22d0
NOP
INR      E       
NOP
SUB      H       
NOP
NOP
INR      E       
NOP
INR      E       
MVI      H,#$0f  
DCX      B       
NOP
NOP
INR      B       
LXI      D,#$2612
INR      E       
MVI      H,#$02  
MVI      C,#$08  
DCR      C       
STAX     D       
RRC
INR      D       
STAX     D       
RLC
MVI      H,#$00  
NOP
NOP
NOP
NOP
NOP
NOP
NOP