package com.zhongfei.im

import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}

/**
  * @Auther: yuli
  * @Date: 2019/6/4 15:26
  * @Description:
  */
class AkkademyDbSpec extends FunSpecLike with Matchers{
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5,TimeUnit.SECONDS)
  describe("akkademyDb"){
    describe("give SetRequest"){
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key","value")
        val actor = actorRef.underlyingActor
        actor.map.get("key") should equal(Some("value"))
      }
    }
  }
}
