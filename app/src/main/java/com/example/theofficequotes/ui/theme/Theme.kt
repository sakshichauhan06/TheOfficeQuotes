package com.example.theofficequotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define a basic light color scheme (using default Material colors for now)
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006C4C),
    secondary = Color(0xFF4C6357),
    tertiary = Color(0xFF3E6374)
)

// Define a basic dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF5DD9AA),
    secondary = Color(0xFFBCCBC1),
    tertiary = Color(0xFFA1CCEB)
)

// You will also need a separate file named Color.kt to define the specific Color() objects.
// e.g., val Color(0xFF006C4C) = Color(0xFF006C4C)

@Composable
fun TheOfficeQuotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // You need to define Typography in Type.kt
        content = content
    )
}