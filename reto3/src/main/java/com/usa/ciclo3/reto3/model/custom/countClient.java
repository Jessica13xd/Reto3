package com.usa.ciclo3.reto3.model.custom;

import com.usa.ciclo3.reto3.model.Client;

public class countClient {
    private Integer total;
    private Client client;

    public countClient(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
