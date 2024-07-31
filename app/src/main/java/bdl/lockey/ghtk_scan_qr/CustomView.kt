package bdl.lockey.ghtk_scan_qr

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = 0x80000000.toInt() // Màu đen với độ trong suốt 50%
        style = Paint.Style.FILL
    }

    private val transparentPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Kích thước của ô vuông trong suốt
        val frameSize = width * 0.5f // Ô vuông chiếm 50% chiều rộng của màn hình

        // Tọa độ để đặt ô vuông ở giữa màn hình
        val left = (width - frameSize) / 2
        val top = (height - frameSize) / 2
        val right = left + frameSize
        val bottom = top + frameSize

        // Vẽ màu phủ với độ trong suốt lên toàn bộ màn hình
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        // Tạo một hình chữ nhật với phần giữa trong suốt
        val rect = RectF(left, top, right, bottom)
        canvas.drawRoundRect(rect, 24f, 24f, transparentPaint) // Góc bo tròn là 24f
    }
}