package com.example.theofficequotes

data class QuoteState(
    val quoteText: String = "Tap to load a quote...",
    val characterName: String = "",
    val imageUrl: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
