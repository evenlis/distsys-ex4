import java.util.*;
import java.rmi.*;

class Probe extends Thread {

    private ArrayList transactionIdList;
    private ServerImpl server;
    private int transactionId, serverId;

    Probe(ServerImpl server, ArrayList transactionIdList, int transactionId, int serverId) {
        this.server = server;
        this.transactionIdList = transactionIdList;
        this.transactionId = TransactionId;
        this.serverId = serverId;
    }

    public void run() {
        this.transactionIdList.add(this.transactionId);
        this.server.println("Probing server "+this.transactionIdList, this.transactionId);
        try {
            this.server.getServer(this.serverId).probe(this.transactionIdList);
        }
        catch (RemoteException err) {
        }
    }
}
