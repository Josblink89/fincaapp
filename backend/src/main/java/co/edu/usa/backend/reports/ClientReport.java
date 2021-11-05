package co.edu.usa.backend.reports;

import co.edu.usa.backend.model.Client;

public class ClientReport {
    private Long total;
    private Client client;

    public ClientReport(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
