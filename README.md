Hotel Management System
Description
The Hotel Management System is a comprehensive Java application designed to manage various aspects of hotel operations. This system covers features such as handling customer information, managing chalets, reservations, services, and items. It provides a user-friendly interface for managing these components effectively.

Features
Client Management: Manage customer details including contact information and personal data.
Chalet Management: Handle chalet details, including location, capacity, and pricing.
Reservation Management: Track reservations, including guest information, stay duration, and pricing.
Service Management: Manage additional services offered by the hotel.
Item Management: Track items available in each chalet.
Project Structure
1. DAO (Data Access Objects)
DAO classes are responsible for interacting with the database to perform CRUD operations.

ChaleDAO.java: Handles operations related to chalets.
Chale_ItemDAO.java: Manages items associated with chalets.
ClienteDAO.java: Manages customer-related operations.
HospedagemDAO.java: Handles operations related to reservations.
Hospedagem_ServicoDAO.java: Manages services associated with reservations.
ItemDAO.java: Handles item operations.
ServicoDAO.java: Manages service operations.
TelefoneDAO.java: Handles phone number operations.
2. Models
Model classes represent the data structures used in the application.

Chale.java: Represents a chalet with attributes like location, capacity, and pricing.
Chale_Item.java: Represents items available in chalets.
Cliente.java: Represents a customer with personal details.
Hospedagem.java: Represents a reservation including details like check-in and check-out dates.
Hospedagem_Servico.java: Represents services associated with a reservation.
Item.java: Represents items that can be associated with chalets.
Servico.java: Represents services offered by the hotel.
Telefone.java: Represents phone numbers of customers.
3. User Interface (UI)
UI classes provide the graphical interface for interacting with the system.

ChaleForm.java: User interface for managing chalets.
Chale_ItemForm.java: User interface for managing chalet items.
ClienteForm.java: User interface for managing customers.
HospedagemForm.java: User interface for managing reservations.
Hospedagem_ServicoForm.java: User interface for managing services related to reservations.
ItemForm.java: User interface for managing items.
ServicoForm.java: User interface for managing services.
TelefoneForm.java: User interface for managing phone numbers.
4. Utilities
Utility classes provide helper functions for the application.

DateUtils.java: Contains utility functions for date manipulation.
Getting Started
To set up and run the Hotel Management System, follow these steps:

Clone the Repository

bash
Copiar código
git clone https://github.com/lucasjuniordev/hotel-management.git
cd hotel-management
Build the Project

Use Maven to build the project:

bash
Copiar código
mvn clean install
Run the Application

Run the main class or execute the JAR file to start the application. Ensure you have the necessary dependencies and configuration.
