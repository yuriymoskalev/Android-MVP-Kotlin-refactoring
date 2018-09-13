package ru.wootography.cryptotest.activities


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*

import ru.wootography.cryptotest.R
import ru.wootography.cryptotest.adapters.CryptoAdapter
import ru.wootography.cryptotest.interfaces.views.MainView
import ru.wootography.cryptotest.models.CryptoItems
import ru.wootography.cryptotest.presenters.MainActivityPresenter
import ru.wootography.cryptotest.utils.Injector

class MainActivity : BaseActivity(), MainView {


    lateinit var cryptoAdapter : CryptoAdapter


    companion object {
        private val LAYOUT = R.layout.activity_main
    }


    @InjectPresenter
    lateinit var mainPresenter: MainActivityPresenter

    @ProvidePresenter
    internal fun provideMainActivityPresenter(): MainActivityPresenter {
        return Injector.presenterComponent!!.mainActivityPresenter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        setupUI()

        rv_crypto_list.layoutManager = LinearLayoutManager(this)
    }

    override fun setCryptoList(cryptoList: CryptoItems) {
        cryptoAdapter = CryptoAdapter(cryptoList)
        rv_crypto_list.adapter = cryptoAdapter
    }

    override fun setupUI() {

    }

    override fun setupUX() {

    }


}
