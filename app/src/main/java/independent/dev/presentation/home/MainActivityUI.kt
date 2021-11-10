package independent.dev.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import independent.dev.presentation.theme.fontFamily

@Composable
fun MainActivityUI(
    navController: NavController
) {
    Image(
        painter = painterResource(id = R.drawable.home_background),
        contentDescription = stringResource(id = R.string.ha_background_image),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.isotype_white),
                contentDescription = stringResource(id = R.string.ha_logo_description),
                modifier = Modifier.size(width = 55.dp, height = 75.dp)
            )
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onSearch = {
                    //TODO: Implement search logic
                }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.logo_green_white),
            contentDescription = stringResource(id = R.string.ha_logo_description),
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .padding(bottom = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, bottom = 5.dp, end = 5.dp)
                    .weight(1f)
            ) {
                Button(
                    stringResource(id = R.string.ha_topos_button),
                    Modifier.weight(1f)
                )
                Divider(whichType = "vertical")
                Button(
                    stringResource(id = R.string.ha_gyms_button),
                    Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)

            ) {
                Column(Modifier.weight(1f)) {
                    Divider(whichType = "horizontal")
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column(Modifier.weight(1f)) {
                    Divider(whichType = "horizontal")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .weight(1f)
            ) {
                Button(
                    stringResource(id = R.string.ha_converter_button),
                    Modifier.weight(1f)
                )
                Divider(whichType = "vertical")
                Button(
                    stringResource(id = R.string.ha_contact_button),
                    Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun Button(text: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.topos_icon),
            contentDescription = stringResource(id = R.string.ha_topos_button_description)
        )
        ButtonText(text)
    }
}

@Composable
fun ButtonText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colors.primary,
        fontSize = 20.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Divider(whichType: String) {
    if (whichType == "vertical") {
        androidx.compose.material.Divider(
            color = Color.White,
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .padding(vertical = 16.dp)
        )
    } else {
        androidx.compose.material.Divider(
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun SearchBar(modifier: Modifier, onSearch: (String) -> Unit) {

    val hint = stringResource(id = R.string.ha_search)
    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused
                }
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}