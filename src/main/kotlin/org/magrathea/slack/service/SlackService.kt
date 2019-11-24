package org.magrathea.slack.service

import com.github.seratch.jslack.Slack
import org.magrathea.slack.interactor.SlackSetDoNotDisturbInteractor
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@Default
@ApplicationScoped
open class SlackService(@Inject val slack: Slack) : ISlackService {

    override fun setDoNotDisturb(token: String) {
        SlackSetDoNotDisturbInteractor.execute(slack.methods(token))
    }
}
