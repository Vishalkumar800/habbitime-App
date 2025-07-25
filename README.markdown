# Habitime: Screen Time Tracker

![App Logo](https://via.placeholder.com/150) <!-- Replace with your actual app logo URL -->

**Habitime: Screen Time Tracker** is an Android application designed to help users monitor and manage their screen time on specific apps, such as Instagram, WhatsApp, YouTube, and more. With Habitime, users can select apps to track and view detailed usage statistics to promote healthier digital habits. The app is live on the Google Play Store!

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png)](https://play.google.com/store/apps/details?id=com.rach.habitchange)

## App Details

- **Content Rating**: Everyone
- **Downloads**: 10+
- **Contains Ads**: Yes
- **Package Name**: com.rach.habitchange

## Features

- **App Selection**: Choose specific apps (e.g., Instagram, WhatsApp, YouTube, Facebook, Twitter/X) to monitor usage.
- **Screen Time Tracking**: Track daily usage time for selected apps.
- **Usage Insights**: View detailed statistics to understand and manage your app usage habits.
- **Lightweight and User-Friendly**: Simple interface with minimal permissions for a seamless experience.
- **Ad-Supported**: Integrated with Google AdMob for a free user experience.

## Permissions

Habitime requires the following permissions to function effectively:
- **Internet**: For fetching ads and analytics (if applicable).
- **Access Network State**: To check network connectivity.
- **Package Usage Stats**: To track app usage time (requires user approval).
- **Foreground Service**: To run background tasks for accurate tracking.
- **Post Notifications**: To send usage alerts or reminders (optional).

## Supported Apps

Habitime can track usage for popular apps, including but not limited to:
- Instagram
- WhatsApp
- YouTube
- Facebook
- Twitter/X
- Any app with a launcher intent (configurable in the app).

## Installation

### Download from Google Play
- Install Habitime directly from the Google Play Store: [Habitime: Screen Time Tracker](https://play.google.com/store/apps/details?id=com.rach.habitchange)
- Grant the required permissions (e.g., Usage Access) during setup.

### Build from Source
#### Prerequisites
- Android device running API 21 (Lollipop) or higher.
- Android Studio with the latest Android SDK installed.

#### Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Vishalkumar800/habbitime-App.git
   ```
2. **Open in Android Studio**:
   - Import the project into Android Studio.
3. **Configure AdMob**:
   - Replace `${ADMOB_APP_ID}` in the `AndroidManifest.xml` with your AdMob App ID.
4. **Build and Run**:
   - Sync the project with Gradle.
   - Build and run the app on an emulator or physical device.

## Project Structure

- **MainActivity**: Entry point of the app, handling the main UI and app selection.
- **Dagger Hilt**: Used for dependency injection to manage app components.
- **Resources**:
  - App name: `Habitime: Screen Time Tracker`
  - Custom splash screen theme: `Theme.AppSplashScreenStart`
- **Permissions**: Defined in `AndroidManifest.xml` for usage tracking and notifications.
- **Queries**: Supports tracking specific apps and all launchable apps.

## How to Use

1. Install and launch the Habitime app from the Google Play Store.
2. Grant the required permissions (e.g., Usage Access).
3. Select the apps you want to track (e.g., Instagram, WhatsApp).
4. View daily usage statistics on the app dashboard.
5. Adjust your habits based on insights provided by Habitime.

## Contributing

Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

Please ensure your code follows the project's coding standards and includes relevant tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For questions or feedback, reach out to [Vishalkumar800](https://github.com/Vishalkumar800) or open an issue on this repository.