package com.narae.fliwith.util

import android.content.Context
import android.os.SystemClock
import android.view.View
import kotlin.math.roundToInt


fun convertDPtoPX(context: Context, dp: Int): Int {
    val density = context.resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}


// 버튼을 여러번 중복 클릭하여 API 요청이 연속으로 가는 경우를 방지하기 위한 확장 함수
fun View.setOnSingleClickListener(
    onClickListener: (view: View) -> Unit
) {
    setOnClickListener(OnSingleClickListener(onClickListener))
}

class OnSingleClickListener(
    private val onClickListener: (view: View) -> Unit
) : View.OnClickListener {

    companion object {
        // 버튼 사이에 허용하는 시간간격
        const val INTERVAL = 1000L
    }

    // 이전 클릭 시간 기록
    private var lastClickedTime = 0L

    override fun onClick(view: View) {
        // 클릭 시간
        val onClickedTime = SystemClock.elapsedRealtime()
        // 간격보다 작으면 클릭 no
        if ((onClickedTime - lastClickedTime) < INTERVAL) {
            return
        }

        lastClickedTime = onClickedTime
        onClickListener.invoke(view)
    }
}