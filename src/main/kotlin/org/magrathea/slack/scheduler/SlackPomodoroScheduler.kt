package org.magrathea.slack.scheduler

import org.magrathea.pomodoro.scheduler.PomodoroScheduler
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class SlackPomodoroScheduler: PomodoroScheduler {

    override fun schedule() {
        println("scheduled")
    }
}