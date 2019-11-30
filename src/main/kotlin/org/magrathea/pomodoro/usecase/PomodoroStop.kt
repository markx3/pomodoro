package org.magrathea.pomodoro.usecase

import org.magrathea.pomodoro.service.PomodoroDoNotDisturbService
import org.magrathea.pomodoro.notifier.PomodoroNotifier
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

@Named("pomodoroStop")
@ApplicationScoped
open class PomodoroStop(private val pomodoroDoNotDisturbService: PomodoroDoNotDisturbService,
                        private val pomodoroNotifier: PomodoroNotifier): PomodoroUseCase {

    override fun execute(): String {
        pomodoroDoNotDisturbService.stop()
        pomodoroNotifier.notifyPomodoroStopped()

        return "Pomodoro stopped"
    }
}