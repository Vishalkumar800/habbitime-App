package com.rach.habitchange.presentations.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rach.habitchange.R
import com.rach.habitchange.presentations.ui.homescreen.minToHourMinute
import com.rach.habitchange.presentations.uiComponents.CustomTopAppBar
import com.rach.habitchange.presentations.viewModel.HomeViewModel


@Composable
fun SingleAppDataAnalysisScreen(
    modifier: Modifier = Modifier,
    appName: String,
    todayUsage:Long,
    packageName:String,
    viewModel: HomeViewModel = hiltViewModel(),
    onBackClick:() -> Unit
) {


    LaunchedEffect(Unit) {
        viewModel.fiveDayDataUsage(packageName)
    }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = "Usage Data",
                onNavigationIconClick = {
                    onBackClick()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.normal_padding))
                .padding(paddingValues)
        ) {
            Text("Today Usage $appName")
            Text(minToHourMinute(todayUsage))

            Spacer(modifier = Modifier.height(24.dp))

            // Past 5 din
            Text(
                text = "Last 5 Days",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(12.dp))

            if (uiState.loading) {
                CircularProgressIndicator()
            } else {
                LazyColumn {
                    items(uiState.appsData) {
                        it.date?.let { it1 ->
                            AppDataAnalysis(
                                date = it1,
                                usage = minToHourMinute(it.todayUsageInMinutes)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }

}

@Composable
private fun AppDataAnalysis(date: String, usage: String) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = date,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = usage
        )
    }

}