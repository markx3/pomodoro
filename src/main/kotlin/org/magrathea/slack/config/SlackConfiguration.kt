package org.magrathea.slack.config

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.methods.request.oauth.OAuthAccessRequest
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces
import javax.inject.Inject

@Dependent
class SlackConfiguration {

    @Inject
    lateinit var slackConfigurationProperties: SlackConfigurationProperties

    @Produces
    fun slack() : Slack {
        val slack = Slack.getInstance()

        slack.methods().oauthAccess(oAuthAccessRequest());

        return slack
    }

    private fun oAuthAccessRequest() : OAuthAccessRequest {
       return OAuthAccessRequest.builder()
               .clientId(slackConfigurationProperties.getClientId())
               .clientSecret(slackConfigurationProperties.getClientSecret())
               .build()
    }
}