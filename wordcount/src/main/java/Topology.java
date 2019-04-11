import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class Topology {

    public static void main(String[] args) throws InterruptedException {
        //Build topology and setup connections between them
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("Spout", new Spout());
        builder.setBolt("Bolt", new Bolt()).shuffleGrouping("Spout");

        //configuration and print emit messages to the console w/ debugging
        Config config = new Config();
        config.setDebug(true);

        //Submit topology to cluster
        LocalCluster cluster = new LocalCluster();

        try {
            cluster.submitTopology("Topology", config, builder.createTopology());

            Thread.sleep(1000);
        } finally {
            cluster.shutdown();
        }

    }
}
