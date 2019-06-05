package com.zhongfei.im

import akka.actor.Status.Failure
import akka.actor.{Actor, ActorLogging, Status}

/**
  * @Auther: yuli
  * @Date: 2019/6/4 16:12
  * @Description:
  */
class ScalaPongActor extends Actor with ActorLogging{
  override def receive: Receive = {
    case "Ping" => sender() ! "Pong";
    case _ => sender() ! Failure(new Exception("unkonwn message"))
  }
}
