package com.zhongfei.im

import akka.actor.{Actor, ActorLogging, Status}

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
      sender() ! Status.Success
    }
    case GetRequest(key) =>
      val response = map.get(key)
      response match {
        case Some(x) => sender() ! x
        case _ => Status.Failure(new KeyNotFoundException(key))
      }
    case _ => Status.Failure(new ClassNotFoundException);
  }
}
