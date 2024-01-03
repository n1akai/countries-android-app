package com.n1akai.countrieschallenge.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: Name,
    val tld: List<String>,
    val currencies: Currencies,
    val capital: List<String>,
    val region: String,
    val subregion: String,
    val languages: Languages,
    val population: Long,
    val flags: Flags,
    val borders: List<String>
) : Parcelable {

    @Parcelize
    data class Name(
        val common: String,
        val official: String,
        val nativeName: NativeName,
    ) : Parcelable

    @Parcelize
    data class NativeName(
        val eng: Eng,
    ) : Parcelable

    @Parcelize
    data class Eng(
        val official: String,
        val common: String,
    ) : Parcelable

    @Parcelize
    data class Currencies(
        val aud: Aud,
    ) : Parcelable

    @Parcelize
    data class Aud(
        val name: String,
        val symbol: String,
    ) : Parcelable

    @Parcelize
    data class Languages(
        val eng: String,
    ) : Parcelable

    @Parcelize
    data class Flags(
        val png: String,
        val svg: String,
    ) : Parcelable
}
