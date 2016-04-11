package com.akkaeventstream.actors

import akka.actor.Actor
import com.akkaeventstream.models.Game
import org.slf4j.LoggerFactory


/**
  * Created by user on 11/04/2016.
  */
class UserActor extends Actor{

  val log = LoggerFactory.getLogger(classOf[UserActor])
  override def preStart = context.system.eventStream.subscribe(self, classOf[Game])

  def receive = {
    case game: Game => log.info(s"User ${self.path.name} playing game =>: $game")
  }
}
