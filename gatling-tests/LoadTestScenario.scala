package TechArticleDemos

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadTestScenario extends Simulation {

    val httpBaseProtocol = http
        .baseUrl("http://localhost:19080") // protocol + FQDN
        .acceptHeader("*/*")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .acceptEncodingHeader("gzip, deflate")

    val scn = scenario("Plain Text").forever {
        exec(http("plain_text").get("/endpoint"))
    }

    setUp(
        scn.inject(
            incrementConcurrentUsers(256)
                .times(8)
                .eachLevelLasting(20 seconds)
                .separatedByRampsLasting(10 seconds)
                .startingFrom(0)
        )
    ).maxDuration(2 minutes).protocols(httpBaseProtocol)
}
