# Apache Storm - Most Popular Movie

This storm application is  very similar of Spark's application `tansudasli/spark-sandbox/most-popular-movie.py`. 


It works on local storm cluster. So no need to install apache storm cluster.

## How to start
- [1] Clone the repository and `cd storm-sandbox/mostpopularmovie`.
- [2] Run `./gradlew run` to start distributed computing
- [3] You will see below messages
 ```
  55971 [Thread-17-fileReaderMovieRatingSpout-executor[2 2]] INFO  o.a.s.d.task - Emitting: 
  fileReaderMovieRatingSpout default [330, 216, 5, 876546470]
  ```
  
## The Problem
 is about, finding most popular movies regarding Rating data. On the other hand, 
 we need movie-name in rating. Instead of joining, we will broadcast movienames to all executers.
 
* So what's the definition of **Popular movie regarding rating data ?**
* How can we **break this problem into Apache Storm building blocks**? 

steps
- [1] **movierating.fileReaderMovieRatingSpout** for Movie Rating data, w/ **shuffleGrouping**
- [2] **movierating.mapMovieRatingFilterColumnsBolt** to reduce columns into `movie-id,1` w/ **fieldsGrouping**
- [3] **movierating.mapMovieRatingReduceSumColumnsBolt** to sum up `movie-id,100`, 
- [4] 
- [5] **movie.fileReaderMovieSpout** for Movie master data.
- [6] 

