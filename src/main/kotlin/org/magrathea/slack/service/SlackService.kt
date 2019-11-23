package org.magrathea.slack.service

import com.github.seratch.jslack.Slack
import org.magrathea.slack.interactor.SlackSetDoNotDisturbInteractor
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default

@Default
@ApplicationScoped
class SlackService : ISlackService {

    override fun setDoNotDisturb(token : String) {
        SlackSetDoNotDisturbInteractor.execute(Slack.getInstance().methods(token))
    }
}