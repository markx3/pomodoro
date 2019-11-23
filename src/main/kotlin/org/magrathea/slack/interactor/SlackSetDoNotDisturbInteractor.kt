package org.magrathea.slack.interactor

import com.github.seratch.jslack.api.methods.MethodsClient
import com.github.seratch.jslack.api.methods.request.dnd.DndSetSnoozeRequest

class SlackSetDoNotDisturbInteractor {

    companion object {
        fun execute(methodsClient: MethodsClient) {
            methodsClient.dndSetSnooze(DndSetSnoozeRequest.builder()
                    .numMinutes(25)
                    .build())
        }
    }
}