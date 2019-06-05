package com.zhongfei.im

import akka.actor.{ActorSystem, Props}

object Main extends App {
  private val system = ActorSystem("akkademy")
  system.actorOf(Props[AkkademyDb],"akkademy-db")

}
