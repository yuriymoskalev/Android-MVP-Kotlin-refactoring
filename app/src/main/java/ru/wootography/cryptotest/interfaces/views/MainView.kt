package ru.wootography.cryptotest.interfaces.views

import ru.wootography.cryptotest.models.CryptoItems

interface MainView : BaseView {
    fun setCryptoList(cryptoList: CryptoItems)


}
