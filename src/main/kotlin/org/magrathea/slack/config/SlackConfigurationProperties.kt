package org.magrathea.slack.config

import io.quarkus.arc.config.ConfigProperties

@ConfigProperties(prefix = "slack")
interface SlackConfigurationProperties {

    fun getClientId() : String
    fun getClientSecret() : String
}