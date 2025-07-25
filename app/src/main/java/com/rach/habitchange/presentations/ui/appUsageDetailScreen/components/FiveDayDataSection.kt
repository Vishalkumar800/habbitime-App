package com.rach.habitchange.presentations.ui.appUsageDetailScreen.components

import android.graphics.Color
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.rach.habitchange.R
import com.rach.habitchange.presentations.model.LoadAppDataWithUsage
import com.rach.habitchange.presentations.ui.homescreen.minToHourMinute
import com.rach.habitchange.theme.poppinsSemiBoldFont

@Composable
fun FiveDaysDataUiSection(
    modifier: Modifier = Modifier,
    fiveDaysAppUsageData: List<LoadAppDataWithUsage>
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Canvas(
                modifier = Modifier
                    .graphicsLayer { clip = false }
                    .drawBehind {
                        drawIntoCanvas { canvas ->
                            val paint = Paint().asFrameworkPaint().apply {
                                isAntiAlias = true
                                color = Color.RED
                                setShadowLayer(50f, 0f, 0f, "#FF6F00".toColorInt())
                            }

                            canvas.nativeCanvas.drawCircle(
                                size.width / 2,
                                size.height / 2,
                                12f,
                                paint
                            )
                        }
                    }) {

            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Previous Days Usages")
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.dimen_15dp)))
        if (fiveDaysAppUsageData.isEmpty()) {
            Text("No Data Found", modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            fiveDaysAppUsageData.forEach { data ->
                data.date?.let {
                    Text(
                        text = it,
                        style = poppinsSemiBoldFont
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "👉🏻 ${minToHourMinute(data.todayUsageInMinutes)}",
                    modifier.padding(start = 5.dp, bottom = 10.dp)
                )
            }
        }
    }
}