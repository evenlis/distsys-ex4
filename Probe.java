import java.util.*;
import java.rmi.*;

class Probe extends Thread {

    private ArrayList transactionIdList;
    private ServerImpl server;
    private int tId, sId;

    Probe(ServerImpl server, ArrayList transactionIdList, int transactionId, int serverId) {
        this.server = server;
        this.transactionIdList = transactionIdList;
        this.transactionId = TransactionId;
        this.serverId = serverId;
    }

    public void run() {
        this.ids.add(this.tId);
        this.server.println("Probing server "+this.ids, this.tId);
        try {
            this.server.getServer(this.sId).probe(this.ids);
        }
        catch (RemoteException err) {
        }
    }
}
