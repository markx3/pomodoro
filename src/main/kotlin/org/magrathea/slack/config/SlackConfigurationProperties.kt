package org.magrathea.slack.config

import io.quarkus.arc.config.ConfigProperties

@ConfigProperties(prefix = "slack")
interface SlackConfigurationProperties {

    val clientId: String
    val clientSecret: String
}
