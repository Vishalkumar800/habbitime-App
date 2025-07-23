package com.rach.habitchange.presentations.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.rach.habitchange.utils.Secrets

@Composable
fun NoDataFound(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("No Data Found")
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = Secrets.ADS_UNIT_ID
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}