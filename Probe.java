import java.util.*;
import java.rmi.*;

class Probe extends Thread {

    private HashSet<Integer> transactionIdList;
    private ServerImpl server;
    private int transactionId, serverId;

    Probe(ServerImpl server, HashSet<Integer> transactionIdList, int transactionId, int serverId) {
        this.server = server;
        this.transactionIdList = transactionIdList;
        this.transactionId = transactionId;
        this.serverId = serverId;
    }

    public void run() {
        this.transactionIdList.add(this.transactionId);
	System.err.println("Sending probe to server "+transactionId);
        try {
            this.server.getServer(this.serverId).probe(this.transactionIdList);
        }
        catch (RemoteException err) {
        }
    }
}
