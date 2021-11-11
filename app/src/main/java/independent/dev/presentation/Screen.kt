package independent.dev.presentation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object UnitConverterScreen: Screen("unit_converter_screen")
    object ContactScreen: Screen("contact_screen")
    object GymsScreen: Screen("gyms_screen")
    object ToposScreen: Screen("topos_screen")
}
