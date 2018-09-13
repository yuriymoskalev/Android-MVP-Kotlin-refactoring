package ru.wootography.cryptotest.api.endpoints

import io.reactivex.Observable
import retrofit2.http.GET
import ru.wootography.cryptotest.api.ApiResponse
import ru.wootography.cryptotest.models.CryptoItems


interface Crypto {

    @GET("listings/")
    fun getAll(): Observable<ApiResponse<CryptoItems>>
}
