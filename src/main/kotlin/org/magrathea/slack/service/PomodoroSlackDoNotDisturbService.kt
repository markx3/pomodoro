package org.magrathea.slack.service

import com.github.seratch.jslack.Slack
import org.magrathea.pomodoro.service.PomodoroDoNotDisturbService
import org.magrathea.slack.config.SlackConfigurationProperties
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class PomodoroSlackDoNotDisturbService(
        private val slack: Slack,
        private val slackConfigurationProperties: SlackConfigurationProperties): PomodoroDoNotDisturbService {

    override fun stop() {
        slack.methods(slackConfigurationProperties.oAuthToken).dndEndDnd {
            it
        }
    }

    override fun start() {
        slack.methods(slackConfigurationProperties.oAuthToken).dndSetSnooze {
            it.numMinutes(25)
        }
    }
}