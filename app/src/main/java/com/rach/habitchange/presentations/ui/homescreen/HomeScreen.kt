package com.rach.habitchange.presentations.ui.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rach.habitchange.R
import com.rach.habitchange.presentations.ui.NoDataFound
import com.rach.habitchange.presentations.ui.homescreen.components.HomeAppItem
import com.rach.habitchange.presentations.uiComponents.CustomTopAppBar
import com.rach.habitchange.presentations.uiComponents.PermissionDialog
import com.rach.habitchange.presentations.viewModel.HomeViewModel
import com.rach.habitchange.theme.onPrimaryContainerLight

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onFloatingButtonClicked: () -> Unit,
    onAppClick: (packageName: String, appName: String, todayUsage: Long) -> Unit
) {

    val context = LocalContext.current
    val uiState by homeViewModel.uiState.collectAsState()
    val showPermissionDialog by homeViewModel.showPermissionDialog.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            homeViewModel.clearErrorMessage()
        }
    }


    LaunchedEffect(Unit) {
        homeViewModel.loadTodayUsageData()
    }



    AnimatedVisibility(
        visible = showPermissionDialog,
        enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
            animationSpec = tween(300),
            initialOffsetY = { it / 2 }
        ),
        exit = fadeOut(animationSpec = tween(300)) + slideOutVertically(
            animationSpec = tween(300),
            targetOffsetY = { it / 2 }
        )
    ) {
        PermissionDialog(
            onDismissRequest = { homeViewModel.dismissDialog() },
            onConfirmButton = {
                homeViewModel.goToSettingsForRequestUsageStatsPermission()
            },
            title = stringResource(R.string.usage_access_required),
            text = stringResource(R.string.stats_perm_text)
        )
    }
    Scaffold(
        topBar = {
            CustomTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = "Home"
            )
        },
        floatingActionButton = {
            FloatingActionButtonUi(onFloatingButtonClicked, showPermissionDialog)
        },
        floatingActionButtonPosition = FabPosition.Center,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)

        ) {

            when {
                uiState.loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                uiState.appsData.isEmpty() -> {
                    NoDataFound(
                        modifier = Modifier.fillMaxSize(),
                        text = "No App Found ",
                        text2 = "Please Add Apps"
                    )
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(uiState.appsData) {
                            HomeAppItem(
                                appName = it.name,
                                packageName = it.packageName,
                                rank = it.id,
                                usageTime = minToHourMinute(it.todayUsageInMinutes),
                                onClick = {
                                    onAppClick(it.packageName, it.name, it.todayUsageInMinutes)
                                }
                            )
                            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.dimen_12dp)))
                        }
                    }
                }
            }
        }
    }
}


fun minToHourMinute(min: Long): String {
    return when {
        min < 1 -> "0 min"
        min < 60 -> "$min min"
        else -> {
            val hours = min / 60
            val minutes = min % 60

            if (minutes == 0L) {
                "$hours hr"
            } else {
                "$hours hr $minutes min"
            }
        }
    }
}


@Composable
private fun FloatingActionButtonUi(
    onFloatingButtonClicked: () -> Unit,
    showPermissionDialog: Boolean
) {
    IconButton(
        onClick = {
            onFloatingButtonClicked()
        },
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = onPrimaryContainerLight.copy(alpha = 0.9f)
        ),
        modifier = Modifier.size(dimensionResource(R.dimen.dimen_50dp)),
        enabled = !showPermissionDialog
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.floating_action_button),
            modifier = Modifier.size(dimensionResource(R.dimen.dimen_30dp)),
            tint = Color.White
        )
    }
}

