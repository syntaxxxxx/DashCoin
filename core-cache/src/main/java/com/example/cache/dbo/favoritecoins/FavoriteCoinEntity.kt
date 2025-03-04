package com.example.cache.dbo.favoritecoins

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mathroda.domain.model.FavoriteCoin
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Entity(
    tableName = "FavoriteCoin"
)
@Parcelize
data class FavoriteCoinEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "CoinId") val coinId: String,
    @ColumnInfo(name = "Name") val name: String?,
    @ColumnInfo(name = "Symbol") val symbol: String?,
    @ColumnInfo(name = "Icon") val icon: String?,
    @ColumnInfo(name = "Price") val price: Double?,
    @ColumnInfo(name = "Rank") val rank: Int,
    @ColumnInfo(name = "PriceChanged1d") val priceChanged1d: Double?,
    @ColumnInfo(name = "PriceChanged1h") val priceChanged1h: Double?,
    @ColumnInfo(name = "PriceChanged1w") val priceChanged1w: Double?,
): Parcelable

fun FavoriteCoinEntity.toDomain(): FavoriteCoin {
    return FavoriteCoin(
        coinId = coinId,
        name = name ?: "",
        symbol = symbol ?: "",
        icon = icon ?: "",
        price = price ?: 0.0,
        rank = rank,
        priceChanged1d = priceChanged1d ?: 0.0,
        priceChanged1h = priceChanged1h ?: 0.0,
        priceChanged1w = priceChanged1w ?: 0.0
    )
}

fun FavoriteCoin.toEntity(): FavoriteCoinEntity {
    return FavoriteCoinEntity(
        coinId = coinId,
        name = name,
        symbol = symbol,
        icon = icon,
        price = price,
        rank = rank,
        priceChanged1d = priceChanged1d,
        priceChanged1h = priceChanged1h,
        priceChanged1w = priceChanged1w
    )
}

