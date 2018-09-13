package ru.wootography.cryptotest.presenters

import com.arellomobile.mvp.InjectViewState
import ru.wootography.cryptotest.api.ApiResponse
import ru.wootography.cryptotest.api.RestApi
import ru.wootography.cryptotest.interfaces.views.MainView
import ru.wootography.cryptotest.models.CryptoItems
import ru.wootography.cryptotest.utils.RxUtils
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject
internal constructor(private val restApi: RestApi) : BasePresenter<MainView>() {


    init {
        getCryptoItems()
    }

    private fun getCryptoItems() {
        restApi.crypto.getAll()
                .compose(RxUtils.httpSchedulers())
                .subscribe(
                        { response -> successGetList(response) },
                        { error -> handleError(error) }
                )
    }

    private fun handleError(error: Throwable?) {

    }

    private fun successGetList(response: ApiResponse<CryptoItems>) {
        val cryptoList = response.data
        viewState.setCryptoList(cryptoList!!)
    }

}
