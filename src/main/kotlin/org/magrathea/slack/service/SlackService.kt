package org.magrathea.slack.service

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.methods.MethodsClient
import org.magrathea.slack.config.SlackConfigurationProperties
import org.magrathea.slack.dto.SlackSlashCommandRequest
import org.magrathea.slack.interactor.SlackSetDoNotDisturbInteractor
import org.magrathea.slack.interactor.SlackStopDoNotDisturbInteractor
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
open class SlackService(slack: Slack, slackConfigurationProperties: SlackConfigurationProperties) : ISlackService {

    private val methodsClient: MethodsClient = slack.methods(slackConfigurationProperties.oAuthToken)

    override fun handlePomodoroRequest(slackSlashCommandRequest: SlackSlashCommandRequest): String {
        when (slackSlashCommandRequest.text) {
            "start" -> return setDoNotDisturb()
            "stop" -> return stopDoNotDisturb()
        }

        return "Unknown command"
    }

     private fun setDoNotDisturb(): String {
        SlackSetDoNotDisturbInteractor.execute(methodsClient)

         return "Pomodoro started"
    }

    private fun stopDoNotDisturb(): String {
        SlackStopDoNotDisturbInteractor.execute(methodsClient)

        return "Pomodoro stopped"
    }
}
