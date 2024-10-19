package com.ergegananputra.jetpack_compose.ui.presentations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.ergegananputra.jetpack_compose.R
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme
import com.ergegananputra.jetpack_compose.utils.StringCheckerUtils

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun TopAppBarDeveloperPreview() {
    JetpackCompose2024Theme {
        TopAppBar()
    }
}


@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    notchHeight : Dp = 24.dp,
    title: String = stringResource(id = R.string.app_name),
    leadIconUrl : String = "https://avatars.githubusercontent.com/u/126530940?v=4",
    trailingIcon : @Composable () -> Unit = {}
) {
    val leadIconPainter = if (StringCheckerUtils(leadIconUrl).isHttpUrl()) {
        rememberAsyncImagePainter(leadIconUrl)
    } else {
        painterResource(id = R.drawable.ic_launcher_foreground)
    }

    Surface(
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = notchHeight,
                    start = 4.dp,
                    end = 4.dp,
                    bottom = 4.dp
                )
                .height(64.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            ) {
                Image(
                    painter = leadIconPainter,
                    contentDescription = "Lead Icon Logo",
                    modifier = Modifier
                        .padding(15.dp)
                )
            }


            Text(
                text = title.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
            )

            trailingIcon()
        }
    }
}