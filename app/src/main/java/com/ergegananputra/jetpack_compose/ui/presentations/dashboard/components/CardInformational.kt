package com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun CardInformational(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp,

        modifier= modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp, 8.dp)
        ) {
            Icon(
                Icons.Filled.Info, contentDescription = "Info",
                modifier = Modifier.padding(
                    top = 8.dp,
                    end = 8.dp
                )
            )
            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Lazy List & API Fetch Example",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Sling Academy: Sample Photos - Free Fake REST API for Practice",
                    style = MaterialTheme.typography.labelSmall,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}