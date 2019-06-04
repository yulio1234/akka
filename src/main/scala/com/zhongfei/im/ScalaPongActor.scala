package com.zhongfei.im

import akka.actor.{Actor, Status}

/**
  * @Auther: yuli
  * @Date: 2019/6/4 16:12
  * @Description:
  */
class ScalaPongActor extends Actor{
  override def receive: Receive = {
    case "Ping" => sender() ! "Pong";
    case _ => Status.Failure(new Exception("unkonwn message"))
  }
}
