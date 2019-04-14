# Apache Storm - Most Popular Movie

This storm application has
* 1 spout for reading file as data source. This file is flatMapped output of Spark's `tansudasli/spark-sandbox/most-popular-movie.py`. 
* 1 Bolt for transforming word's into k,1 and reducing them.

It works on local storm cluster. So no need to install apache storm cluster.

## How to start
- [1] Clone the repository and `cd storm-sandbox/mostpopularmovie`.
- [2] Run `./gradlew run` to start distributed computing
- [3] You will see below messages
 ```
  9774 [Thread-22-Bolt-executor[1 1]] INFO  o.a.s.d.task - Emitting: Bolt default [Another]
  Another after Bolt
  ```
  
## The Problem
 is about, finding most popular movies regarding Rating data. On the other hand, 
 we need movie-name in rating. Instead of joining, we will broadcast movienames to all executers.
 
<br> So what's the definition of **Popular movie regarding rating data ?**
<br> How can we **break this problem into Apache Storm building blocks**? 

steps
- [1] read file as lines in the **fileReaderSpout**.  
- [2] emit them as `Values()` to the **Bolt**.
- [3] declare them as `Fields()` to the **Bolt**.
- [4] emit them as `Values()` in the **Bolt**.
- [5] declare them as `Fields()` in the **Bolt**.
- [6] build topology in the **wordCountTopology**.
