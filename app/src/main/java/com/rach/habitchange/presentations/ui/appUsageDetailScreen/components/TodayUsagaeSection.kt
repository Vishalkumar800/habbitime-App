package com.rach.habitchange.presentations.ui.appUsageDetailScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rach.habitchange.R
import com.rach.habitchange.presentations.ui.homescreen.minToHourMinute
import com.rach.habitchange.theme.poppinsBoldFont
import com.rach.habitchange.theme.poppinsMediumFont

@Composable
fun TodayUsageTextAppDetailsScreen(
    modifier: Modifier = Modifier,
    todayUsage: Long
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.outline_chart_data_24),
                contentDescription = stringResource(R.string.today_usage_icon),
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.dimen_8dp)))
            Text(
                text = stringResource(R.string.today_usage),
                style = poppinsMediumFont.copy(
                    fontSize = 20.sp
                )
            )
        }

        Row {
            Text(
                text = minToHourMinute(todayUsage),
                style = poppinsBoldFont.copy(
                    fontSize = 35.sp
                ),
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}
