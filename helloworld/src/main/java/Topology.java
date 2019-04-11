import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class Topology {

    public static void main(String[] args) throws InterruptedException {
        //Build topology and setup connections between them
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("Integer-Generator-Spout", new Spout());
        builder.setBolt("Multiply-Bolt", new Bolt()).shuffleGrouping("Integer-Generator-Spout");

        //configuration and print emit messages to the console w/ debugging
        Config config = new Config();
        config.setDebug(true);

        //Submit topology to cluster
        LocalCluster cluster = new LocalCluster();

        try {
            cluster.submitTopology("Hello-World-Topology", config, builder.createTopology());

            Thread.sleep(2000);
        } finally {
            cluster.shutdown();
        }

    }
}
