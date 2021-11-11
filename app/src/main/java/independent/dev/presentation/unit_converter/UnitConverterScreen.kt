package independent.dev.presentation.unit_converter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import independent.dev.presentation.home.R
import independent.dev.presentation.theme.GuiaDeEscaladaTheme


@Preview(showBackground = true)
@Composable
fun UnitConverterScreen() {
    GuiaDeEscaladaTheme {
        Image(
            painter = painterResource(id = R.drawable.converter_background),
            contentDescription = stringResource(id = R.string.ha_background_image),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}