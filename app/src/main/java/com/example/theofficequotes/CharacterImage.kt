package com.example.theofficequotes

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CharacterImage(imageUrl: String) {

    AsyncImage(
        model = imageUrl,
        contentDescription = "Character image",
        modifier = Modifier
            .size(240.dp)
            .clip(RectangleShape),
        contentScale = ContentScale.Crop,
    )

}