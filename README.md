Hotel Management System

The Hotel Management System is a Java application designed to streamline the management of hotel operations. This system handles various functionalities including customer management, chalet management, reservations, services, and items, providing a user-friendly interface for effective management.

Features
•	Client Management: Manage client details such as contact information and personal data.
•	Chalet Management: Handle chalet information including location, capacity, and pricing.
•	Reservation Management: Track reservations with guest details, stay duration, and pricing.
•	Service Management: Manage additional services offered by the hotel.
•	Item Management: Track items available in each chalet.

-------------------------//---------------------------//---------------------------//----------------------------------//----------------------------//-------------------------

Project Structure

1. Data Access Objects (DAO)
DAO classes handle database interactions and CRUD operations:
•	ChaleDAO.java - Operations related to chalets.
•	Chale_ItemDAO.java - Management of items associated with chalets.
•	ClienteDAO.java - Operations related to clients.
•	HospedagemDAO.java - Operations related to reservations.
•	Hospedagem_ServicoDAO.java - Services related to reservations.
•	ItemDAO.java - Operations related to items.
•	ServicoDAO.java - Operations related to services.
•	TelefoneDAO.java - Management of client phone numbers.

2. Models
Model classes represent the data structures used in the application:
•	Chale.java - Chalet attributes like location and pricing.
•	Chale_Item.java - Items available in chalets.
•	Cliente.java - Client personal details.
•	Hospedagem.java - Reservation details.
•	Hospedagem_Servico.java - Services linked to reservations.
•	Item.java - Items that can be associated with chalets.
•	Servico.java - Hotel services.
•	Telefone.java - Client phone numbers.

3. User Interface (UI)
UI classes provide graphical forms for user interactions:
•	ChaleForm.java - Form for managing chalets.
•	Chale_ItemForm.java - Form for managing chalet items.
•	ClienteForm.java - Form for managing clients.
•	HospedagemForm.java - Form for managing reservations.
•	Hospedagem_ServicoForm.java - Form for managing reservation services.
•	ItemForm.java - Form for managing items.
•	ServicoForm.java - Form for managing services.
•	TelefoneForm.java - Form for managing phone numbers.

4. Utilities
Utility classes provide additional functionality:
•	DateUtils.java - Utility functions for date manipulation.

-------------------------//---------------------------//---------------------------//----------------------------------//----------------------------//-------------------------

Getting Started
Follow these steps to set up and run the Hotel Management System:

1.	Clone the Repository
git clone https://github.com/lucasjuniordev/hotel-management.git cd hotel-management

2.	Build the Project
Use Maven to build the project:
mvn clean install

3.	Run the Application
Execute the JAR file or run the main class to start the application. Ensure that all dependencies are correctly configured.
