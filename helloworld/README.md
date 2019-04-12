#Apache Storm - HelloWorld

This storm application has
* 1 spout for generating Integer numbers as data source
* 1 Bolt for transforming emitted Integers into x2 

It works on local storm cluster. So no need to install apache storm cluster.

## How to start
- [1] Clone the repository and `cd storm-sandbox/helloworld`.
- [2] Run `./gradlew run` to start disributed computing
- [3] You will see below messages
 ```
  Emitting: Multiply-Bolt default [5314] (this is from debug part 2657*2=5314)
  ------2657  (this is from code whic is emitted by spout)

