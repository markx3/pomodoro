package org.magrathea.slack.interactor

import com.github.seratch.jslack.api.methods.MethodsClient
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndSetSnoozeRequest

object SlackSetDoNotDisturbInteractor {

    fun execute(methodsClient: MethodsClient) {
        methodsClient.apply {
            dndSetSnooze {
                it.numMinutes(25)
            }
        }
    }
}
