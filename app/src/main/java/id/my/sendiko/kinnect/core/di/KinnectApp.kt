package id.my.sendiko.kinnect.core.di

import android.app.Application

class KinnectApp: Application() {

    companion object {
        lateinit var modules: Modules
    }

    override fun onCreate() {
        super.onCreate()
        modules = AppModule(this)
    }

}