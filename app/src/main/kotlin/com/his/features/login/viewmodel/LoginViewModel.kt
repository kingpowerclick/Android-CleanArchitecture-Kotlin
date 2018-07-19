package com.his.features.login.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.his.core.platform.BaseViewModel
import com.his.core.platform.DefaultDisposable
import com.his.features.login.data.usecase.LoginByUserId
import com.his.features.login.view.model.UserLogin
import com.his.features.login.view.model.params.UserLoginParams
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val mLogin: LoginByUserId) : BaseViewModel() {
	var userLogin: MutableLiveData<UserLogin> = MutableLiveData()

	fun signIn(email: String, password: String) {
		val params = UserLoginParams(
			clientId = KEY_CLIENT_ID,
			clientSecret = KEY_CLIENT_SECRET,
			email = email,
			password = password
		)
		mLogin.execute(LoginObserver(), params)
	}

	private inner class LoginObserver : DefaultDisposable<UserLogin>() {
		override fun onError(e: Throwable) {
			Timber.e("Sign In Error")
			handleFailure(e)
		}

		override fun onNext(t: UserLogin) {
			if (t.accessToken.isNullOrEmpty()) {
				Timber.e("Sign In Fail")
			}
			else {
				Timber.e("Sign In Success")
				userLogin.value = t
			}
		}
	}

	companion object {
		private const val KEY_CLIENT_ID = "2"
		private const val KEY_CLIENT_SECRET = "GipwZrnLkZfzEIOBHchQ9YtcILc1eg8fh4ZvNukY"
	}
}