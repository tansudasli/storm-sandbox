import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class wordCountTopology {

    public static void main(String[] args) throws InterruptedException {
        //Build topology and setup connections between them
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("fileReaderSpout", new fileReaderSpout());
        builder.setBolt("Bolt", new Bolt()).shuffleGrouping("fileReaderSpout");

        //configuration and print emit messages to the console w/ debugging
        Config config = new Config();
        config.setDebug(true);
        config.put("filePath", "src/main/resources/datasets/words/starwars.pre.processed.txt");

        //Submit topology to cluster
        LocalCluster cluster = new LocalCluster();

        try {
            cluster.submitTopology("wordCountTopology", config, builder.createTopology());

            Thread.sleep(2000);
        } finally {
            cluster.shutdown();
        }

    }
}
