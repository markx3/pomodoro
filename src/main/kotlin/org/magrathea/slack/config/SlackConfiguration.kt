package org.magrathea.slack.config

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.methods.request.oauth.OAuthAccessRequest
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces
import javax.inject.Inject

@Dependent
class SlackConfiguration
    @Inject
    constructor(private val slackConfigurationProperties: SlackConfigurationProperties) {

    @Produces
    fun slack(): Slack {
        return Slack.getInstance().apply {
            methods().oauthAccess(oAuthAccessRequest())
        }
    }

    private fun oAuthAccessRequest(): OAuthAccessRequest {
       return OAuthAccessRequest.builder()
               .clientId(slackConfigurationProperties.clientId)
               .clientSecret(slackConfigurationProperties.clientSecret)
               .build()
    }
}
