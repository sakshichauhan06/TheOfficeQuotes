package com.example.theofficequotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.theofficequotes.ui.theme.TheOfficeQuotesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TheOfficeQuotesTheme {
                QuoteScreen(viewModel = viewModel())
            }
        }
    }
}
