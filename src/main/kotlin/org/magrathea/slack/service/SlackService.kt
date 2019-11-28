package org.magrathea.slack.service

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.methods.MethodsClient
import org.magrathea.slack.config.SlackConfigurationProperties
import org.magrathea.slack.interactor.SlackSetDoNotDisturbInteractor
import org.magrathea.slack.interactor.SlackStopDoNotDisturbInteractor
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
open class SlackService(slack: Slack, slackConfigurationProperties: SlackConfigurationProperties) : ISlackService {

    var methodsClient: MethodsClient? = null

    init {
        this.methodsClient = slack.methods(slackConfigurationProperties.oAuthToken)
    }

    override fun setDoNotDisturb() {
        methodsClient?.let { SlackSetDoNotDisturbInteractor.execute(it) };
    }

    override fun stopDoNotDisturb() {
        methodsClient?.let { SlackStopDoNotDisturbInteractor.execute(it) }
    }
}
