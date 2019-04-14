

import movie.fileReaderMovieSpout;
import movierating.fileReaderMovieRatingSpout;
import movierating.mapMovieRatingReduceColumnsBolt;
import movierating.mapMovieRatingReduceSumColumnsBolt;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class mostPopularMovieTopology {

    public static void main(String[] args) throws InterruptedException {
        //Build topology and setup connections between them
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("fileReaderMovieRatingSpout", new fileReaderMovieRatingSpout());
        builder.setBolt("map-Movie-Rating-Reduce-Columns-Bolt", new mapMovieRatingReduceColumnsBolt(), 2)
                .shuffleGrouping("fileReaderMovieRatingSpout");
        builder.setBolt("map-Movie-Rating-Reduce-Columns-Bolt", new mapMovieRatingReduceSumColumnsBolt(), 2)
                .fieldsGrouping("map-Movie-Rating-Reduce-Columns-Bolt", new Fields("movie-id"));

        //second resource dataset
        //builder.setSpout("file-Reader-Movie-Spout", new fileReaderMovieSpout());

        //configuration and print emit messages to the console w/ debugging
        Config config = new Config();
        config.setDebug(true);

        config.put("movieRatingFilePath", "src/main/resources/datasets/ml-100k/u.data");
        config.put("movieFilePath", "src/main/resources/datasets/ml-100k/u.item");

        //Submit topology to cluster
        LocalCluster cluster = new LocalCluster();

        try {
            cluster.submitTopology("most-Popular-Movie-Topology", config, builder.createTopology());

            Thread.sleep(600000);
        } finally {
            cluster.shutdown();
        }

    }
}
