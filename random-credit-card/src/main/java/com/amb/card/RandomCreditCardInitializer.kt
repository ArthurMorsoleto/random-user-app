package com.amb.card

import android.content.Context
import android.content.Intent
import com.amb.card.di.modules.CreditCardModuleProvider
import com.amb.card.presentation.CreditCardActivity
import com.amb.network.ApiBuilder
import org.koin.core.module.Module

object RandomCreditCardInitializer {

    fun init(apiBuilder: ApiBuilder): List<Module> {
        return CreditCardModuleProvider(apiBuilder).creditCardModules
    }

    fun openRandomCreditCardScreen(context: Context) {
        context.startActivity(Intent(context, CreditCardActivity::class.java))
    }
}