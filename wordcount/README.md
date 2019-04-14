# Apache Storm - WordCount

This storm application has
* 1 spout for reading file as data source. This file is flatMapped output of Spark's `tansudasli/spark-sandbox/wordcount.py`. 
* 1 Bolt for transforming word's into k,1 and reducing them.

It works on local storm cluster. So no need to install apache storm cluster.

## How to start
- [1] Clone the repository and `cd storm-sandbox/wordcount`.
- [2] Run `./gradlew run` to start distributed computing
- [3] You will see below messages
 ```
  Emitting: Multiply-Bolt default [5314] (this is from debug part 2657*2=5314)
  ------2657  (this is from code whic is emitted by spout)
  ```
  
## The Problem

steps
* read file as lines in the **Spout**, and emit them as `Values()` and `Fields()` to the **Bolt**.
 *So it is not important how you read the file !*
* 
