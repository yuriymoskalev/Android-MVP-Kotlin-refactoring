package ru.wootography.cryptotest.models

data class CryptoItem(
        val itemId: Long,
        val name: String,
        val symbol: String,
        val websiteSlug: String
)