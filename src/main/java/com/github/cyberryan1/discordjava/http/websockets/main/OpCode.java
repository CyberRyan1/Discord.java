package com.github.cyberryan1.discordjava.http.websockets.main;

public enum OpCode {

    ZERO ( 0 ),
    ONE ( 1 ),
    TWO ( 2 ),
    THREE ( 3 ),
    FOUR ( 4 ),
    FIVE ( 5 ),
    SIX ( 6 ),
    SEVEN ( 7 ),
    EIGHT ( 8 ),
    NINE ( 9 ),
    TEN ( 10 ),
    ELEVEN ( 11 );
    
    public final int number;
    
    OpCode( int opCodeNumber ) {
        this.number = opCodeNumber;
    }
}