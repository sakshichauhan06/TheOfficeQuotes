package com.example.theofficequotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(viewModel: QuoteViewModel) {

    val uiState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "Bear. Beets. Quotes.",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                ) },
                modifier = Modifier
                    .background(Color.Blue),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // applies padding from the scaffold
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // show the loading indicator when fetching the data
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(32.dp))
                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(32.dp))

            // Character Image
            CharacterImage(
                imageUrl = uiState.imageUrl
            )

            Spacer(Modifier.height(32.dp))

            // Quote Text
            Text(
                text = if (uiState.isLoading) "Loading..." else uiState.quoteText,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = if (uiState.isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
            )

            Spacer(Modifier.height(16.dp))

            // Character Name
            Text(
                text = "- ${uiState.characterName}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(Modifier.height(48.dp))

            Spacer(modifier = Modifier.weight(1f))

            // Next Button
            Button(
                onClick = viewModel::fetchRandomQuote,
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp)
                    .padding(bottom = 8.dp),
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                enabled = !uiState.isLoading // disable the button while loading
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }
        }
    }
}


























