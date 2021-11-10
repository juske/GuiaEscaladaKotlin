package independent.dev.presentation

sealed class Screen(route: String) {
    object HomeScreen: Screen("home_screen")
    object UnitConverterScreen: Screen("unit_converter_screen")
}
