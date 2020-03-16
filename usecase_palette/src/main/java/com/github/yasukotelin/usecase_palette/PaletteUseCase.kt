package com.github.yasukotelin.usecase_palette

import android.graphics.Bitmap
import android.graphics.Color
import androidx.palette.graphics.Palette

interface PaletteUseCase {
    suspend fun getMutedColor(bitmap: Bitmap): Int
    suspend fun getVibrantColor(bitmap: Bitmap): Int
}

class PaletteUseCaseImpl : PaletteUseCase {
    override suspend fun getMutedColor(bitmap: Bitmap): Int {
        return Palette.from(bitmap).generate().getMutedColor(Color.BLACK)
    }

    override suspend fun getVibrantColor(bitmap: Bitmap): Int {
        return Palette.from(bitmap).generate().getVibrantColor(Color.BLACK)
    }
}

