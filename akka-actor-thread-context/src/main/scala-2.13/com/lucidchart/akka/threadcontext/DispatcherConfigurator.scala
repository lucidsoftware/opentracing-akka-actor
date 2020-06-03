package com.lucidchart.akka.threadcontext

import akka.dispatch.{Dispatcher, DispatcherPrerequisites, MessageDispatcherConfigurator}
import com.github.threadcontext.Context
import com.typesafe.config.Config
import java.util.concurrent.TimeUnit
import java.util.function.Supplier
import scala.concurrent.duration.DurationLong

class DispatcherConfigurator(config: Config, prerequisites: DispatcherPrerequisites, contextSupplier: Supplier[Context]) extends MessageDispatcherConfigurator(config, prerequisites) {
  override val dispatcher = new Dispatcher(
    this,
    config.getString("id"),
    config.getInt("throughput"),
    config.getDuration("throughput-deadline-time", TimeUnit.NANOSECONDS).nanos,
    configureExecutor(),
    config.getDuration("shutdown-timeout", TimeUnit.MILLISECONDS).millis
  ) { dispatcher =>
    override def execute(runnable: Runnable) = {
      val context = contextSupplier.get()
      super.execute(() => context.run(runnable))
    }
  }
}
