# MyAppMC

This Android application provides a journey progress trackeing system with features to switch between two lists of stops and corresponding distances with help of Jetpack Compose for building UI components.

## Features

- **Journey Progress Display**: Shows the current stop, distance to the next stop, total distance covered, and total distance left.
- **Unit Switching**: Allows users to toggle between kilometers and miles for distance measurement.
- **List of Stops**: Displays a list of stops in either static or lazy mode, depending on the number of stops.
- **Switch Lists**: Enables users to switch between two predefined lists of stops and distances.

## Components

- **MainActivity**: Entry point of the application.
- **MyAppMC**: Composable function for displaying journey progress and handling UI interactions.
- **Select_List**: Composable function for rendering the UI to switch between lists of stops.
- **StaticList**: Composable function for displaying a static list of stops.
- **Lazyone**: Composable function for displaying a lazy list of stops.
- **PreviewMyAppMC**: Preview function for `MyAppMC`.

##  How to Use

1. **Run the Application**: Install and run the Android application on a compatible device or emulator.
2. **Switch Lists**: Tap on the "Switch lists" button to toggle between two lists of stops and distances.
3. **Monitor Journey Progress**: Track the journey progress displayed on the screen, including the current stop, distance to the next stop, and total distance covered.

## Dependencies

- `androidx.activity:activity-compose`: For managing activity lifecycle and setting content.
- `androidx.compose.foundation:foundation-layout`: For arranging UI elements in a column.
- `androidx.compose.material3:material3`: For using Material Design components.
- `androidx.compose.ui:ui`: For building UI components.
- `androidx.compose.ui:ui-tooling`: For previewing composables.
- `androidx.compose.foundation:foundation`: For building layouts.
- `androidx.compose.runtime:runtime-livedata`: For managing state and recomposition.
- `androidx.compose.foundation:foundation-lazy`: For displaying lazy lists.
- `androidx.activity:activity-ktx`: Kotlin extensions for activity components.
