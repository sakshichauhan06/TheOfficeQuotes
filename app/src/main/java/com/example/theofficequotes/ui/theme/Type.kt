package com.example.theofficequotes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.theofficequotes.R
import com.example.theofficequotes.ui.theme.Typography

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val ralewayFont = FontFamily(
    Font(GoogleFont("Raleway"), provider)
)
val homemadeAppleFont = FontFamily(
    Font(GoogleFont("Homemade Apple"), provider)
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ralewayFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = ralewayFont,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = ralewayFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = homemadeAppleFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = homemadeAppleFont,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = homemadeAppleFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    )

)


