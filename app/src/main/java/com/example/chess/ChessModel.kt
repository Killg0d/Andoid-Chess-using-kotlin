package com.example.chess

class ChessModel {
    var pieceBox = mutableSetOf<ChessPiece>()
    init {
    reset()
    }
private fun reset(){
    pieceBox.removeAll(pieceBox)
    for (i in 0..1){
        pieceBox.add(ChessPiece(0+i*7,0,ChessPlayer.WHITE, ChessRank.ROOK))
        pieceBox.add(ChessPiece(1+i*5,0,ChessPlayer.WHITE, ChessRank.KNIGHT))
        pieceBox.add(ChessPiece(2+i*3,0,ChessPlayer.WHITE, ChessRank.BISHOP))
        pieceBox.add(ChessPiece(0+i*7,7,ChessPlayer.Black, ChessRank.ROOK))
        pieceBox.add(ChessPiece(1+i*5,7,ChessPlayer.Black, ChessRank.KNIGHT))
        pieceBox.add(ChessPiece(2+i*3,7,ChessPlayer.Black, ChessRank.BISHOP))
    }
    for (i in 0..7){
        pieceBox.add(ChessPiece(i,1,ChessPlayer.WHITE,ChessRank.PAWN))
        pieceBox.add(ChessPiece(i,6,ChessPlayer.Black,ChessRank.PAWN))
    }

    pieceBox.add(ChessPiece(col =3,row=0,ChessPlayer.WHITE, ChessRank.QUEEN))
    pieceBox.add(ChessPiece(col =4,row=0,ChessPlayer.WHITE, ChessRank.KING))
    pieceBox.add(ChessPiece(col =3,row=7,ChessPlayer.Black, ChessRank.QUEEN))
    pieceBox.add(ChessPiece(col =4,row=7,ChessPlayer.Black, ChessRank.KING))
    
}
    private fun pieceAt(col: Int,row:Int):ChessPiece?{
        for (piece in pieceBox){
            if(col==piece.col && row==piece.row){
                return piece
            }

        }
        return null
    }

    override fun toString(): String {
        var desc =" \n"
        for (row in 7 downTo 0){
            desc += "$row"
            for (col in 0..7){
                val piece=pieceAt(col, row)
                if (piece==null){
                    desc+=" ."
                }
                else{
                    val white=piece.player==ChessPlayer.WHITE

                    desc += when(piece.rank){
                        ChessRank.KING-> {
                            if (white) " k" else " K"
                        }
                        ChessRank.QUEEN-> {
                            if (white) " q" else " Q"
                        }
                        ChessRank.BISHOP-> {
                            if (white) " b" else " B"
                        }
                        ChessRank.KNIGHT-> {
                            if (white) " n" else " N"
                        }
                        ChessRank.ROOK-> {
                            if (white) " r" else " R"
                        }
                        ChessRank.PAWN-> {
                            if (white) " p" else " P"
                        }
                    }
                }
            }
            desc+="\n"
        }
        desc+="  a b c d e f g h"
        return desc
    }
}