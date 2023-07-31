package com.example.chess
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
class ChessView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val originX = 80f // Adjusted value for horizontal padding
    private val originY = 200f // Adjusted value for vertical padding
    private val cellSide = 120f // Adjusted value to reduce cell size
    private val numRows = 8
    private val numCols = 8

    private final val squareNamesLeft = listOf("8", "7", "6", "5", "4", "3", "2", "1")
    private final val squareNamesBottom = listOf("A", "B", "C", "D", "E", "F", "G", "H")
    private final val imgResIDs=setOf(
        R.drawable.chess_bdt60,
        R.drawable.chess_qlt60,
        R.drawable.chess_blt60,
        R.drawable.chess_kdt60,
        R.drawable.chess_klt60,
        R.drawable.chess_ndt60,
        R.drawable.chess_plt60,
        R.drawable.chess_pdt60,
        R.drawable.chess_nlt60,
        R.drawable.chess_qdt60,
        R.drawable.chess_rdt60,
        R.drawable.chess_rlt60,
    )
    private final val bitmaps= mutableMapOf<Int,Bitmap>()
    private final val paint = Paint()

    init{
    loadBitmaps()
    }

    override fun onDraw(canvas: Canvas?) {
        drawChessBoard(canvas)
        val whiteQueenBitmap=bitmaps[R.drawable.chess_qlt60]!!
        canvas?.drawBitmap(whiteQueenBitmap,null,Rect(0,0,600,600),paint)
    }
    private fun loadBitmaps(){
        imgResIDs.forEach {
            bitmaps[it]=BitmapFactory.decodeResource(resources,it)
        }
    }

    private fun drawChessBoard(canvas: Canvas?){

        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                if ((row + col) % 2 == 0) {
                    // Light gray rectangles for even cells
                    paint.color = Color.LTGRAY
                } else {
                    // Dark gray rectangles for odd cells
                    paint.color = Color.DKGRAY
                }
                val left = originX + col * cellSide
                val top = originY + row * cellSide
                val right = left + cellSide
                val bottom = top + cellSide
                canvas?.drawRect(left, top, right, bottom, paint)

                // Draw square names on the left side
                val squareNameLeft = squareNamesLeft[row]
                val textXLeft = originX - 45f // Adjusted value for left numbers alignment
                val textYLeft = top + cellSide / 2f
                paint.color = Color.WHITE
                paint.textSize = 24f // Adjusted font size for left numbers
                canvas?.drawText(squareNameLeft, textXLeft, textYLeft, paint)

                // Draw square names on the bottom
                val squareNameBottom = squareNamesBottom[col]
                val textXBottom = left + cellSide / 2f
                val textYBottom = originY + numRows * cellSide + 45f // Adjusted value for bottom numbers alignment
                paint.color = Color.WHITE
                paint.textSize = 24f // Adjusted font size for bottom numbers
                canvas?.drawText(squareNameBottom, textXBottom, textYBottom, paint)
            }
        }
    }
}





//class ChessView(context: Context?) : View(context){
