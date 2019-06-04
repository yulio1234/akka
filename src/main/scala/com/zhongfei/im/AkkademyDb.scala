package com.zhongfei.im

import akka.actor.{Actor, ActorLogging}

import scala.collection.mutable

/**
  * @Auther: yuli
  * @Date: 2019/6/4 14:50
  * @Description:
  */
class AkkademyDb extends Actor with ActorLogging{
  val map = new mutable.HashMap[String,Object]()
  override def receive: Receive = {
    case SetRequest(key,value) =>{
      log.info("received SetRequest - key :{}: value :{}",key,value)
      map.put(key,value)
    }
    case o => log.info("received unknown message:{}",o);
  }
}
