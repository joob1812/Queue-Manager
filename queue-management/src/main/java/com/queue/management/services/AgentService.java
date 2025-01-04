package com.queue.management.services;

import com.queue.management.models.Queue;
import com.queue.management.models.Ticket;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private final AdminService adminService;

    public AgentService(AdminService adminService) {
        this.adminService = adminService;
    }

    // Méthode pour passer au client suivant
    public String nextClient(String serviceName, String location) {
        Queue queue = adminService.getQueueByServiceAndLocation(serviceName, location);
        if (queue != null) {
            // Vérifier s'il y a des tickets en attente
            if (!queue.getTickets().isEmpty()) {
                // Servir le premier client dans la file
                Ticket ticket = queue.getTickets().get(0);
                ticket.setCurrentServingNumber(ticket.getTicketNumber());

                // Déplacer le ticket de la file (optionnel si vous souhaitez garder l'historique)
                queue.getTickets().remove(0);

                // Ajouter le ticket dans un tableau de tickets servis (si nécessaire)
                // adminService.addServedTicket(ticket); // Exemple d'ajout dans un historique

                return "Le client suivant est servi avec le ticket numéro: " + ticket.getTicketNumber();
            } else {
                return "Aucun client en attente.";
            }
        }
        return "File d'attente non trouvée.";
    }

    // Méthode pour revenir au client précédent
    public String previousClient(String serviceName, String location) {
        Queue queue = adminService.getQueueByServiceAndLocation(serviceName, location);
        if (queue != null) {
            // Logique pour revenir au client précédent
            // Ceci nécessite de garder une trace des tickets précédents, par exemple en utilisant une pile
            if (!queue.getServedTickets().isEmpty()) {
                Ticket lastServedTicket = queue.getServedTickets().get(queue.getServedTickets().size() - 1);
                queue.getServedTickets().remove(queue.getServedTickets().size() - 1); // Supprimer le dernier ticket servi
                queue.getTickets().add(0, lastServedTicket); // Ajouter à la position de la file
                return "Retour au client précédent, ticket réintégré: " + lastServedTicket.getTicketNumber();
            }
            return "Aucun client précédent à revenir.";
        }
        return "File d'attente non trouvée.";
    }
}
