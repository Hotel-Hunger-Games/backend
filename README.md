# Hotel Hunger Games

This is the repository for the Hotel Hunger Games application, a multi-tenant SaaS (Software as a Service) platform where hotels can auction their rooms for specific time periods. The application utilizes the following technologies:

- **Keycloak** for user authentication and verification.
- **Hibernate** for managing object-relational mapping (ORM) and database interactions.
- **Spring Boot** as the application framework.
- **PostgreSQL** as the relational database.
- **WebSockets** for live bidding functionality.

## Functionality

Hotel Hunger Games allows hotels to list their rooms for auction in specific time periods. Users can bid on the available rooms, and the highest bidder at the end of the auction wins the room. The application then sends an email confirmation to the winning bidder.