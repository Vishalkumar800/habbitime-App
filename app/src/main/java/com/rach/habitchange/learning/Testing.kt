package com.rach.habitchange.learning

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap

@Composable
fun DrawbleTesting(
    drawable: Drawable,
    modifier: Modifier = Modifier) {

    val bitmap = drawable.toBitmap()
    val image = bitmap.asImageBitmap()
    Image(
        bitmap = image,
        contentDescription = null
    )
}