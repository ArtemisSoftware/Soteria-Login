package com.artemissoftware.soterialogin.data

import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.data.model.LoggedInUser
import com.artemissoftware.soterialogin.ui.register.models.SafetyQuestion
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }


    companion object{

        val SAFETY_QUESTIONS = listOf<SafetyQuestion>(
            SafetyQuestion("Where do the Gods live?", "Rome", icon = R.drawable.ic_question_1),
            SafetyQuestion("Where is Soteria sanctuary and a statue?", "Patrae", icon = R.drawable.ic_question_2)
        )

    }

}