package com.zhongfei.im

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * @Auther: yuli
  * @Date: 2019/6/4 16:39
  * @Description:
  */

class ScalaAskExamplesTest extends FunSpecLike with Matchers{
   val system = ActorSystem()
   implicit val timeout = Timeout(5,TimeUnit.SECONDS)
   val pongActor: ActorRef = system.actorOf(Props(classOf[ScalaPongActor]))
  describe("Pong actor"){
    if("should respond with Pong"){
      val future = pongActor ? "Ping"
      val result = Await.result(future.mapTo[String], 1 seconds)
      assert(result == "Pong")
    }

    it ("should fail on unknown message"){
      val future = pongActor ? "unknown"
      intercept[Exception]{
        Await.result(future.mapTo[String],1 second)
      }
    }
  }
}

