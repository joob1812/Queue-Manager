package com.queue.management.services;

import com.queue.management.models.Queue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class AdminService {

    private List<Queue> queues;

    public AdminService() {
        queues = new ArrayList<>();
        // Simuler quelques files d'attente
        Queue seneauQueue = new Queue("Seneau", "Dakar");
        queues.add(seneauQueue);

        Queue orangeQueue = new Queue("Orange", "Thiès");
        queues.add(orangeQueue);
    }

    public List<Queue> getAllQueues() {
        return queues;
    }

    public Queue getQueueByServiceAndLocation(String serviceName, String location) {
        for (Queue queue : queues) {
            if (queue.getServiceName().equals(serviceName) && queue.getLocation().equals(location)) {
                return queue;
            }
        }
        return null; // Si la queue n'existe pas
    }
}
