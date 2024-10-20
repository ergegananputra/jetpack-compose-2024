package com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.ergegananputra.jetpack_compose.R
import com.ergegananputra.jetpack_compose.domain.entities.room.Photo

@Composable
fun PhotosCard(photo: Photo) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceContainer,
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxWidth()
            ) {
                SubcomposeAsyncImage(
                    model = photo.url,
                    contentDescription = "Image: ${photo.title}",
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    error = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Error Image ${photo.title}"
                        )
                    }
                )
            }

            Text(
                text = photo.title ?: "Title",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = photo.description ?: "-",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}