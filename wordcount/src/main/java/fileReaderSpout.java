import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class fileReaderSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private String filePath;
    private List<String> lines;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;

        filePath = conf.get("filePath").toString();

        //Step -1 : read file as lines
        try {
           lines = Files.readAllLines(Paths.get(filePath), UTF_8);


        } catch (IOException e) {
            e.printStackTrace();
        }

        //use Files and Path ! that's the old style
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

    }

    @Override
    public void nextTuple() {

        //Step -2 : read file as lines
        //toDo: emit message, use new Values() w/ comma separated list of strings
        this.collector.emit(new Values());

        //toDo: implement your action
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        //toDo: declare new Fields() w/ comma separated list of strings
        declarer.declare(new Fields("field"));

    }
}
