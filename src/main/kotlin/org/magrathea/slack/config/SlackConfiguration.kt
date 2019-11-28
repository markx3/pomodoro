package org.magrathea.slack.config

import com.github.seratch.jslack.Slack
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
open class SlackConfiguration {

    @Produces
    fun slack(): Slack {
        return Slack.getInstance()
    }
}
