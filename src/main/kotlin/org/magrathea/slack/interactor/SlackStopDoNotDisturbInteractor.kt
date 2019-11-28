package org.magrathea.slack.interactor

import com.github.seratch.jslack.api.methods.MethodsClient

object SlackStopDoNotDisturbInteractor {

    fun execute(methodsClient: MethodsClient) {
        methodsClient.apply {
            dndEndDnd {
              it
            }
        }
    }
}
