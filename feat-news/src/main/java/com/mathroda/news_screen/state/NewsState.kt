package com.mathroda.news_screen.state

data class NewsState(
    val isLoading: Boolean = false,
    val news: List<com.mathroda.domain.NewsDetail> = emptyList(),
    val error: String = ""
)
