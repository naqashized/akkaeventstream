package com.akkaeventstream.actors

import akka.actor.Actor
import com.akkaeventstream.models.Game
import org.slf4j.LoggerFactory


/**
  * Created by user on 11/04/2016.
  */
class GameActor extends Actor {

  val log = LoggerFactory.getLogger(classOf[GameActor])
  def receive = {
    case game: Game => {
      log.info(s"Game publishing message =>: $game")
      context.system.eventStream.publish(game)
    }
  }
}
