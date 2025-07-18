package com.rach.habitchange.presentations.navigation

sealed class Screens(
    val route: String
) {
    object HomeScreen : Screens("HomeScreen")
    object SelectAppScreen : Screens("SelectAppScreen")
    object SingleAppDataAnalysisScreen : Screens("SingleAppDataAnalysisScreen") {
        val pattern = "SingleAppDataAnalysisScreen/{packageName}/{appName}/{todayUsage}"

        fun createRoute(packageName: String, todayUsage: Long, appName: String): String {
            return "SingleAppDataAnalysisScreen/$packageName/$appName/$todayUsage"
        }
    }

}