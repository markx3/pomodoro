package org.magrathea.pomodoro.usecase

import org.magrathea.pomodoro.service.PomodoroDoNotDisturbService
import org.magrathea.pomodoro.scheduler.PomodoroScheduler
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class PomodoroStart(private val pomodoroDoNotDisturbHandler: PomodoroDoNotDisturbService,
                         private val pomodoroScheduler: PomodoroScheduler): PomodoroUseCase {

    override fun execute(): String {
        pomodoroDoNotDisturbHandler.start()
        pomodoroScheduler.schedule()

        return "Pomodoro started"
    }
}