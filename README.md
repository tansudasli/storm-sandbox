# storm-sandbox
This is an IntelliJ workspace which contains many project as **modules**. So every app contains their own gradle scripts.

Every storm application contains:
 * fileReaderSpout,
 * xxxBolt, and
 * xxxTopology files.

#### File Structure

- [x] **template** to create storm application rapidly. It contains general structure and code units for generating storm apps.<br> 
    - In Spout: open, nextTuple and declareOutputFields <br>
    - In Bold: execute and declareOutputFields <br>
    - In Topology: draw the topology and create cluster and execution.
- [x] **helloworld** storm application. Read `/helloworld/README.md` file for more details.
- [x] **wordcount** storm application. Read `/wordcount/README.md` file for more details.
- [x] **mostpopularmovie** storm application. Read `/mostpopularmovie/README.md` file for more details.  

## How To Start
- [1] clone this git rep.
- [2] open w/ IntelliJ community or Ultimate edition
- [3] Look for the project folders and README.md files to run them separately.
- [4] No need to install gradle sdk. 


## How to install Apache Storm Cluster on GCP instances
Storm applications run on local IDE environment. But some of them (such as mostpopularmovie) needs more resources to complete :)

High level architecture is
* 1 server for zookeeper (standalone, small machine is enough for storm). no need for clustered installation for now.
* 1 server for Apache Storm nimbus
* 2 servers for Apache Storm executors

- [1] 
