package com.rach.habitchange.presentations.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rach.habitchange.R
import com.rach.habitchange.presentations.ui.SingleAppDataAnalysisScreen
import com.rach.habitchange.presentations.ui.homescreen.HomeScreen
import com.rach.habitchange.presentations.ui.selectApp.SelectAppScreen

@Composable
fun MyNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.normal_padding)),
                onFloatingButtonClicked = { navController.navigate(Screens.SelectAppScreen.route) },
                onAppClick = { packageName, appName, todayUsage ->
                    navController.navigate(
                        Screens.SingleAppDataAnalysisScreen.createRoute(
                            packageName = packageName,
                            appName = appName,
                            todayUsage = todayUsage
                        )
                    )
                }
            )
        }

        composable(route = Screens.SelectAppScreen.route) {
            SelectAppScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.normal_padding)),
                onNavBackClick = { navController.navigateUp() }
            )
        }

        composable(route = Screens.SingleAppDataAnalysisScreen.pattern) { backStackEntry ->
            val packageName = backStackEntry.arguments?.getString("packageName") ?: ""
            val appName = backStackEntry.arguments?.getString("appName") ?: ""
            val todayUsage = backStackEntry.arguments?.getString("todayUsage")?.toLongOrNull() ?: 0L
            SingleAppDataAnalysisScreen(
                appName = appName,
                todayUsage = todayUsage,
                packageName = packageName,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }

}