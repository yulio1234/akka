package com.zhongfei.im

import java.util.concurrent.TimeUnit

import akka.actor.Status.Success
import akka.actor.{ActorRef, ActorSystem, Props, Status}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.Failure

/**
  * @Auther: yuli
  * @Date: 2019/6/4 16:39
  * @Description:
  */

class ScalaAskExamplesTest extends FunSpecLike with Matchers{
   val system = ActorSystem()
   implicit val timeout = Timeout(5,TimeUnit.SECONDS)
   val pongActor: ActorRef = system.actorOf(Props(classOf[ScalaPongActor]))
  import scala.concurrent.ExecutionContext.Implicits.global
//  describe("Pong actor"){
//    it("should respond with Pong"){
//      val future = pongActor ? "Ping"
//      val result = Await.result(future.mapTo[String], 1 seconds)
//      assert(result == "Pong")
//    }
//
//    it ("should fail on unknown message"){
//      val future = pongActor ? "unknown"
//      intercept[Exception]{
//        Await.result(future.mapTo[String],1 second)
//      }
//    }
//
//    it("should print to console"){
//      (pongActor ? "Ping").onSuccess({
//        case x:String => println("replied with :" + x)
//      })
//      Thread.sleep(1000)
//    }
//  }
//  describe("Pong actor link"){
//    val f = askPong("Pin1g")
//      .flatMap(askPong).recover({case t:Exception => "error"}).onComplete({
//      case Failure(exception) => println(exception)
//    case util.Success(value) => println(value)})
//  }

  describe("list future"){
    val f1 = Future{3}
    val f2 = Future{4}
    val f3 = for(res1<-f1;res2<-f2)yield res1+res2
    f3.onComplete({ case Failure(exception) => println(exception)
    case util.Success(value) => println(value)})

    //反转结果集
    val listOfFuture:List[Future[String]] = List("Pong","Pong","failed").map(askPong)
    //处理反转后的异常
    val futureOfList:Future[List[String]] = Future.sequence(listOfFuture.map(_.recover{case Exception=>""}))

  }
  def askPong(message:String):Future[String] =(pongActor? message).mapTo[String]
}

