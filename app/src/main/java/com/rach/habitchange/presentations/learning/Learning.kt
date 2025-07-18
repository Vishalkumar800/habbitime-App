package com.rach.habitchange.presentations.learning

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rach.habitchange.R
import com.rach.habitchange.presentations.uiComponents.CircularConfirmButton
import com.rach.habitchange.theme.HabitChangeTheme

/*

  1. PACKAGE_USAGE_STATS
  Not declared in AndroidManifest.xml (it’s a system permission).

 */

@Composable
fun TestingUi(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyColumn {
            items(20) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.telegram),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )

                    Text(
                        "1"
                    )
                }
            }
        }


        CircularConfirmButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 50.dp),
            onClick = {
                Toast.makeText(context,"This hi", Toast.LENGTH_LONG).show()
            },
            imageContent = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(
                        dimensionResource(R.dimen.dimen_28dp)
                    )
                )
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HabitChangeTheme {
        TestingUi()
    }
}