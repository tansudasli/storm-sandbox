import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class Bolt extends BaseBasicBolt {
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        //toDO: implement transformation logic

        //toDo: emit message, use new Values(input.getInteger(0)) w/ comma separated list of strings
        collector.emit(new Values(input.getString(0)));

        System.out.println(input.getString(0) + " after Bolt");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //step - 5: declare new Fields() w/ comma separated list of strings
        declarer.declare(new Fields("word"));
    }
}
