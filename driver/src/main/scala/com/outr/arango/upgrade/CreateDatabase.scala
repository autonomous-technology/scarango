package com.outr.arango.upgrade
import com.outr.arango.Graph

import scala.concurrent.Future
import scribe.Execution.global

object CreateDatabase extends DatabaseUpgrade {
  override def applyToNew: Boolean = true
  override def blockStartup: Boolean = true
  override def alwaysRun: Boolean = true

  override def upgrade(graph: Graph): Future[Unit] = scribe.async {
    for {
      databases <- graph.arangoDB.api.system.list()
      _ <- if (databases.result.getOrElse(Nil).contains(graph.databaseName)) {
        Future.successful(())             // Database already exists
      } else {
        graph.arangoDatabase.create()     // Database needs to be created
      }
      collections <- graph.arangoDatabase.collections().map(_.map(_.name).toSet)
      views <- graph.arangoDatabase.views().map(_.map(_.name).toSet)
      _ <- Future.sequence(graph.collections.map(c => c.create(!collections.contains(c.name))))   // Create collections
      _ <- Future.sequence(graph.views.map(v => v.create(!views.contains(v.name))))
    } yield {
      ()
    }
  }
}