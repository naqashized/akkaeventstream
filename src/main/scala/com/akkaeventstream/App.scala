package com.akkaeventstream

import akka.actor.{ActorSystem, Props}
import com.akkaeventstream.actors.{GameActor, UserActor}
import com.akkaeventstream.models.Game


/**
  * Created by user on 11/04/2016.
  */
object App extends App{


  implicit val system = ActorSystem("eventstream")

  //creating game actor
  val game1 = system.actorOf(Props[GameActor], name = "game1")
  //creating user actors
  val user1 = system.actorOf(Props[UserActor], name = "user1")
  val user2 = system.actorOf(Props[UserActor], name = "user2")

  //game actor tells to publish message for subscribers
  game1 ! Game(id = 123)
}
