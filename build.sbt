import sbt.Resolver

name := "bank-reputation-frontend-journey-tests"

version := "0.1.0"

scalaVersion := "2.11.11"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
resolvers += Resolver.bintrayRepo("hmrc", "releases")

  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report")
  testOptions in Test += Tests.Argument("-o")

libraryDependencies ++= Seq(
  "uk.gov.hmrc"                %% "webdriver-factory"       % "0.7.0"   % "test",
  "org.scalatest"              %% "scalatest"               % "3.0.7" % "test",
  "org.pegdown"                %  "pegdown"                 % "1.2.1" % "test",
  "uk.gov.hmrc"                %% "zap-automation"          % "2.1.0"  % "test",
  "com.typesafe"               %  "config"                  % "1.3.2"
  )

