

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class Spout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;

    }

    @Override
    public void nextTuple() {

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
