package independent.dev.presentation.contact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class ContactActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuiaDeEscaladaTheme {
                ContactScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ContactScreen() {
        GuiaDeEscaladaTheme {
            Image(
                painter = painterResource(id = R.drawable.converter_background),
                contentDescription = stringResource(id = R.string.ha_background_image),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}