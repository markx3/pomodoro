package org.magrathea.slack.service

import org.magrathea.pomodoro.usecase.PomodoroStart
import org.magrathea.pomodoro.usecase.PomodoroStop
import org.magrathea.slack.dto.SlackSlashCommandRequest
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class SlackPomodoroService(val pomodoroStart: PomodoroStart, val pomodoroStop: PomodoroStop): SlackService {

    override fun handleSlackSlashCommand(slackSlashCommandRequest: SlackSlashCommandRequest): String {
        return when (slackSlashCommandRequest.text) {
            "start" -> pomodoroStart.execute()
            "stop" -> pomodoroStop.execute()
            else -> "Unknown command"
        }
    }
}