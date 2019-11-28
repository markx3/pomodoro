package org.magrathea.slack.interactor

import com.github.seratch.jslack.api.methods.MethodsClient
import com.github.seratch.jslack.api.methods.request.dnd.DndEndDndRequest

object SlackStopDoNotDisturbInteractor {

    fun execute(methodsClient: MethodsClient) {
        methodsClient.dndEndDnd(DndEndDndRequest.builder().build())
    }
}
